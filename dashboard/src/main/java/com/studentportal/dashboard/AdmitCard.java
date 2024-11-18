package com.studentportal.dashboard;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class AdmitCard {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private static void drawTable(PDDocument document, PDPageContentStream contentStream, PDPage page, float startX, float startY, String centreName, String rollNo, String studentName,
                                  String normalfontPath) {

        final int rows = 3;
        final int cols = 2;


        float tableWidth = 450;
        float rowHeight = 30;
        float margin = 10;


        float firstColWidth = 120;
        float remainingWidth = tableWidth - firstColWidth;
        float colWidth = remainingWidth / (float) (cols - 1);

        try {

            for (int i = 0; i <= rows; i++) {
                contentStream.moveTo(startX, startY - (i * rowHeight));
                contentStream.lineTo(startX + tableWidth, startY - (i * rowHeight));
                contentStream.stroke();
            }
            contentStream.moveTo(startX + firstColWidth, startY);
            contentStream.lineTo(startX + firstColWidth, startY - (rows * rowHeight));
            contentStream.stroke();
            for (int i = 1; i < cols; i++) {
                contentStream.moveTo(startX + (firstColWidth + i * colWidth), startY);
                contentStream.lineTo(startX + (firstColWidth + i * colWidth), startY - (rows * rowHeight));
                contentStream.stroke();
            }
            for (int i = 0; i < rows; i++) {
                contentStream.moveTo(startX, startY - (i * rowHeight));
                contentStream.lineTo(startX, startY - ((i + 1) * rowHeight));
                contentStream.stroke();
            }

            String[] data = {"केद्ं का नाम", "परीक्षा का नम्बर", "नाम"};
            String[] additionalData = {centreName, rollNo, studentName};

            for (int i = 0; i < 3; i++) {
                contentStream.beginText();
                contentStream.setFont(PDType0Font.load(document, new File(normalfontPath)), 10);
                contentStream.newLineAtOffset(startX + 10, startY - (i * rowHeight) - 15);
                contentStream.showText(data[i]);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 8);
                contentStream.newLineAtOffset(startX + 130, startY - (i * rowHeight) - 15);
                contentStream.showText(additionalData[i]);
                contentStream.endText();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawSecondTable(PDDocument document, PDPageContentStream contentStream, PDPage page, float startX, float startY, String motherName, String fatherName, String clas, String schoolName,
                                        String normalfontPath) {
        final int rows = 5;
        final int cols = 2;


        float tableWidth = 330;
        float rowHeight = 30;
        float margin = 10;


        float firstColWidth = 120;
        float remainingWidth = tableWidth - firstColWidth;
        float colWidth = remainingWidth / (float) (cols - 1);

        try {

            for (int i = 0; i <= rows; i++) {
                contentStream.moveTo(startX, startY - (i * rowHeight));
                contentStream.lineTo(startX + tableWidth, startY - (i * rowHeight));
                contentStream.stroke();
            }
            contentStream.moveTo(startX + firstColWidth, startY);
            contentStream.lineTo(startX + firstColWidth, startY - (rows * rowHeight));
            contentStream.stroke();
            for (int i = 1; i < cols; i++) {
                contentStream.moveTo(startX + (firstColWidth + i * colWidth), startY);
                contentStream.lineTo(startX + (firstColWidth + i * colWidth), startY - (rows * rowHeight));
                contentStream.stroke();
            }
            for (int i = 0; i < rows; i++) {
                contentStream.moveTo(startX, startY - (i * rowHeight));
                contentStream.lineTo(startX, startY - ((i + 1) * rowHeight));
                contentStream.stroke();
            }

            String[] data = {"माता का नाम", "पिता का नाम", "कक्षा", "विद्यालय का नाम", "बलॉक"};
            String[] additionalData = {motherName, fatherName, clas, schoolName, schoolName};
            float secondColumnX = startX + 130;

            for (int i = 0; i < data.length; i++) {
                contentStream.beginText();
                contentStream.setFont(PDType0Font.load(document, new File(normalfontPath)), 10);
                contentStream.newLineAtOffset(startX + 10, startY - (i * rowHeight) - 15);
                contentStream.showText(data[i]);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 8);
                contentStream.newLineAtOffset(secondColumnX, startY - (i * rowHeight) - 15);
                contentStream.showText(additionalData[i]);
                contentStream.endText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawThirdTable(PDDocument document, PDPageContentStream contentStream, PDPage page, float startX, float startY, String district, String gender, String category,
                                       String normalfontPath) {
        final int rows = 2;
        final int cols = 4;

        float rowHeight = 30;
        float margin = 10;

        float firstColWidth = 120;
        float secondColWidth = 100;
        float thirdColWidth = 110;
        float fourthColWidth = 120;

        float tableWidth = firstColWidth + secondColWidth + thirdColWidth + fourthColWidth;

        try {

            for (int i = 0; i <= rows; i++) {
                contentStream.moveTo(startX, startY - (i * rowHeight));
                contentStream.lineTo(startX + tableWidth, startY - (i * rowHeight));
                contentStream.stroke();
            }

            contentStream.moveTo(startX + firstColWidth, startY);
            contentStream.lineTo(startX + firstColWidth, startY - (rows * rowHeight));
            contentStream.stroke();

            contentStream.moveTo(startX + firstColWidth + secondColWidth, startY);
            contentStream.lineTo(startX + firstColWidth + secondColWidth, startY - (rows * rowHeight));
            contentStream.stroke();

            contentStream.moveTo(startX + firstColWidth + secondColWidth + thirdColWidth, startY);
            contentStream.lineTo(startX + firstColWidth + secondColWidth + thirdColWidth, startY - (rows * rowHeight));
            contentStream.stroke();

            contentStream.moveTo(startX + tableWidth, startY);
            contentStream.lineTo(startX + tableWidth, startY - (rows * rowHeight));
            contentStream.stroke();

            for (int i = 0; i < rows; i++) {
                contentStream.moveTo(startX, startY - (i * rowHeight));
                contentStream.lineTo(startX, startY - ((i + 1) * rowHeight));
                contentStream.stroke();
            }

            String[] data = {" िज़ला", " िलंग"};
            String[] data1 = {district, gender};
            String[] thirdColData = {" िवद्यार्थी का हस्ताक्षर", "कोिट"};
            String[] thirdColdata2 = {"", category};

            for (int i = 0; i < rows; i++) {
                contentStream.beginText();
                contentStream.setFont(PDType0Font.load(document, new File(normalfontPath)), 10);
                contentStream.newLineAtOffset(startX + 10, startY - (i * rowHeight) - 15);
                contentStream.showText(data[i]);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 8);
                contentStream.newLineAtOffset(startX + 130, startY - (i * rowHeight) - 15);
                contentStream.showText(data1[i]);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType0Font.load(document, new File(normalfontPath)), 10);
                contentStream.newLineAtOffset(startX + firstColWidth + secondColWidth + 15, startY - (i * rowHeight) - 15);
                contentStream.showText(thirdColData[i]);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 8);
                contentStream.newLineAtOffset(startX + firstColWidth + secondColWidth + 120, startY - (i * rowHeight) - 15);
                contentStream.showText(thirdColdata2[i]);
                contentStream.endText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drawFourthTable(PDDocument document, PDPageContentStream contentStream, PDPage page, float startX, float startY, String subject,
                                        String normalfontPath) {
        final int rows = 5;
        final int cols = 2;
        float tableWidth = 450;
        float rowHeight = 30;
        float margin = 10;

        float firstColWidth = 120;
        float remainingWidth = tableWidth - firstColWidth;
        float colWidth = remainingWidth / (float) (cols - 1);

        try {

            for (int i = 0; i <= rows; i++) {
                contentStream.moveTo(startX, startY - (i * rowHeight));
                contentStream.lineTo(startX + tableWidth, startY - (i * rowHeight));
                contentStream.stroke();
            }
            contentStream.moveTo(startX + firstColWidth, startY);
            contentStream.lineTo(startX + firstColWidth, startY - (rows * rowHeight));
            contentStream.stroke();
            for (int i = 1; i < cols; i++) {
                contentStream.moveTo(startX + (firstColWidth + i * colWidth), startY);
                contentStream.lineTo(startX + (firstColWidth + i * colWidth), startY - (rows * rowHeight));
                contentStream.stroke();
            }
            for (int i = 0; i < rows; i++) {
                contentStream.moveTo(startX, startY - (i * rowHeight));
                contentStream.lineTo(startX, startY - ((i + 1) * rowHeight));
                contentStream.stroke();
            }

            String[] data = {"िवषय -1", "िवषय -2", "िवषय  -3", "िवषय -4", "िवषय -5"};

            for (int i = 0; i < 5; i++) {
                contentStream.beginText();
                contentStream.setFont(PDType0Font.load(document, new File(normalfontPath)), 10);
                contentStream.newLineAtOffset(startX + 10, startY - (i * rowHeight) - 15);
                contentStream.showText(data[i]);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 8);
                contentStream.newLineAtOffset(startX + 130, startY - (i * rowHeight) - 15);
                if (i == 0) {
                    contentStream.showText(subject);
                }
                contentStream.endText();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] createPdf(String rollNo, String studentName, String motherName, String fatherName, String centreName, String gender, String dob, String category, String mobileno, String school, String clas, String subject, String nameOfDistrict) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);


        String imagePath = "src/main/webapp/images/jcert.png";
        String normalfontPath = "src/main/resources/Noto-Sans-Devanagari-Regular/NotoSansDevanagari-Regular.ttf";
        String boldfontPath = "src/main/resources/Noto-Sans-Devanagari-Regular/NotoSansDevanagari-Regular.ttf";


        File normalFontFile = new File(normalfontPath);
        if (!normalFontFile.exists()) {
            throw new IOException("Font file not found: " + normalfontPath);
        }

        PDType0Font customFont = null;
        try {
            customFont = PDType0Font.load(document, normalFontFile);
        } catch (IOException e) {
            logger.error("Failed to load the font: {}", normalfontPath, e);
            throw new IOException("Font loading error: " + normalfontPath, e);
        }

//customFont = PDType0Font.load(document, new File(normalfontPath));
        PDType0Font customFontBold = PDType0Font.load(document, new File(boldfontPath));

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

            PDImageXObject image = PDImageXObject.createFromFile(imagePath, document);
            float imageWidth = image.getWidth();
            float imageHeight = image.getHeight();
            float imageX = 70;
            float imageY = 720;
            contentStream.drawImage(image, imageX, imageY, 90, 90);

            contentStream.beginText();
            contentStream.setFont(customFontBold, 14);
            contentStream.newLineAtOffset(170, 780);
            contentStream.showText("झारखंड शैक्षिक अनुसंधान एवं प्रशिक्षण परिषद, राँची");
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(customFontBold, 12);
            contentStream.newLineAtOffset(220, 760);
            contentStream.showText("झारखंड राज्य ओलंपियाड परीक्षा- 2022");
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont(customFontBold, 12);
            contentStream.newLineAtOffset(305, 740);
            contentStream.showText("प्रवेश पत्र");
            contentStream.endText();

            drawTable(document, contentStream, page, 70, 720, centreName, rollNo, studentName, normalfontPath);


            float rectX = 400;
            float rectY = 480;
            float rectWidth = 120;
            float rectHeight = 150;

            contentStream.setStrokingColor(0, 0, 0);
            contentStream.setLineWidth(1);
            contentStream.addRect(rectX, rectY, rectWidth, rectHeight);
            contentStream.stroke();

            contentStream.beginText();
            contentStream.setFont(customFont, 8);
            contentStream.newLineAtOffset(415, 570);
            contentStream.showText("पपासपोर्ट साइज का फोटो");
            contentStream.endText();

            drawSecondTable(document, contentStream, page, 70, 630, motherName, fatherName, clas, school, normalfontPath);

            drawThirdTable(document, contentStream, page, 70, 480, nameOfDistrict, gender, category, normalfontPath);

            drawFourthTable(document, contentStream, page, 70, 420, subject, normalfontPath);


            String signature1 = "src/main/webapp/images/Signature1.png";

            PDImageXObject pdImage = PDImageXObject.createFromFile(signature1, document);


            float imageX1 = 105;
            float imageY1 = 190;
            float imageWidth1 = 70;
            float imageHeight1 = 50;


            contentStream.drawImage(pdImage, imageX1, imageY1, imageWidth1, imageHeight1);

            contentStream.beginText();
            contentStream.setFont(customFont, 10);
            contentStream.newLineAtOffset(105, 175);
            contentStream.showText("परीक्षा नियंत्रक");
            contentStream.endText();

            String signature2 = "src/main/webapp/images/Signature2.png";

            PDImageXObject pdImage1 = PDImageXObject.createFromFile(signature2, document);


            float imageX2 = 395;
            float imageY2 = 190;
            float imageWidth2 = 70;
            float imageHeight2 = 50;


            contentStream.drawImage(pdImage1, imageX2, imageY2, imageWidth2, imageHeight2);

            contentStream.beginText();
            contentStream.setFont(customFont, 10);
            contentStream.newLineAtOffset(370, 175);
            contentStream.showText("प्रधानाचार्य का हस्ताक्षर");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(customFont, 10);
            contentStream.newLineAtOffset(400, 160);
            contentStream.showText("मुहर सहित");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(customFontBold, 10);
            contentStream.newLineAtOffset(60, 130);
            contentStream.showText("नोट");
            contentStream.endText();


            contentStream.beginText();
            contentStream.setFont(customFontBold, 10);
            contentStream.newLineAtOffset(60, 110);
            contentStream.showText("1. अभ्यर्थी अपने उत्तर पत्रक के क्रमांक नं॰ 1 से 7 में सही जानकारी लिखे ।");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(customFontBold, 10);
            contentStream.newLineAtOffset(60, 90);
            contentStream.showText("2. यदि कोई अभ्यर्थी अपना अनुक्रमांक गलत अंकित करता है तो उसका उत्तर पत्रक अमान्य हो जाएगा");
            contentStream.endText();


            contentStream.beginText();
            contentStream.setFont(customFontBold, 10);
            contentStream.newLineAtOffset(65, 70);
            contentStream.showText(" एवं उसकी जांच नहीं की जाएगी ।");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(customFontBold, 10);
            contentStream.newLineAtOffset(60, 50);
            contentStream.showText("3. अभ्यर्थी अपने उत्तर पत्रक पर हस्ताक्षर करना व दाहिने हाथ के अंगूठे का निशान केवल निरीक्षक  ");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(customFontBold, 10);
            contentStream.newLineAtOffset(68, 30);
            contentStream.showText("की उपस्थिती मे देना सुनिश्चित करें । ");
            contentStream.endText();

        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.save(outputStream);
        document.close();

        return outputStream.toByteArray();
    }
}

