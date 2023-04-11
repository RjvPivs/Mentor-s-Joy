package com.example.mentorsjoy.view.additionalActivities.TZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsTZ
import com.example.mentorsjoy.repository.PDFDataBase

class TaskActivity : AppCompatActivity() {
    lateinit var sec: SectionsTZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var task: EditText = findViewById(R.id.taskTzScope)
        Thread {
            sec = db.getDao().getTzs(name)[0]
            task.post(Runnable{
                task.setText(sec.getDocIncentive())
            })
        }.start()
    }
    fun saveTaskTz(view: View){
        var task: EditText = findViewById(R.id.taskTzScope)
        sec.setDocIncentive(task.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var tzCheckActivity = Intent(this, TzCheckActivity::class.java)
        tzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(tzCheckActivity)
    }
}