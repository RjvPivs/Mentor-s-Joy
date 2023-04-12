package com.example.mentorsjoy.view.additionalActivities.PZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mentorsjoy.R
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.model.PdfData
import com.example.mentorsjoy.model.SectionsPZ
import com.example.mentorsjoy.view.basicActivities.ChoiceActivity
import com.example.mentorsjoy.view.basicActivities.GenerationActivity

class PZCheckActivity : AppCompatActivity() {
    private lateinit var pdf: PdfData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pzcheck)
        val db = PDFDataBase.get(this)
        val name = intent.extras!!.getString("name")
        var pz = name?.let { SectionsPZ(it) }!!
        Thread {
            if (db.getDao().getPzs(pz.getProjectName()).isEmpty()) {
                db.getDao().insert(pz)
            }
            pdf = db.getDao().getPdf(name)[0]
        }.start()
    }
    fun buttonOne(view: View){
        val introductionActivity = Intent(this, IntroductionActivity::class.java)
        introductionActivity.putExtra("name", pdf.getProjectName())
        startActivity(introductionActivity)
    }
    fun buttonTwo(view: View){
        val usageActivity = Intent(this, UsageActivity::class.java)
        usageActivity.putExtra("name", pdf.getProjectName())
        startActivity(usageActivity)
    }
    fun buttonThree(view: View){
        val techActivity = Intent(this, TechActivity::class.java)
        techActivity.putExtra("name", pdf.getProjectName())
        startActivity(techActivity)
    }
    fun buttonFour(view: View){
        val expectedActivity = Intent(this, ExpectedActivity::class.java)
        expectedActivity.putExtra("name", pdf.getProjectName())
        startActivity(expectedActivity)
    }
    fun buttonFive(view: View){
        val db = PDFDataBase.get(this)
        Thread {
            var pz = db.getDao().getPzs(pdf.getProjectName())[0]
            val generationActivity = Intent(this, GenerationActivity::class.java)
            generationActivity.putExtra("type", "PZ")
            generationActivity.putExtra("doc", pz)
            generationActivity.putExtra("pdf", pdf)
            startActivity(generationActivity)
        }.start()
    }
    override fun onBackPressed() {
        val choiceActivity = Intent(this, ChoiceActivity::class.java)
        choiceActivity.putExtra("pdf", pdf)
        startActivity(choiceActivity)
    }
}