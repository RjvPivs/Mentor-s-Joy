package com.example.mentorsjoy.view.additionalActivities.PMIChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsPMI
import com.example.mentorsjoy.repository.PDFDataBase

class MethodsActivity : AppCompatActivity() {
    lateinit var sec: SectionsPMI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_methods)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var prog: EditText = findViewById(R.id.progTestPmi)
        var func: EditText = findViewById(R.id.funcTestPmi)
        var inter: EditText = findViewById(R.id.interfaceTestPmi)
        var rob: EditText = findViewById(R.id.robTestPmi)
        Thread {
            sec = db.getDao().getPMIs(name)[0]
            prog.post(Runnable{
                prog.setText(sec.getDocTests())
            })
            func.post(Runnable{
                func.setText(sec.getFuncTests())
            })
            inter.post(Runnable{
                inter.setText(sec.getInterTests())
            })
            rob.post(Runnable{
                rob.setText(sec.getRobustTests())
            })
        }.start()
    }
    fun saveMethodsPmi(view: View){
        var prog: EditText = findViewById(R.id.progTestPmi)
        var func: EditText = findViewById(R.id.funcTestPmi)
        var inter: EditText = findViewById(R.id.interfaceTestPmi)
        var rob: EditText = findViewById(R.id.robTestPmi)
        sec.setDocTests(prog.text.toString())
        sec.setFuncTests(func.text.toString())
        sec.setInterTests(inter.text.toString())
        sec.setRobustTests(rob.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pmiCheckActivity = Intent(this, PmiCheckActivity::class.java)
        pmiCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pmiCheckActivity)
    }
}