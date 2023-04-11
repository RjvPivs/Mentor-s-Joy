package com.example.mentorsjoy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PDFs")
data class PdfData(@PrimaryKey private var projectName: String) : java.io.Serializable{
    @ColumnInfo(name="mentorTitle")
    private var mentorTitle //Дожность научрука
            : String? = null
    @ColumnInfo(name="mentorName")
    private var mentorName //Имя научрука
            : String? = null
    @ColumnInfo(name="academicalTitle")
    private var academicalTitle //Должность руководителя обр. программы
            : String? = null
    @ColumnInfo(name="academicalName")
    private var academicalName //Имя руководителя обр. программы
            : String? = null
    @ColumnInfo(name="projectType")
    private var projectType //Тип проекта (числа из кодификатора)
            : String? = null
    @ColumnInfo(name="studentName")
    private var studentName //Имя студента
            : String? = null
    @ColumnInfo(name="studentGroup")
    private var studentGroup //Группа студента
            : String? = null
    fun setMentorTitle(s: String?) {
        mentorTitle = s
    }

    fun getMentorTitle(): String? {
        return mentorTitle
    }

    fun setMentorName(s: String?) {
        mentorName = s
    }

    fun getMentorName(): String? {
        return mentorName
    }

    fun setAcademicalTitle(s: String?) {
        academicalTitle = s
    }

    fun getAcademicalTitle(): String? {
        return academicalTitle
    }

    fun setAcademicalName(s: String?) {
        academicalName = s
    }

    fun getAcademicalName(): String? {
        return academicalName
    }

    fun setProjectName(s: String?) {
        if (s != null) {
            projectName = s
        }
    }

    fun getProjectName(): String? {
            return projectName
    }

    fun setProjectType(s: String?) {
        projectType = s
    }

    fun getProjectType(): String? {
        return projectType
    }

    fun setStudentName(s: String?) {
        studentName = s
    }

    fun getStudentName(): String? {
        return studentName
    }

    fun setStudentGroup(s: String?) {
        studentGroup = s
    }

    fun getStudentGroup(): String? {
        return studentGroup
    }

}
