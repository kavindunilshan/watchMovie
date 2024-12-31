package com.example.watchMovie.resources;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PdfCreator {

    public static String createPDF(String content) throws IOException {
        // Generate a unique file name with timestamp
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String dest = "src/main/java/com/example/watchMovie/resources/MovieTicket_" + timestamp + ".pdf";

        // Path to your logo and end image
        String logoPath = "src/main/java/com/example/watchMovie/resources/logo.png"; // Adjust the path to your logo
        String endImagePath = "src/main/java/com/example/watchMovie/resources/img.png"; // Adjust the path to your end image

        // Create a writer instance
        PdfWriter writer = new PdfWriter(dest);

        // Initialize a PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Create a document to add layout
        Document document = new Document(pdf);

        // Add the logo to the start
        ImageData logoData = ImageDataFactory.create(logoPath);
        Image logo = new Image(logoData).setWidth(300).setHeight(100);
        document.add(logo);

        // Add a title with a larger font size and bold style
        Text title = new Text("🎬 Watch Movie Tickets 🎟️")
                .setFontSize(24);

        Paragraph titleParagraph = new Paragraph(title)
                .setMarginBottom(20);
        document.add(titleParagraph);

        // Add the content string as a paragraph
        Paragraph contentParagraph = new Paragraph(content)
                .setFontSize(14);
        document.add(contentParagraph);

        // Add the image to the end
        ImageData endImageData = ImageDataFactory.create(endImagePath);
        Image endImage = new Image(endImageData).setWidth(400).setHeight(400);
        document.add(endImage);

        // Close the document
        document.close();
        System.out.println("PDF created successfully at " + dest);

        // Return the file path for attachment
        return dest;
    }
}
