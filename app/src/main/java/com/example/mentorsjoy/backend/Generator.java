package com.example.mentorsjoy.backend;

import com.example.mentorsjoy.model.PdfData;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

public class Generator {

    public static final String DEST = "results\\aboba.pdf";
    public static final String FONT = "res/font/times_new_roman.ttf";
    public static final String FONT_BOLD = "res/font/times_new_roman_bold.ttf";
    public static final String CURRENT_YEAR = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    public static final String CURRENT_MONTH = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    public static final String CURRENT_DAY = String.valueOf(Calendar.getInstance().get(Calendar.DATE));

    public static void createPdf(String dest, PdfData data, Section[] sections, String presetString) throws IOException {
        PdfPreset preset = new PdfPreset();
        preset.SetTypeName(presetString);
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf, PageSize.A4, false);
        document.setMargins(40, 30, 20, 30);
        document.setFontSize(12);
        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H);
        PdfFont bold = PdfFontFactory.createFont(FONT_BOLD, PdfEncodings.IDENTITY_H);

        addAcceptancePage(data, preset, document, font, bold);
        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        addTitlePage(data, preset, document, font, bold);
        document.setMargins(60, 40, 80, 40);
        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

        writeSections(document, sections, font, bold);
        addSourcesPage(document, font, bold);
        document.setMargins(60, 30, 20, 30);
        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        addChangesPage(document, font, bold);
        addHeaders(pdf, preset, document, font, data);
        addFooters(pdf, document, font);
        //Close document
        document.close();
    }

    private static void addTitlePage(PdfData data, PdfPreset preset, Document document, PdfFont font, PdfFont bold) {
        Table table2 = new Table(UnitValue.createPercentArray(new float[]{1, 1, 24})).useAllAvailableWidth();
        Cell main2 = new Cell(5, 1).setBorder(Border.NO_BORDER);
        main2.add(new Paragraph(String.format("\n\n\n%s\n\n%s\n\nRU.17701729.%s-01 %s 01-1\n\nЛистов X", data.getProjectName(), preset.getDocName(), data.getProjectType(), preset.getDocCode())).setFont(bold).setTextAlignment(TextAlignment.CENTER));
        table2.addCell(new Cell(1,3).add(new Paragraph(String.format("УТВЕРЖДЕН\nRU.17701729.%s-01 %s 01-1-ЛУ", data.getProjectType(), preset.getDocCode())).setFont(font).setFirstLineIndent(50F)).setHeight(200).setBorder(Border.NO_BORDER));
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

    private static void addAcceptancePage(PdfData data, PdfPreset preset, Document document, PdfFont font, PdfFont bold) {
        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1, 12, 12})).useAllAvailableWidth();
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
        row51.add(new Paragraph(String.format("__________%s\n«_»__________%s г.", data.getMentorName(), CURRENT_YEAR)).setFont(font).setTextAlignment(TextAlignment.CENTER));
        Cell row52 = new Cell().setBorder(Border.NO_BORDER);
        row52.add(new Paragraph(String.format("__________%s\n«_»__________%s г.", data.getAcademicalName(), CURRENT_YEAR)).setFont(font).setTextAlignment(TextAlignment.CENTER));

        Cell main = new Cell(2, 2).setBorder(Border.NO_BORDER);
        main.add(new Paragraph(String.format("%s\n\n%s\n\nЛИСТ УТВЕРЖДЕНИЯ\n\nRU.17701729.%s-01 %s 01-1-ЛУ", data.getProjectName(), preset.getDocName(), data.getProjectType(), preset.getDocCode())).setFont(bold).setTextAlignment(TextAlignment.CENTER));
        Cell sign = new Cell(1, 2).setBorder(Border.NO_BORDER);
        sign.add(new Paragraph(String.format("Исполнитель студент группы %s\n_____________/%s/\n%s %s %s", data.getStudentGroup(), data.getStudentName(), CURRENT_DAY, CURRENT_MONTH, CURRENT_YEAR)).setFont(font).setTextAlignment(TextAlignment.RIGHT));

        table.addCell(new Cell(1, 2).add(new Paragraph(" ")).setBorder(Border.NO_BORDER));
        table.addCell(row1);
        table.addCell(new Cell(1, 2).add(new Paragraph(" ")).setBorder(Border.NO_BORDER));
        table.addCell(row2);
        table.addCell(new Cell(1, 2).add(new Paragraph(" ")).setBorder(Border.NO_BORDER));
        table.addCell(row31);
        table.addCell(row32);
        table.addCell(new Cell(1, 2).add(new Paragraph(" ")).setBorder(Border.NO_BORDER));
        table.addCell(row41);
        table.addCell(row42);
        table.addCell(new Cell(1, 2).add(new Paragraph(" ")).setBorder(Border.NO_BORDER));
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
    }

    private static void writeSections(Document document, Section[] sections, PdfFont font, PdfFont bold) {
        for (int i = 0; i < sections.length; i++) {
            document.add(new Paragraph(String.format("%d. %s", i + 1, sections[i].title)).setFont(bold).setTextAlignment(TextAlignment.CENTER).setMarginBottom(10F));
            if (sections[i].size == 0) {
                writeSpecialSection(document, font, bold);
            }
            for (int j = 0; j < sections[i].size; j++) {
                if (sections[i].size > 1) {
                    document.add(new Paragraph(String.format("%d.%d. %s", i + 1, j + 1, sections[i].subtitles[j])).setFont(bold).setMarginLeft(40F).setMarginBottom(10F).setMarginTop(10F));
                }
                String[] subparagraphs = sections[i].paragraphs[j].split("\n");
                for (int l = 0; l < subparagraphs.length; l++) {
                    document.add(new Paragraph(subparagraphs[l]).setFont(font).setFirstLineIndent(30F).setMarginLeft(40F).setTextAlignment(TextAlignment.JUSTIFIED).setMultipliedLeading(1.5F).setSpacingRatio(1F).setMarginBottom(0F).setMarginTop(0F));
                }
            }
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        }
    }
    private static void addHeaders(PdfDocument pdf, PdfPreset preset, Document doc, PdfFont font, PdfData data) {
        for (int i = 3; i <= pdf.getNumberOfPages(); i++) {
            Paragraph pageNum = new Paragraph(String.format("%d", i - 1))
                    .setFont(font)
                    .setFontSize(12)
                    .setFontColor(ColorConstants.BLACK, 0.5F);
            Paragraph header = new Paragraph(String.format("RU.17701729.%s-01 %s 01-1", data.getProjectType(), preset.getDocCode()))
                    .setFont(font)
                    .setFontSize(12)
                    .setFontColor(ColorConstants.BLACK, 0.5F);
            Rectangle pageSize = pdf.getPage(i).getPageSize();
            float x = pageSize.getWidth() / 2;
            float y = pageSize.getTop() - 30;
            doc.showTextAligned(pageNum, x, y, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
            x = pageSize.getWidth() / 2;
            y = pageSize.getTop() - 50;
            doc.showTextAligned(header, x, y, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
        }
    }
    private static void addFooters(PdfDocument pdf, Document doc, PdfFont font) {
        for (int i = 1; i <= 2; i++) {
            Paragraph footer = new Paragraph(String.format("%s", CURRENT_YEAR))
                    .setFont(font)
                    .setFontSize(12);
            Rectangle pageSize = pdf.getPage(i).getPageSize();
            float x = pageSize.getWidth() / 2;
            float y = pageSize.getBottom() + 20;
            doc.showTextAligned(footer, x, y, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
        }
        for (int i = 3; i <= pdf.getNumberOfPages() - 1; i++) {
            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 2, 1})).useAllAvailableWidth();
            table.addCell(new Cell().add(new Paragraph("Номер изменения").setFont(font)).setFontColor(ColorConstants.BLACK, 0.5F).setBorder(new SolidBorder(ColorConstants.BLACK, 1, 0.5F)));
            table.addCell(new Cell().add(new Paragraph("Подпись ответственного за внесение изменения").setFont(font)).setFontColor(ColorConstants.BLACK, 0.5F).setBorder(new SolidBorder(ColorConstants.BLACK, 1, 0.5F)));
            table.addCell(new Cell().add(new Paragraph("Дата внесения изменения").setFont(font)).setFontColor(ColorConstants.BLACK, 0.5F).setBorder(new SolidBorder(ColorConstants.BLACK, 1, 0.5F)));
            for (int j = 0; j < 3; j++) {
                table.addCell(new Cell().setHeight(20).setBorder(new SolidBorder(ColorConstants.BLACK, 1, 0.5F)));
            }
            Rectangle pageSize = pdf.getPage(i).getPageSize();
            float x = pageSize.getLeft() + 20;
            float y = pageSize.getBottom() + 20;
            table.setFixedPosition(i, x, y, pageSize.getWidth() - 40);
            doc.add(table);
        }
    }
    private static void addSourcesPage(Document document, PdfFont font, PdfFont bold) {
        document.add(new Paragraph("ПРИЛОЖЕНИЕ 1").setTextAlignment(TextAlignment.RIGHT).setFont(bold));
        document.add(new Paragraph("СПИСОК ИСПОЛЬЗУЕМОЙ ЛИТЕРАТУРЫ").setTextAlignment(TextAlignment.CENTER).setFont(bold));
        List list = new List().setListSymbol(ListNumberingType.DECIMAL).setSymbolIndent(10F);
        list.add("ГОСТ 19.101-77 Виды программ и программных документов. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;").setFont(font);
        list.add("ГОСТ 19.102-77 Стадии разработки. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;").setFont(font);
        list.add("ГОСТ 19.103-77 Обозначения программ и программных документов. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;");
        list.add("ГОСТ 19.104-78 Основные надписи. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;");
        list.add("ГОСТ 19.105-78 Общие требования к программным документам. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;");
        list.add("ГОСТ 19.106-78 Требования к программным документам, выполненным печатным способом. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;");
        list.add("ГОСТ 19.201-78 Техническое задание. Требования к содержанию и оформлению. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;");
        list.add("ГОСТ 19.603-78 Общие правила внесения изменений. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;");
        list.add("ГОСТ 19.604-78 Правила внесения изменений в программные документы, выполненные печатным способом. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;");
        list.add("ГОСТ 19.404-79 Программа и методика испытаний. Требования к содержанию и оформлений. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;");
        list.add("ГОСТ 19.401-78 Текст программы. Требования к содержанию и оформлению. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.");
        list.add("ГОСТ 19.404-79 Пояснительная записка. Требования к содержанию и оформлению. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.;");
        list.add("ГОСТ 19.505-79 Руководство оператора. Требования к содержанию и оформлению. // Единая система программной документации. – М.: ИПК Издательство стандартов, 2001.");
        document.add(list);
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
    private static void writeSpecialSection(Document document, PdfFont font, PdfFont bold) {
        Table table = new Table(3).useAllAvailableWidth();
        table.addCell(new Cell().add(new Paragraph("Стадия разработки").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Этапы работ").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Содержание работ").setFont(font)));

        table.addCell(new Cell(14, 1).add(new Paragraph("1. Техническое задание").setFont(font)));

        table.addCell(new Cell(4, 1).add(new Paragraph("Обоснование необходимости разработки").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Постановка задачи").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Сбор материалов").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Выбор  обоснование критериев качества программного продукта").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Обоснование необходимости проведения научно-исследовательских работ").setFont(font)));

        table.addCell(new Cell(5, 1).add(new Paragraph("Научно-исследовательские работы").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Ознакомление с исходным кодом программы").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Определение возможных алгоритмов решения").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Определение структур данных").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Определение требований к техническим средствам").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Ознакомление с технологиями для реализации проекта").setFont(font)));

        table.addCell(new Cell(5, 1).add(new Paragraph("Разработка и утверждение технического задания").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Определение требований к программе").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Определение стадий и содержания работ").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Разработка экономического обоснования").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Разработка технического задания").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Утверждение технического задания").setFont(font)));

        table.addCell(new Cell(7, 1).add(new Paragraph("2. Технический проект").setFont(font)));

        table.addCell(new Cell(4, 1).add(new Paragraph("Разработка технического проекта").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Выбор библиотек и фреймворков для решения задачи").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Разработка алгоритма действий программы").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Разработка структуры и конструирование интерфейса программы").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Разработка  плана  мероприятий разработки рабочего проекта").setFont(font)));

        table.addCell(new Cell(3, 1).add(new Paragraph("Утверждение технического проекта").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Разработка пояснительной записки").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Согласование и утверждение технического проекта").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Программирование").setFont(font)));

        table.addCell(new Cell(8, 1).add(new Paragraph("3. Рабочий проект").setFont(font)));

        table.addCell(new Cell(3, 1).add(new Paragraph("Разработка программы").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Отладка").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Проверка на соответствие техническому заданию").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Разработка программной документации в соответствии с ЕСПД").setFont(font)));

        table.addCell(new Cell(1, 1).add(new Paragraph("Разработка программной документации").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Разработка и утверждение методики испытаний").setFont(font)));

        table.addCell(new Cell(3, 1).add(new Paragraph("Испытания программы").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Проведение испытаний").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Корректировка программыи документации по результатам испытаний").setFont(font)));
        table.addCell(new Cell().add(new Paragraph("Сдача программы с полным пакетом документации").setFont(font)));

        table.addCell(new Cell(1, 1).add(new Paragraph("Сдача программы").setFont(font)));
        table.addCell(new Cell().add(new Paragraph(" ").setFont(font)));
        document.add(table);
    }
}
