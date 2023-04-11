package com.example.mentorsjoy.view.additionalActivities.TZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsTZ
import com.example.mentorsjoy.repository.PDFDataBase

class TestActivity : AppCompatActivity() {
    lateinit var sec: SectionsTZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var types: EditText = findViewById(R.id.typesTz)
        var requirements: EditText = findViewById(R.id.requirementsTz)
        Thread {
            sec = db.getDao().getTzs(name)[0]
            types.post(Runnable{
                types.setText(sec.getTests())
            })
            requirements.post(Runnable{
                requirements.setText(sec.getAcceptance())
            })
        }.start()
    }
    fun saveTestTz(view: View){
        var types: EditText = findViewById(R.id.typesTz)
        var requirements: EditText = findViewById(R.id.requirementsTz)
        sec.setTests(types.text.toString())
        sec.setAcceptance(requirements.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var tzCheckActivity = Intent(this, TzCheckActivity::class.java)
        tzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(tzCheckActivity)
    }
}