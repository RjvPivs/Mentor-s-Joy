package com.example.mentorsjoy.view.additionalActivities.PMIChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsPMI
import com.example.mentorsjoy.repository.PDFDataBase

class RequirementsProgActivity : AppCompatActivity() {
    lateinit var sec: SectionsPMI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requirements)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var req: EditText = findViewById(R.id.reqFuncPmi)
        var inter: EditText = findViewById(R.id.reqInterfacePmi)
        var rob: EditText = findViewById(R.id.reqRobPmi)
        Thread {
            sec = db.getDao().getPMIs(name)[0]
            req.post(Runnable{
                req.setText(sec.getFunctions())
            })
            inter.post(Runnable{
                inter.setText(sec.getInter())
            })
            rob.post(Runnable{
                rob.setText(sec.getRobustness())
            })
        }.start()
    }
    fun saveReqProgPmi(view: View){
        var req: EditText = findViewById(R.id.reqFuncPmi)
        var inter: EditText = findViewById(R.id.reqInterfacePmi)
        var rob: EditText = findViewById(R.id.reqRobPmi)
        sec.setFunctions(req.text.toString())
        sec.setInter(inter.text.toString())
        sec.setRobustness(rob.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var pmiCheckActivity = Intent(this, PmiCheckActivity::class.java)
        pmiCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(pmiCheckActivity)
    }
}