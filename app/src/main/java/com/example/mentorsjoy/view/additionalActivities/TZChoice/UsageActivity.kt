package com.example.mentorsjoy.view.additionalActivities.TZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsTZ
import com.example.mentorsjoy.repository.PDFDataBase

class UsageActivity : AppCompatActivity() {
    lateinit var sec: SectionsTZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var func: EditText = findViewById(R.id.funcTz)
        var expl: EditText = findViewById(R.id.explTz)
        Thread {
            sec = db.getDao().getTzs(name)[0]
            func.post(Runnable{
                func.setText(sec.getFunc())
            })
            expl.post(Runnable{
                expl.setText(sec.getExp())
            })
        }.start()
    }
    fun saveUsageTz(view: View){
        var func: EditText = findViewById(R.id.funcTz)
        var expl: EditText = findViewById(R.id.explTz)
        sec.setFunc(func.text.toString())
        sec.setExp(expl.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var tzCheckActivity = Intent(this, TzCheckActivity::class.java)
        tzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(tzCheckActivity)
    }
}