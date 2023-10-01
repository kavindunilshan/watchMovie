package com.example.watchMovie.emailStarergy;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SMTPEmailStrategy extends EmailSenderStrategy {
    public SMTPEmailStrategy() {
    }

    public SMTPEmailStrategy(String email, String subject, String content) {
        super(email, subject, content);
    }

    @Override
    public void sendEmail() {

        final String username = "kavinilj10@gmail.com";
        final String password = "qfshespookvyxpor";

        Properties prop = new Properties();

        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("kavinilj10@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email));

            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Successfully sent an email to " + email);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
