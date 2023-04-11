package com.example.mentorsjoy.view.basicActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.mentorsjoy.model.PdfData
import com.example.mentorsjoy.R

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
    }
    fun save(view: View){
        var mentorName: EditText = findViewById(R.id.mentorName)
        var mentorType: EditText = findViewById(R.id.mentorType)
        var academName: EditText = findViewById(R.id.academName)
        var academType: EditText = findViewById(R.id.academType)
        var studentName: EditText = findViewById(R.id.studentName)
        var groupName: EditText = findViewById(R.id.groupName)
        var projectName: EditText = findViewById(R.id.projectName)
        var projectType: EditText = findViewById(R.id.projectType)
        when{
            mentorName.text.isEmpty() -> Toast.makeText(applicationContext,"Введите имя научрука", Toast.LENGTH_SHORT).show()
            mentorType.text.isEmpty() -> Toast.makeText(applicationContext,"Введите должность научрука", Toast.LENGTH_SHORT).show()
            academName.text.isEmpty() -> Toast.makeText(applicationContext,"Введите имя академрука", Toast.LENGTH_SHORT).show()
            academType.text.isEmpty() -> Toast.makeText(applicationContext,"Введите должность академрука", Toast.LENGTH_SHORT).show()
            studentName.text.isEmpty() -> Toast.makeText(applicationContext,"Введите имя студента", Toast.LENGTH_SHORT).show()
            groupName.text.isEmpty() -> Toast.makeText(applicationContext,"Введите группу студента", Toast.LENGTH_SHORT).show()
            projectName.text.isEmpty() -> Toast.makeText(applicationContext,"Введите название проекта", Toast.LENGTH_SHORT).show()
            projectType.text.isEmpty() -> Toast.makeText(applicationContext,"Введите классификатор проекта", Toast.LENGTH_SHORT).show()
            else -> {
                var pdfData: PdfData = PdfData("temp")
                pdfData.setStudentName(studentName.text.toString())
                pdfData.setStudentGroup(groupName.text.toString())
                pdfData.setAcademicalName(academName.text.toString())
                pdfData.setAcademicalTitle(academType.text.toString())
                pdfData.setMentorName(mentorName.text.toString())
                pdfData.setMentorTitle(mentorType.text.toString())
                pdfData.setProjectName(projectName.text.toString())
                pdfData.setProjectType(projectType.text.toString())
                val recyclerActivity = Intent(this, RecyclerActivity::class.java)
                recyclerActivity.putExtra("pdf", pdfData)
                startActivity(recyclerActivity)
            }
        }
    }
}