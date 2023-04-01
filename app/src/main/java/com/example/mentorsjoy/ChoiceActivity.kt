package com.example.mentorsjoy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ChoiceActivity : AppCompatActivity() {
    lateinit var pdfData: PdfData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
        val arguments = intent.extras
        pdfData = arguments!!.getSerializable("pdf") as PdfData
    }
    fun startTZ(view: View){
        val tzAct = Intent(this, TZActivity::class.java)
        tzAct.putExtra("pdf", pdfData)
        startActivity(tzAct)
    }
}