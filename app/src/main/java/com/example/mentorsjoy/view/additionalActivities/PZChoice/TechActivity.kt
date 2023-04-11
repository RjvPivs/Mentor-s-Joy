package com.example.mentorsjoy.view.additionalActivities.PZChoice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorsjoy.R
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.model.SectionsPZ


class TechActivity : AppCompatActivity() {
    lateinit var sec: SectionsPZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tech)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var task: EditText = findViewById(R.id.taskPZ)
        var alg: EditText = findViewById(R.id.algPZ)
        var choice: EditText = findViewById(R.id.choiceDataPZ)
        var tech: EditText = findViewById(R.id.choiceTechPz)
        Thread {
            sec = db.getDao().getPzs(name)[0]
            task.post(Runnable{
                    task.setText(sec.getTask())
            })
            alg.post(Runnable{
                alg.setText(sec.getAlgorithm())
            })
            choice.post(Runnable{
                choice.setText(sec.getIO())
            })
            tech.post(Runnable{
                tech.setText(sec.getHardware())
            })
        }.start()
    }
    fun saveTech(view: View){
        var task: EditText = findViewById(R.id.taskPZ)
        var alg: EditText = findViewById(R.id.algPZ)
        var choice: EditText = findViewById(R.id.choiceDataPZ)
        var tech: EditText = findViewById(R.id.choiceTechPz)
        sec.setTask(task.text.toString())
        sec.setAlgorithm(alg.text.toString())
        sec.setIO(choice.text.toString())
        sec.setHardware(tech.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pzCheckActivity = Intent(this, PZCheckActivity::class.java)
        pzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pzCheckActivity)
    }
}