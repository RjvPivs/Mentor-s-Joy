package com.example.mentorsjoy;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.io.File;
import java.io.IOException;
public class gen {

    public static final String DEST = "results\\aboba.pdf";
    public static final String FONT = "res/raw/times_new_roman.ttf";
    public static final String FONT_BOLD = "res/raw/times_new_roman_bold.ttf";
    public static void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(20, 20, 20, 20);

        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);
        PdfFont bold = PdfFontFactory.createFont(FONT_BOLD, PdfEncodings.IDENTITY_H);
        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1, 12, 12})).useAllAvailableWidth();
        Cell pad = new Cell(1, 2);
        pad.add(new Paragraph(" "));
        pad.setBorder(Border.NO_BORDER);
        Cell row1 = new Cell(1,2);
        row1.add(new Paragraph("ПРАВИТЕЛЬСТВО РОССИЙСКОЙ ФЕДЕРАЦИИ\nНАЦИОНАЛЬНЫЙ ИССЛЕДОВАТЕЛЬСКИЙ УНИВЕРСИТЕТ «ВЫСШАЯ ШКОЛА ЭКОНОМИКИ»").setFont(bold).setTextAlignment(TextAlignment.CENTER));
        Cell row2 = new Cell(1,2);
        row2.add(new Paragraph("Факультет компьютерных наук\nОбразовательная программа «Программная инженерия»").setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row31 = new Cell();
        row31.add(new Paragraph("СОГЛАСОВАНО").setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row32 = new Cell();
        row32.add(new Paragraph("УТВЕРЖДАЮ").setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row41 = new Cell();
        row41.add(new Paragraph("Приглашённый преподаватель департамента программной инженерии факультетакомпьютерных наук").setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row42 = new Cell();
        row42.add(new Paragraph("Академический руководитель образовательной программы «Программная инженерия», профессор департамента программной инженерии, кандидат технических наук").setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row51 = new Cell();
        row51.add(new Paragraph("Aboba").setFont(font));
        Cell row52 = new Cell();
        row52.add(new Paragraph("Aboba").setFont(font));
        Cell main = new Cell(2, 2);
        main.add(new Paragraph("Генератор документации «Радость научника»\nТехническое задание\nЛИСТ УТВЕРЖДЕНИЯ\nRU.17701729.05.15-01 ТЗ 01-1-ЛУ").setFont(bold).setTextAlignment(TextAlignment.CENTER));
        Cell sign = new Cell(1, 2);
        sign.add(new Paragraph("Исполнитель студент группы БПИ 206\n" +
                "\t /В. А. Астафуров/\n").setFont(font).setTextAlignment(TextAlignment.RIGHT));

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
        table.addCell(new Cell(1,2).add(new Paragraph(" ")));
        table.addCell(new Cell().add(new Paragraph("Инв. № дубл.").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table.addCell(new Cell().add(new Paragraph(" ")));
        table.addCell(main);
        table.addCell(new Cell().add(new Paragraph("Взам. инв. №").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table.addCell(new Cell().add(new Paragraph(" ")));
        table.addCell(new Cell().add(new Paragraph("Подп. и дата").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table.addCell(new Cell().add(new Paragraph(" ")));
        table.addCell(new Cell(1,2).add(new Paragraph(" ")));
        table.addCell(new Cell().add(new Paragraph("Инв. № подл").setFont(font).setRotationAngle(1.57)).setHeight(100));
        table.addCell(new Cell().add(new Paragraph(" ")));
        table.addCell(sign);
        document.add(table);

        //Close document
        document.close();
    }
}
