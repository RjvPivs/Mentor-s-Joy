package com.example.mentorsjoy.view.additionalActivities.PZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.model.SectionsPZ

class IntroductionActivity : AppCompatActivity() {
    lateinit var sec: SectionsPZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var eng: EditText = findViewById(R.id.englishPZ)
        var doc: EditText = findViewById(R.id.documentsPZ)
        Thread {
            sec = db.getDao().getPzs(name)[0]
            eng.post(Runnable{
                eng.setText(sec.getProjectNameEnglish())
            })
            doc.post(Runnable{
                doc.setText(sec.getDocIncentive())
            })
        }.start()
    }
    fun saveIntro(view: View){
        var eng: EditText = findViewById(R.id.englishPZ)
        var doc: EditText = findViewById(R.id.documentsPZ)
        sec.setProjectNameEnglish(eng.text.toString())
        sec.setDocIncentive(doc.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pzCheckActivity = Intent(this, PZCheckActivity::class.java)
        pzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pzCheckActivity)
    }
}