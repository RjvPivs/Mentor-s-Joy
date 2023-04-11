package com.example.mentorsjoy.view.basicActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mentorsjoy.adapter.PDFAdapter
import com.example.mentorsjoy.repository.PDFDataBase
import com.example.mentorsjoy.model.PdfData
import com.example.mentorsjoy.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(), PDFAdapter.Listener {
    private lateinit var binding: ActivityRecyclerBinding
    private val adapter = PDFAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        val db = PDFDataBase.get(this)
        db.getDao().getAllPdf().asLiveData().observe(this) {
            adapter.clear();
            it.forEach {
                adapter.addPDF(it)
            }
        }
        if (intent.hasExtra("pdf")) {
            var pdf = intent.extras!!.getSerializable("pdf") as PdfData
            Thread {
                if (db.getDao().getPdf(pdf.getProjectName()).size == 0) {
                    db.getDao().insert(pdf)
                }
            }.start()
        }
    }

    private fun init() = with(binding) {
        rcView.layoutManager = GridLayoutManager(this@RecyclerActivity, 1)
        rcView.adapter = adapter
        buttonAddFile.setOnClickListener {
            val infoActivity = Intent(this@RecyclerActivity, InfoActivity::class.java)
            startActivity(infoActivity)
        }
    }

    override fun onClickMove(pdfData: PdfData) {
        val choiceActivity = Intent(this, ChoiceActivity::class.java)
        choiceActivity.putExtra("pdf", pdfData)
        startActivity(choiceActivity)
    }

    override fun onClickDel(pdf: PdfData) {
        adapter.delete(pdf)
        val db = PDFDataBase.get(this)
        Thread {
            db.getDao().delete(pdf)
            when {
                db.getDao().getPzs(pdf.getProjectName()).isNotEmpty() -> db.getDao()
                    .delete(db.getDao().getPzs(pdf.getProjectName())[0])
                db.getDao().getTzs(pdf.getProjectName()).isNotEmpty() -> db.getDao()
                    .delete(db.getDao().getTzs(pdf.getProjectName())[0])
                db.getDao().getTPs(pdf.getProjectName()).isNotEmpty() -> db.getDao()
                    .delete(db.getDao().getTPs(pdf.getProjectName())[0])
                db.getDao().getPMIs(pdf.getProjectName()).isNotEmpty() -> db.getDao()
                    .delete(db.getDao().getPMIs(pdf.getProjectName())[0])
                db.getDao().getROs(pdf.getProjectName()).isNotEmpty() -> db.getDao()
                    .delete(db.getDao().getROs(pdf.getProjectName())[0])
            }
        }.start()
    }

    override fun onBackPressed() {
        val mainActivity = Intent(this, MainActivity::class.java)
        startActivity(mainActivity)
    }

}