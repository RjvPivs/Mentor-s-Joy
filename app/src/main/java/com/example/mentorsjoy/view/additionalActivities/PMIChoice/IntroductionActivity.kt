package com.example.mentorsjoy.view.additionalActivities.PMIChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsPMI
import com.example.mentorsjoy.repository.PDFDataBase

class IntroductionActivity : AppCompatActivity() {
    lateinit var sec: SectionsPMI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction3)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var namePmi: EditText = findViewById(R.id.namePmi)
        var scope: EditText = findViewById(R.id.scopePmi)
        Thread {
            sec = db.getDao().getPMIs(name)[0]
            namePmi.post(Runnable{
                namePmi.setText(sec.getProjectNameEnglish())
            })
            scope.post(Runnable{
                scope.setText(sec.getScope())
            })
        }.start()
    }
    fun saveIntroPmi(view: View){
        var namePmi: EditText = findViewById(R.id.namePmi)
        var scope: EditText = findViewById(R.id.scopePmi)
        sec.setProjectNameEnglish(namePmi.text.toString())
        sec.setScope(scope.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pmiCheckActivity = Intent(this, PmiCheckActivity::class.java)
        pmiCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pmiCheckActivity)
    }
}