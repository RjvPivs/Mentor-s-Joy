package com.example.mentorsjoy

data class PdfData(val _projectName: String) : java.io.Serializable{
    private var mentorTitle //Дожность научрука
            : String? = null
    private var mentorName //Имя научрука
            : String? = null
    private var academicalTitle //Должность руководителя обр. программы
            : String? = null
    private var academicalName //Имя руководителя обр. программы
            : String? = null
    private var projectName //Название проекта
            : String? = null
    private var projectType //Тип проекта (числа из кодификатора)
            : String? = null
    private var studentName //Имя студента
            : String? = null
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
        projectName = s
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

    init{
        projectName = _projectName
    }
}
