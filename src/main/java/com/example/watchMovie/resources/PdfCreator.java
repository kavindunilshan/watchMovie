package com.example.watchMovie.resources;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class PdfCreator {

    public static void createPDF(String content) {
        try {
            // Create a new PDF document
            PDDocument document = new PDDocument();

            // Create a new page
            PDPage page = new PDPage();
            document.addPage(page);

            // Create a content stream for the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set the font and font size
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // Define the text to write
            String text = "Watch Movie" + content;

            // Set the position for the text (x, y coordinates)
            float x = 100;
            float y = 700;

            // Write the text to the page
            contentStream.beginText();
            contentStream.newLineAtOffset(x, y);
            contentStream.showText(text);
            contentStream.endText();

            // Close the content stream
            contentStream.close();

            // Save the PDF to a file
            document.save("E:\\watchMovie\\src\\main\\java\\com\\example\\watchMovie\\resources\\examples.pdf");

            // Close the PDF document
            document.close();

            System.out.println("PDF created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


