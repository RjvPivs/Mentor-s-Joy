package com.example.mentorsjoy.view.basicActivities

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.mentorsjoy.R
import com.example.mentorsjoy.backend.Generator
import com.example.mentorsjoy.backend.SectionConverter
import com.example.mentorsjoy.model.*
import com.github.barteksc.pdfviewer.PDFView
import java.io.File
import java.io.InputStream
import java.io.OutputStream

class GenerationActivity : AppCompatActivity() {
    private lateinit var pdfView: PDFView
    private lateinit var result: File
    private lateinit var type: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tzactivity)
        val arguments = intent.extras
        var pdfData = arguments!!.getSerializable("pdf") as PdfData
        var file = File(filesDir, "aboba.pdf")
        type = arguments!!.getString("type")!!
        lateinit var document: Any
        when (type) {
            "PZ" -> {
                document = arguments!!.getSerializable("doc") as SectionsPZ

            }
            "TZ" -> {
                document = arguments!!.getSerializable("doc") as SectionsTZ

            }
            "PMI" -> {
                document = arguments!!.getSerializable("doc") as SectionsPMI
            }
            "TP" -> {
                document = arguments!!.getSerializable("doc") as SectionsTP
            }
            "RO" -> {
                document = arguments!!.getSerializable("doc") as SectionsRO
            }
        }
        Generator.createPdf(
            file.canonicalPath,
            pdfData,
            SectionConverter.CallConverter(document, type),
            type
        )
        pdfView = findViewById(R.id.pdfView)
        pdfView.fromFile(file).load()
        result = file
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun createFile(view: View) {
        var resolver: ContentResolver = contentResolver
        var values: ContentValues = ContentValues()
        lateinit var name: String
        when (type) {
            "PZ" -> name = "Poyasnitelnaya_zapiska"
            "TZ" -> name = "Technicheskoe_zadanie"
            "PMI" -> name = "metodika ispyraniy"
            "TP" -> name = "Text programmy"
            "RO" -> name = "Rukovodstvo operatora"
        }
        values.put(MediaStore.MediaColumns.DISPLAY_NAME, name + ".pdf")
        values.put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
        values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
        val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values)
        var p: OutputStream? = uri?.let { resolver.openOutputStream(it) }
        var temp: InputStream = result.inputStream()
        p.use { out ->
            if (out != null) {
                temp.copyTo(out)
            }
        }
        temp.close()
        p?.close()
    }
}