package com.example.watchMovie.emailStarergy;

import com.example.watchMovie.resources.PdfCreator;
import io.github.cdimascio.dotenv.Dotenv;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class SMTPEmailStrategy extends EmailSenderStrategy {

    public SMTPEmailStrategy() {
    }

    public SMTPEmailStrategy(String email, String subject, String content) {
        super(email, subject, content);
    }

    @Override
    public void sendEmail() throws IOException {
        Dotenv dotenv = Dotenv.load();

        String username = dotenv.get("EMAIL");
        String password = dotenv.get("PASSWORD");

        if (username == null || password == null) {
            throw new IllegalStateException("Email credentials are missing in the .env file.");
        }

        System.out.println("Using email: " + username);

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password); // Use App Password
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Use the sender's email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);

            // Generate PDF for attachment
            PdfCreator.createPDF(content);
            System.out.println("PDF successfully created.");

            // Build multipart email content
            Multipart multipart = new MimeMultipart();
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(
                    "Tickets booked successfully.\n\n" +
                            "Lights, camera, action! Get ready for an unforgettable cinematic experience with WatchMovie.\n" +
                            "We're thrilled to have you on board! Your ticket is now ready for showtime.\n\n" +
                            "Please find your ticket attached.\n\n" +
                            "Thanks for booking with us!");


            // Attachment part
            MimeBodyPart attachmentPart = new MimeBodyPart();

            String pdfPath = PdfCreator.createPDF(content); // Generate the PDF
            Path attachmentPath = Paths.get(pdfPath);
            DataSource source = new FileDataSource(attachmentPath.toFile());
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName("MovieTicket.pdf");

            // Add parts to the multipart message
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            // Set email content
            message.setContent(multipart);

            System.out.println("Preparing to send email...");
            Transport.send(message);
            System.out.println("Successfully sent an email to " + email);

        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
            throw new RuntimeException("Email sending failed", e);
        }
    }
}
