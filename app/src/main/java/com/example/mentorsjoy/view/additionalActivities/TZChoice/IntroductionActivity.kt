package com.example.mentorsjoy.view.additionalActivities.TZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsPZ
import com.example.mentorsjoy.model.SectionsTZ
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.view.additionalActivities.PZChoice.PZCheckActivity

class IntroductionActivity : AppCompatActivity() {
    lateinit var sec: SectionsTZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction2)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var eng: EditText = findViewById(R.id.englishTZ)
        var doc: EditText = findViewById(R.id.documentsTZ)
        Thread {
            sec = db.getDao().getTzs(name)[0]
            eng.post(Runnable{
                eng.setText(sec.getProjectNameEnglish())
            })
            doc.post(Runnable{
                doc.setText(sec.getScope())
            })
        }.start()
    }
    fun saveIntroTz(view: View){
        var eng: EditText = findViewById(R.id.englishTZ)
        var doc: EditText = findViewById(R.id.documentsTZ)
        sec.setProjectNameEnglish(eng.text.toString())
        sec.setScope(doc.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var tzCheckActivity = Intent(this, TzCheckActivity::class.java)
        tzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(tzCheckActivity)
    }
}