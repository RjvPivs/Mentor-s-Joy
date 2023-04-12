package com.example.mentorsjoy.view.additionalActivities.PMIChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.PdfData
import com.example.mentorsjoy.model.SectionsPMI
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.view.additionalActivities.PMIChoice.*
import com.example.mentorsjoy.view.basicActivities.ChoiceActivity
import com.example.mentorsjoy.view.basicActivities.GenerationActivity

class PmiCheckActivity : AppCompatActivity() {
    private lateinit var pdf: PdfData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pmi_choice)
        val db = PDFDataBase.get(this)
        val name = intent.extras!!.getString("name")
        var pmi = name?.let { SectionsPMI(it) }!!
        Thread {
            if (db.getDao().getPMIs(pmi.getProjectName()).isEmpty()) {
                db.getDao().insert(pmi)
            }
            pdf = db.getDao().getPdf(name)[0]
        }.start()
    }
    fun buttonOnePmi(view: View){
        val introductionActivity = Intent(this, IntroductionActivity::class.java)
        introductionActivity.putExtra("name", pdf.getProjectName())
        startActivity(introductionActivity)
    }
    fun buttonTwoPmi(view: View){
        val targetActivity = Intent(this, TargetActivity::class.java)
        targetActivity.putExtra("name", pdf.getProjectName())
        startActivity(targetActivity)
    }
    fun buttonThreePmi(view: View){
        val requirementsProgActivity = Intent(this, RequirementsProgActivity::class.java)
        requirementsProgActivity.putExtra("name", pdf.getProjectName())
        startActivity(requirementsProgActivity)
    }
    fun buttonFourPmi(view: View){
        val requirementsDocActivity = Intent(this, RequirementsDocActivity::class.java)
        requirementsDocActivity.putExtra("name", pdf.getProjectName())
        startActivity(requirementsDocActivity)
    }
    fun buttonFivePmi(view: View){
        val testActivity = Intent(this, TestActivity::class.java)
        testActivity.putExtra("name", pdf.getProjectName())
        startActivity(testActivity)
    }
    fun buttonSixPmi(view: View){
        val methodsActivity = Intent(this, MethodsActivity::class.java)
        methodsActivity.putExtra("name", pdf.getProjectName())
        startActivity(methodsActivity)
    }
    fun buttonSevenPmi(view: View){
        val db = PDFDataBase.get(this)
        Thread {
            var pmi = db.getDao().getPMIs(pdf.getProjectName())[0]
            val generationActivity = Intent(this, GenerationActivity::class.java)
            generationActivity.putExtra("type", "PMI")
            generationActivity.putExtra("doc", pmi)
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