package com.example.mentorsjoy.view.additionalActivities.TPChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.PdfData
import com.example.mentorsjoy.model.SectionsTP
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.view.additionalActivities.PZChoice.PZCheckActivity
import com.example.mentorsjoy.view.basicActivities.GenerationActivity

class TPChoiceActivity : AppCompatActivity() {
    private lateinit var tp: SectionsTP
    private lateinit var pdf: PdfData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tpchoice)
        val db = PDFDataBase.get(this)
        val name = intent.extras!!.getString("name")
        tp = name?.let { SectionsTP(it) }!!
        var intro: EditText = findViewById(R.id.introTP)
        var sources: EditText = findViewById(R.id.sourceTP)
        Thread {
            if (db.getDao().getTPs(tp.getProjectName()).isEmpty()) {
                db.getDao().insert(tp)
            }else{
                tp = db.getDao().getTPs(tp.getProjectName())[0]
            }
            pdf = db.getDao().getPdf(name)[0]
            intro.post(Runnable{
                intro.setText(tp.getIntro())
            })
            sources.post(Runnable{
                sources.setText(tp.getSource())
            })
        }.start()
    }
    fun saveTP(view: View){
        var intro: EditText = findViewById(R.id.introTP)
        var sources: EditText = findViewById(R.id.sourceTP)
        tp.setIntro(intro.text.toString())
        tp.setSource(sources.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(tp)
            val generationActivity = Intent(this, GenerationActivity::class.java)
            generationActivity.putExtra("type", "TP")
            generationActivity.putExtra("doc", tp)
            generationActivity.putExtra("pdf", pdf)
            startActivity(generationActivity)
        }.start()
    }
}