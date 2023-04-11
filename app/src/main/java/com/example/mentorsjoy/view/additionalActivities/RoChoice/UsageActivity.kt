package com.example.mentorsjoy.view.additionalActivities.RoChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsRO
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.view.additionalActivities.TZChoice.TzCheckActivity

class UsageActivity : AppCompatActivity() {
    lateinit var sec: SectionsRO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage2)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var func: EditText = findViewById(R.id.funcRO)
        var exp: EditText = findViewById(R.id.expRO)
        var list: EditText = findViewById(R.id.funcListRO)
        Thread {
            sec = db.getDao().getROs(name)[0]
            func.post(Runnable{
                func.setText(sec.getFunc())
            })
            exp.post(Runnable{
                exp.setText(sec.getExp())
            })
            list.post(Runnable{
                list.setText(sec.getFuncList())
            })
        }.start()
    }
    fun saveUsageRo(view: View){
        var func: EditText = findViewById(R.id.funcRO)
        var exp: EditText = findViewById(R.id.expRO)
        var list: EditText = findViewById(R.id.funcListRO)
        sec.setFunc(func.text.toString())
        sec.setExp(exp.text.toString())
        sec.setFuncList(list.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var roCheckActivity = Intent(this, RoCheckActivity::class.java)
        roCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(roCheckActivity)
    }
}