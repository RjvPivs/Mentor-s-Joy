package com.example.mentorsjoy.backend;

public class PdfPreset {
    private String docType;
    private String docCode;
    private String docName;
    public void SetTypeName(String type) {
        docType = type;
        switch (type) {
            case "TZ":
                docCode = "ТЗ";
                docName = "Техническое задание";
                break;
            case "PZ":
                docCode = "81";
                docName = "Пояснительная записка";
                break;
            case "PMI":
                docCode = "51";
                docName = "Программа и методики испытаний";
                break;
            case "RO":
                docCode = "34";
                docName = "Руководство оператора";
                break;
            case "TP":
                docCode = "12";
                docName = "Текст программы";
                break;
        }
    }
    public String getDocType() {return docType;}
    public String getDocCode() {return docCode;}
    public String getDocName() {return docName;}
}
