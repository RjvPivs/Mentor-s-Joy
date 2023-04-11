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

class MessagesActivity : AppCompatActivity() {
    private lateinit var sec: SectionsRO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var mess: EditText = findViewById(R.id.messRO)
        var err: EditText = findViewById(R.id.errRO)
        Thread {
            sec = db.getDao().getROs(name)[0]
            mess.post(Runnable{
                mess.setText(sec.getMsg())
            })
            err.post(Runnable{
                err.setText(sec.getErrors())
            })
        }.start()
    }
    fun saveMessRo(view: View){
        var mess: EditText = findViewById(R.id.messRO)
        var err: EditText = findViewById(R.id.errRO)
        sec.setMsg(mess.text.toString())
        sec.setErrors(err.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var roCheckActivity = Intent(this, RoCheckActivity::class.java)
        roCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(roCheckActivity)
    }
}