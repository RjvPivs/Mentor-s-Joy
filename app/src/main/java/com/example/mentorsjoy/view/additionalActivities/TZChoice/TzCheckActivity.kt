package com.example.mentorsjoy.view.additionalActivities.TZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.PdfData
import com.example.mentorsjoy.model.SectionsPZ
import com.example.mentorsjoy.model.SectionsTZ
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.view.basicActivities.ChoiceActivity
import com.example.mentorsjoy.view.basicActivities.GenerationActivity

class TzCheckActivity : AppCompatActivity() {
    private lateinit var pdf: PdfData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tz_check)
        val db = PDFDataBase.get(this)
        val name = intent.extras!!.getString("name")
        var tz = name?.let { SectionsTZ(it) }!!
        Thread {
            if (db.getDao().getTzs(tz.getProjectName()).isEmpty()) {
                db.getDao().insert(tz)
            }
            pdf = db.getDao().getPdf(name)[0]
        }.start()
    }
    fun buttonOneTz(view: View){
        val introductionActivity = Intent(this, IntroductionActivity::class.java)
        introductionActivity.putExtra("name", pdf.getProjectName())
        startActivity(introductionActivity)
    }
    fun buttonTwoTz(view: View){
        val taskActivity = Intent(this, TaskActivity::class.java)
        taskActivity.putExtra("name", pdf.getProjectName())
        startActivity(taskActivity)
    }
    fun buttonThreeTz(view: View){
        val usageActivity = Intent(this, UsageActivity::class.java)
        usageActivity.putExtra("name", pdf.getProjectName())
        startActivity(usageActivity)
    }
    fun buttonFourTz(view: View){
        val techActivity = Intent(this, TechActivity::class.java)
        techActivity.putExtra("name", pdf.getProjectName())
        startActivity(techActivity)
    }
    fun buttonFiveTz(view: View){
        val funcActivity = Intent(this, FuncActivity::class.java)
        funcActivity.putExtra("name", pdf.getProjectName())
        startActivity(funcActivity)
    }
    fun buttonSixTz(view: View){
        val tstActivity = Intent(this, TestActivity::class.java)
        tstActivity.putExtra("name", pdf.getProjectName())
        startActivity(tstActivity)
    }
    fun buttonSevenTz(view: View){
        val db = PDFDataBase.get(this)
        Thread {
            var tz = db.getDao().getTzs(pdf.getProjectName())[0]
            val generationActivity = Intent(this, GenerationActivity::class.java)
            generationActivity.putExtra("type", "TZ")
            generationActivity.putExtra("doc", tz)
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