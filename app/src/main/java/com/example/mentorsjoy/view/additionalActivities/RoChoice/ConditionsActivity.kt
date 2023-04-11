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

class ConditionsActivity : AppCompatActivity() {
    private lateinit var sec: SectionsRO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conditions)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var hard: EditText = findViewById(R.id.minHardRO)
        var prog: EditText = findViewById(R.id.minSoftRO)
        var user: EditText = findViewById(R.id.userRO)
        Thread {
            sec = db.getDao().getROs(name)[0]
            hard.post(Runnable{
                hard.setText(sec.getHardware())
            })
            prog.post(Runnable{
                prog.setText(sec.getSoftware())
            })
            user.post(Runnable{
                user.setText(sec.getUser())
            })
        }.start()
    }
    fun saveCondRo(view: View){
        var hard: EditText = findViewById(R.id.minHardRO)
        var prog: EditText = findViewById(R.id.minSoftRO)
        var user: EditText = findViewById(R.id.userRO)
        sec.setHardware(hard.text.toString())
        sec.setSoftware(prog.text.toString())
        sec.setUser(user.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var roCheckActivity = Intent(this, RoCheckActivity::class.java)
        roCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(roCheckActivity)
    }
}