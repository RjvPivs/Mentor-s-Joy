package com.example.mentorsjoy.view.basicActivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorsjoy.model.PdfData
import com.example.mentorsjoy.R
import com.example.mentorsjoy.view.additionalActivities.PMIChoice.PmiCheckActivity
import com.example.mentorsjoy.view.additionalActivities.PZChoice.PZCheckActivity
import com.example.mentorsjoy.view.additionalActivities.TPChoice.TPChoiceActivity
import com.example.mentorsjoy.view.additionalActivities.TZChoice.TzCheckActivity

class ChoiceActivity : AppCompatActivity() {
    lateinit var pdfData: PdfData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
        val arguments = intent.extras
        pdfData = arguments!!.getSerializable("pdf") as PdfData
    }
    fun startTZ(view: View){
        val TZCheckActivity = Intent(this, TzCheckActivity::class.java)
        TZCheckActivity.putExtra("name", pdfData.getProjectName())
        startActivity(TZCheckActivity)
    }
    fun startPZ(view: View){
        val PZCheckActivity = Intent(this, PZCheckActivity::class.java)
        PZCheckActivity.putExtra("name", pdfData.getProjectName())
        startActivity(PZCheckActivity)
    }
    fun startPMI(view: View){
        val PMICheckActivity = Intent(this, PmiCheckActivity::class.java)
        PMICheckActivity.putExtra("name", pdfData.getProjectName())
        startActivity(PMICheckActivity)
    }
    fun startTP(view: View){
        val TPChoiceActivity = Intent(this, TPChoiceActivity::class.java)
        TPChoiceActivity.putExtra("name", pdfData.getProjectName())
        startActivity(TPChoiceActivity)
    }
}