package com.example.mentorsjoy;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.AreaBreakType;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
public class gen {

    public static final String DEST = "results\\aboba.pdf";
    public static final String FONT = "res/raw/times_new_roman.ttf";
    public static final String FONT_BOLD = "res/raw/times_new_roman_bold.ttf";
    public static void createPdf(String dest, PdfData data) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf, PageSize.A4, false);
        document.setMargins(40, 20, 20, 20);

        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);
        PdfFont bold = PdfFontFactory.createFont(FONT_BOLD, PdfEncodings.IDENTITY_H);
        addAcceptancePage(data, document, font, bold);
        addTitlePage(data, document, font, bold);
        writeSections(document, font, bold);
        addChangesPage(document, font, bold);
        addHeaders(pdf, document, font, data);
        addFooters(pdf, document, font);
        //Close document
        document.close();
    }
    private static void addTitlePage(PdfData data, Document document, PdfFont font, PdfFont bold) {
        Table table2 = new Table(UnitValue.createPercentArray(new float[]{1, 1, 24})).useAllAvailableWidth();
        Cell main2 = new Cell(5, 1).setBorder(Border.NO_BORDER);
        main2.add(new Paragraph(String.format("\n\n\n%s\nТехническое задание\nRU.17701729.05.%s ТЗ 01-1\nЛистов 10", data.getProjectName(), data.getProjectType())).setFont(bold).setTextAlignment(TextAlignment.CENTER));
        table2.addCell(new Cell(1,3).add(new Paragraph("УТВЕРЖДЕН\nRU.17701729.05.15-01 ТЗ 01-1-ЛУ").setFont(font)).setHeight(200).setBorder(Border.NO_BORDER));
        table2.addCell(new Cell().add(new Paragraph("Подп. и дата").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table2.addCell(new Cell().add(new Paragraph(" ")));
        table2.addCell(main2);
        table2.addCell(new Cell().add(new Paragraph("Инв. № дубл.").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table2.addCell(new Cell().add(new Paragraph(" ")));
        table2.addCell(new Cell().add(new Paragraph("Взам. инв. №").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table2.addCell(new Cell().add(new Paragraph(" ")));
        table2.addCell(new Cell().add(new Paragraph("Подп. и дата").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table2.addCell(new Cell().add(new Paragraph(" ")));
        table2.addCell(new Cell().add(new Paragraph("Инв. № подл").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table2.addCell(new Cell().add(new Paragraph(" ")));
        document.add(table2);
    }

    private static void addAcceptancePage(PdfData data, Document document, PdfFont font, PdfFont bold) {
        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1, 12, 12})).useAllAvailableWidth();
        Cell pad = new Cell(1, 2);
        pad.add(new Paragraph(" "));
        pad.setBorder(Border.NO_BORDER);
        Cell row1 = new Cell(1,2).setBorder(Border.NO_BORDER);
        row1.add(new Paragraph("ПРАВИТЕЛЬСТВО РОССИЙСКОЙ ФЕДЕРАЦИИ\nНАЦИОНАЛЬНЫЙ ИССЛЕДОВАТЕЛЬСКИЙ УНИВЕРСИТЕТ «ВЫСШАЯ ШКОЛА ЭКОНОМИКИ»").setFont(bold).setTextAlignment(TextAlignment.CENTER));
        Cell row2 = new Cell(1,2).setBorder(Border.NO_BORDER);
        row2.add(new Paragraph("Факультет компьютерных наук\nОбразовательная программа «Программная инженерия»").setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row31 = new Cell().setBorder(Border.NO_BORDER);
        row31.add(new Paragraph("СОГЛАСОВАНО").setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row32 = new Cell().setBorder(Border.NO_BORDER);
        row32.add(new Paragraph("УТВЕРЖДАЮ").setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row41 = new Cell().setBorder(Border.NO_BORDER);
        row41.add(new Paragraph(data.getMentorTitle()).setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row42 = new Cell().setBorder(Border.NO_BORDER);
        row42.add(new Paragraph(data.getAcademicalTitle()).setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row51 = new Cell().setBorder(Border.NO_BORDER);
        row51.add(new Paragraph(data.getMentorName()).setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row52 = new Cell().setBorder(Border.NO_BORDER);
        row52.add(new Paragraph(data.getAcademicalName()).setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell main = new Cell(2, 2).setBorder(Border.NO_BORDER);
        main.add(new Paragraph(String.format("%s\nТехническое задание\nЛИСТ УТВЕРЖДЕНИЯ\nRU.17701729.05.%s ТЗ 01-1-ЛУ", data.getProjectName(), data.getProjectType())).setFont(bold).setTextAlignment(TextAlignment.CENTER));
        Cell sign = new Cell(1, 2).setBorder(Border.NO_BORDER);
        sign.add(new Paragraph(String.format("Исполнитель студент группы %s\n/%s/\n", data.getStudentGroup(), data.getStudentName())).setFont(font).setTextAlignment(TextAlignment.RIGHT));

        table.addCell(pad);
        table.addCell(row1);
        table.addCell(pad);
        table.addCell(row2);
        table.addCell(pad);
        table.addCell(row31);
        table.addCell(row32);
        table.addCell(pad);
        table.addCell(row41);
        table.addCell(row42);
        table.addCell(pad);
        table.addCell(row51);
        table.addCell(row52);
        table.addCell(new Cell().add(new Paragraph("Подп. и дата").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table.addCell(new Cell().add(new Paragraph(" ")));
        table.addCell(new Cell(1,2).add(new Paragraph(" ")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("Инв. № дубл.").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table.addCell(new Cell().add(new Paragraph(" ")));
        table.addCell(main);
        table.addCell(new Cell().add(new Paragraph("Взам. инв. №").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table.addCell(new Cell().add(new Paragraph(" ")));
        table.addCell(new Cell().add(new Paragraph("Подп. и дата").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table.addCell(new Cell().add(new Paragraph(" ")));
        table.addCell(new Cell(1,2).add(new Paragraph(" ")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("Инв. № подл").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table.addCell(new Cell().add(new Paragraph(" ")));
        table.addCell(sign);
        document.add(table);
        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
    }

    private static void writeSections(Document document, PdfFont font, PdfFont bold) {
        Section temp = new Section();
        for (int i = 0; i < 8; i++) {
            document.add(new Paragraph(temp.title).setFont(bold).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph(temp.paragraphs[0]).setFont(font));
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        }
    }
    private static void addHeaders(PdfDocument pdf, Document doc, PdfFont font, PdfData data) {
        for (int i = 3; i <= pdf.getNumberOfPages(); i++) {
            Paragraph pageNum = new Paragraph(String.format("%d", i - 1))
                    .setFont(font)
                    .setFontSize(12);
            Paragraph header = new Paragraph(String.format("RU.17701729.05.%s ТЗ 01-1-ЛУ", data.getProjectType()))
                    .setFont(font)
                    .setFontSize(12);
            Rectangle pageSize = pdf.getPage(i).getPageSize();
            float x = pageSize.getWidth() / 2;
            float y = pageSize.getTop() - 20;
            doc.showTextAligned(pageNum, x, y, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
            x = pageSize.getWidth() / 2;
            y = pageSize.getTop() - 40;
            doc.showTextAligned(header, x, y, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
        }
    }
    private static void addFooters(PdfDocument pdf, Document doc, PdfFont font) {
        for (int i = 3; i <= pdf.getNumberOfPages() - 1; i++) {
            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 2, 1})).useAllAvailableWidth();
            table.addCell(new Cell().add(new Paragraph("Номер изменения").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("Подпись ответственного за внесение изменения").setFont(font)));
            table.addCell(new Cell().add(new Paragraph("Дата внесения изменения").setFont(font)));
            for (int j = 0; j < 3; j++) {
                table.addCell(new Cell().setHeight(20));
            }
            Rectangle pageSize = pdf.getPage(i).getPageSize();
            float x = pageSize.getLeft() + 20;
            float y = pageSize.getBottom() + 20;
            table.setFixedPosition(i, x, y, pageSize.getWidth() - 40);
            doc.add(table);
        }
    }
    private static void addChangesPage(Document document, PdfFont font, PdfFont bold) {
        document.add(new Paragraph("ЛИСТ РЕГИСТРАЦИИ ИЗМЕНЕНИЙ").setTextAlignment(TextAlignment.CENTER).setFont(bold));
        Table table = new Table(10).useAllAvailableWidth();
        table.addCell(new Cell(1, 5).add(new Paragraph("Номера листов (страниц)").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Всего листов (страниц в документе)").setFont(font).setRotationAngle(1.57)).setHeight(150));
        table.addCell(new Cell().add(new Paragraph("Номер документа").setFont(font).setRotationAngle(1.57)).setHeight(150));
        table.addCell(new Cell().add(new Paragraph("Входящий номер сопр. документа и дата").setFont(font).setRotationAngle(1.57)).setHeight(150));
        table.addCell(new Cell().add(new Paragraph("Подп.").setFont(font).setRotationAngle(1.57)).setHeight(150));
        table.addCell(new Cell().add(new Paragraph("Дата").setFont(font).setRotationAngle(1.57)).setHeight(150));
        table.addCell(new Cell().add(new Paragraph("Изм.").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Изменен\nных").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Заменен\nных").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Нов\nых").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Аннулиро\nванных").setFont(font)));
        for (int i = 0; i < 105; i++) {
            table.addCell(new Cell().setHeight(20));
        }
        document.add(table);
    }
}
