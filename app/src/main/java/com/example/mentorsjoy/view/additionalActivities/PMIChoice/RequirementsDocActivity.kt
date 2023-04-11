package com.example.mentorsjoy.view.additionalActivities.PMIChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsPMI
import com.example.mentorsjoy.repository.PDFDataBase

class RequirementsDocActivity : AppCompatActivity() {
    lateinit var sec: SectionsPMI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requrements_doc)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var req: EditText = findViewById(R.id.docReqPMI)
        Thread {
            sec = db.getDao().getPMIs(name)[0]
            req.post(Runnable{
                req.setText(sec.getDoc())
            })
        }.start()
    }
    fun saveDocReqPmi(view: View){
        var req: EditText = findViewById(R.id.docReqPMI)
            sec.setDoc(req.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pmiCheckActivity = Intent(this, PmiCheckActivity::class.java)
        pmiCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pmiCheckActivity)
    }
}