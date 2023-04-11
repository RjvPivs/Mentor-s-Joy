package com.example.mentorsjoy.view.additionalActivities.PMIChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsPMI
import com.example.mentorsjoy.repository.PDFDataBase

class TargetActivity : AppCompatActivity() {
    lateinit var sec: SectionsPMI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var target: EditText = findViewById(R.id.targetPmi)
        Thread {
            sec = db.getDao().getPMIs(name)[0]
            target.post(Runnable{
                target.setText(sec.getTarget())
            })
        }.start()
    }
    fun saveTargetPmi(view: View){
        var target: EditText = findViewById(R.id.targetPmi)
        sec.setTarget(target.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pmiCheckActivity = Intent(this, PmiCheckActivity::class.java)
        pmiCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pmiCheckActivity)
    }
}