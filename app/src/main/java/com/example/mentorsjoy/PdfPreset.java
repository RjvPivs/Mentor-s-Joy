package com.example.mentorsjoy;

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
        }
    }

    public String getDocType() {
        return docType;
    }

    public String getDocCode() {
        return docCode;
    }

    public String getDocName() {
        return docName;
    }
}
