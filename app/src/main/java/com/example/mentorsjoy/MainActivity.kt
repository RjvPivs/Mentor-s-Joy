package com.example.mentorsjoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startWorkflow(view: View){
        val secondAct = Intent(this, ChoiceActivity::class.java)
        startActivity(secondAct)
    }
}