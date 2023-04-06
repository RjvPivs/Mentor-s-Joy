package com.example.mentorsjoy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mentorsjoy.databinding.ActivityMainBinding
import com.example.mentorsjoy.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(), PDFAdapter.Listener {
    lateinit var binding:ActivityRecyclerBinding
    private val adapter = PDFAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        if (intent.hasExtra("pdf")){
            adapter.addPDF(intent.extras!!.getSerializable("pdf") as PdfData)
        }
    }
    private fun init() = with(binding){
        rcView.layoutManager = GridLayoutManager(this@RecyclerActivity, 1)
        rcView.adapter = adapter
        button2.setOnClickListener{
            val infoActivity = Intent(this@RecyclerActivity, InfoActivity::class.java)
            startActivity(infoActivity)
        }
    }

    override fun onClick(pdfData: PdfData) {
        val choiceActivity = Intent(this, ChoiceActivity::class.java)
        choiceActivity.putExtra("pdf", pdfData)
        startActivity(choiceActivity)
    }
}