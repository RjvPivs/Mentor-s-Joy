package com.example.mentorsjoy.view.additionalActivities.TZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsTZ
import com.example.mentorsjoy.repository.PDFDataBase

class FuncActivity : AppCompatActivity() {
    lateinit var sec: SectionsTZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_func)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var use: EditText = findViewById(R.id.probableUsageTz)
        var econ: EditText = findViewById(R.id.economicalTz)
        Thread {
            sec = db.getDao().getTzs(name)[0]
            use.post(Runnable{
                use.setText(sec.getUsage())
            })
            econ.post(Runnable{
                econ.setText(sec.getComparison())
            })
        }.start()
    }
    fun saveFuncTz(view: View){
        var use: EditText = findViewById(R.id.probableUsageTz)
        var econ: EditText = findViewById(R.id.economicalTz)
        sec.setUsage(use.text.toString())
        sec.setComparison(econ.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var tzCheckActivity = Intent(this, TzCheckActivity::class.java)
        tzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(tzCheckActivity)
    }
}