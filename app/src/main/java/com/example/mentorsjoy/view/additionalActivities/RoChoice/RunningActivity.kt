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

class RunningActivity : AppCompatActivity() {
    private lateinit var sec: SectionsRO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_running)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var inst: EditText = findViewById(R.id.downloadRO)
        var start: EditText = findViewById(R.id.startRO)
        var cont: EditText = findViewById(R.id.usingRO)
        var fin: EditText = findViewById(R.id.finishRO)
        Thread {
            sec = db.getDao().getROs(name)[0]
            inst.post(Runnable{
                inst.setText(sec.getInstall())
            })
            start.post(Runnable{
                start.setText(sec.getLaunch())
            })
            cont.post(Runnable{
                cont.setText(sec.getWork())
            })
            fin.post(Runnable{
                fin.setText(sec.getFinish())
            })
        }.start()
    }
    fun saveRunningRo(view: View){
        var fin: EditText = findViewById(R.id.finishRO)
        var inst: EditText = findViewById(R.id.downloadRO)
        var start: EditText = findViewById(R.id.startRO)
        var cont: EditText = findViewById(R.id.usingRO)
        sec.setInstall(inst.text.toString())
        sec.setLaunch(start.text.toString())
        sec.setWork(cont.text.toString())
        sec.setFinish(fin.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var roCheckActivity = Intent(this, RoCheckActivity::class.java)
        roCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(roCheckActivity)
    }
}