package com.example.mentorsjoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
    }
    fun startTZ(view: View){
        val TZAct = Intent(this, TZActivity::class.java)
        startActivity(TZAct)
    }
}