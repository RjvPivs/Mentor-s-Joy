package com.example.mentorsjoy.view.additionalActivities.RoChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.PdfData
import com.example.mentorsjoy.model.SectionsRO
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.view.basicActivities.ChoiceActivity
import com.example.mentorsjoy.view.basicActivities.GenerationActivity
import com.example.mentorsjoy.view.basicActivities.MainActivity

class RoCheckActivity : AppCompatActivity() {
    private lateinit var pdf: PdfData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ro_check)
        val db = PDFDataBase.get(this)
        val name = intent.extras!!.getString("name")
        var ro = name?.let { SectionsRO(it) }!!
        Thread {
            if (db.getDao().getROs(ro.getProjectName()).isEmpty()) {
                db.getDao().insert(ro)
            }
            pdf = db.getDao().getPdf(name)[0]
        }.start()
    }
    fun buttonOneRO(view: View){
        val usageActivity = Intent(this, UsageActivity::class.java)
        usageActivity.putExtra("name", pdf.getProjectName())
        startActivity(usageActivity)
    }
    fun buttonTwoRO(view: View){
        val conditionsActivity = Intent(this, ConditionsActivity::class.java)
        conditionsActivity.putExtra("name", pdf.getProjectName())
        startActivity(conditionsActivity)
    }
    fun buttonThreeRO(view: View){
        val runningActivity = Intent(this, RunningActivity::class.java)
        runningActivity.putExtra("name", pdf.getProjectName())
        startActivity(runningActivity)
    }
    fun buttonFourRO(view: View){
        val messagesActivity = Intent(this, MessagesActivity::class.java)
        messagesActivity.putExtra("name", pdf.getProjectName())
        startActivity(messagesActivity)
    }

    fun buttonFiveRO(view: View){
        val db = PDFDataBase.get(this)
        Thread {
            var ro = db.getDao().getROs(pdf.getProjectName())[0]
            val generationActivity = Intent(this, GenerationActivity::class.java)
            generationActivity.putExtra("type", "RO")
            generationActivity.putExtra("doc", ro)
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