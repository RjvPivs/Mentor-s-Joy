package com.example.mentorsjoy.view.additionalActivities.PMIChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsPMI
import com.example.mentorsjoy.repository.PDFDataBase

class TestActivity : AppCompatActivity() {
    lateinit var sec: SectionsPMI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var prog: EditText = findViewById(R.id.progMethPMI)
        var tech: EditText = findViewById(R.id.techMethPMI)
        Thread {
            sec = db.getDao().getPMIs(name)[0]
            tech.post(Runnable{
                tech.setText(sec.getHardware())
            })
            prog.post(Runnable{
                prog.setText(sec.getTestsOrder())
            })
        }.start()
    }
    fun saveTestPmi(view: View){
        var prog: EditText = findViewById(R.id.progMethPMI)
        var tech: EditText = findViewById(R.id.techMethPMI)
        sec.setHardware(tech.text.toString())
        sec.setTestsOrder(prog.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pmiCheckActivity = Intent(this, PmiCheckActivity::class.java)
        pmiCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pmiCheckActivity)
    }
}