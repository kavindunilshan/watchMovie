package com.example.watchMovie.emailStarergy;
import com.example.watchMovie.resources.PdfCreator;
import org.springframework.beans.factory.annotation.Value;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SMTPEmailStrategy extends EmailSenderStrategy {

    @Value("${spring.mail.username}")
    private static String username;

    @Value("${spring.mail.password}")
    private static String password;

    public SMTPEmailStrategy() {
    }

    public SMTPEmailStrategy(String email, String subject, String content) {
        super(email, subject, content);
    }

    @Override
    public void sendEmail() {

//        final String username = "kavinilj10@gmail.com";
//        final String password = "qfshespookvyxpor";

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

            PdfCreator.createPDF(content);

            // ================================
            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Text content
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Tickets booked successfully.\n\n\t" +
                    "Lights, camera, action!" +
                    " It's time to get ready for an unforgettable cinematic experience with WatchMovie." +
                    " We're thrilled to have you on board, and your ticket is now ready for the showtime!" +
                    "\nFind your ticket in attachment." +
                    "\n\nThanks For Booking With Us!!");

            // Attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String attachmentPath = "E:\\watchMovie\\src\\main\\java\\com\\example\\watchMovie\\resources\\examples.pdf"; // Replace with the actual file path
            DataSource source = new FileDataSource(attachmentPath);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("attachment.pdf"); // Set the desired file name for the attachment

            // Add text and attachment to the multipart message
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            // Set the multipart message as the email's content
            message.setContent(multipart);
            System.out.println("Started to create a pdf");

            // ================================

            Transport.send(message);

            System.out.println("Successfully sent an email to " + email);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
