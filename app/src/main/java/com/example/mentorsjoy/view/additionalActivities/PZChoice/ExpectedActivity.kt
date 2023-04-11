package com.example.mentorsjoy.view.additionalActivities.PZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.model.SectionsPZ

class ExpectedActivity : AppCompatActivity() {
    lateinit var sec: SectionsPZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expected)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var usage: EditText = findViewById(R.id.expectedNeed)
        var comparison: EditText = findViewById(R.id.advantage)
        Thread {
            sec = db.getDao().getPzs(name)[0]
            usage.post(Runnable{
                usage.setText(sec.getUsage())
            })
            comparison.post(Runnable{
                comparison.setText(sec.getComparison())
            })
        }.start()
    }
    fun saveExpected(view: View){
        var usage: EditText = findViewById(R.id.expectedNeed)
        var comparison: EditText = findViewById(R.id.advantage)
        sec.setUsage(usage.text.toString())
        sec.setComparison(comparison.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pzCheckActivity = Intent(this, PZCheckActivity::class.java)
        pzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pzCheckActivity)
    }
}