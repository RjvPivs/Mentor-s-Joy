package com.example.mentorsjoy.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.Sec

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startWorkflow(view: View){

        //setupPermissions()
        val recActivity = Intent(this, RecyclerActivity::class.java)
        startActivity(recActivity)
    }
}