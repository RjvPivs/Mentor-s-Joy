package com.example.mentorsjoy.view.additionalActivities.PZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.model.SectionsPZ

class UsageActivity : AppCompatActivity() {
    private lateinit var sec: SectionsPZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var func: EditText = findViewById(R.id.funcPZ)
        var exp: EditText = findViewById(R.id.expPZ)
        var scope: EditText = findViewById(R.id.ShortPZ)
        Thread {
            sec = db.getDao().getPzs(name)[0]
            func.post(Runnable{
                func.setText(sec.getFunc())
            })
            exp.post(Runnable{
                exp.setText(sec.getExp())
            })
            scope.post(Runnable{
                scope.setText(sec.getScope())
            })
        }.start()
    }
    fun saveUsage(view: View){
        var func: EditText = findViewById(R.id.funcPZ)
        var exp: EditText = findViewById(R.id.expPZ)
        var scope: EditText = findViewById(R.id.ShortPZ)
        sec.setFunc(func.text.toString())
        sec.setExp(exp.text.toString())
        sec.setScope(scope.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pzCheckActivity = Intent(this, PZCheckActivity::class.java)
        pzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pzCheckActivity)
    }
}