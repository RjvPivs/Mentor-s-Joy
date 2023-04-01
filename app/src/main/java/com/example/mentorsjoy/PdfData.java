package com.example.mentorsjoy;
import java.io.Serializable;
public class PdfData implements Serializable{
    String mentorTitle; //Дожность научрука
    String mentorName; //Имя научрука
    String academicalTitle; //Должность руководителя обр. программы
    String academicalName; //Имя руководителя обр. программы
    String projectName; //Название проекта
    String projectType; //Тип проекта (числа из кодификатора)
    String studentName; //Имя студента
    String studentGroup; //Группа студента
    public void setMentorTitle(String s) {mentorTitle = s;}
    public String getMentorTitle() {return mentorTitle;}
    public void setMentorName(String s) {mentorName = s;}
    public String getMentorName() {return mentorName;}
    public void setAcademicalTitle(String s) {academicalTitle = s;}
    public String getAcademicalTitle() {return academicalTitle;}
    public void setAcademicalName(String s) {academicalName = s;}
    public String getAcademicalName() {return academicalName;}
    public void setProjectName(String s) {projectName = s;}
    public String getProjectName() {return projectName;}
    public void setProjectType(String s) {projectType = s;}
    public String getProjectType() {return projectType;}
    public void setStudentName(String s) {studentName = s;}
    public String getStudentName() {return studentName;}
    public void setStudentGroup(String s) {studentGroup = s;}
    public String getStudentGroup() {return studentGroup;}
    public PdfData() {
        mentorTitle = "aboba";
        mentorName = "aboba";
        academicalTitle = "aboba";
        academicalName = "aboba";
        projectName = "aboba";
        projectType = "aboba";
        studentGroup = "aboba";
        studentName = "aboba";
    }
}
