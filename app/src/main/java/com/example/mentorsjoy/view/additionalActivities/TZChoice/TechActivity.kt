package com.example.mentorsjoy.view.additionalActivities.TZChoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.mentorsjoy.R
import com.example.mentorsjoy.model.SectionsTZ
import com.example.mentorsjoy.repository.PDFDataBase

class TechActivity : AppCompatActivity() {
    lateinit var sec: SectionsTZ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tech2)
        val db = PDFDataBase.get(this)
        var name = intent.extras!!.getString("name")
        var functions: EditText = findViewById(R.id.functionsTz)
        var interfaces: EditText = findViewById(R.id.interfaceTz)
        var robustness: EditText = findViewById(R.id.robustnessTz)
        var expluatation: EditText = findViewById(R.id.expluatationTz)
        var hardware: EditText = findViewById(R.id.hardwareTz)
        var compatability: EditText = findViewById(R.id.compatibilityTz)
        var packaging: EditText = findViewById(R.id.packagingTz)
        var transport: EditText = findViewById(R.id.transportTz)
        Thread {
            sec = db.getDao().getTzs(name)[0]
            functions.post(Runnable {
                functions.setText(sec.getFunctions())
            })
            interfaces.post(Runnable {
                interfaces.setText(sec.getInter())
            })
            robustness.post(Runnable {
                robustness.setText(sec.getRobustness())
            })
            expluatation.post(Runnable {
                expluatation.setText(sec.getUser())
            })
            hardware.post(Runnable {
                hardware.setText(sec.getHardware())
            })
            compatability.post(Runnable {
                compatability.setText(sec.getCompatability())
            })
            packaging.post(Runnable {
                packaging.setText(sec.getPackaging())
            })
            transport.post(Runnable {
                transport.setText(sec.getStorage())
            })
        }.start()
    }
    fun saveTechTz(view: View){
        var functions: EditText = findViewById(R.id.functionsTz)
        var interfaces: EditText = findViewById(R.id.interfaceTz)
        var robustness: EditText = findViewById(R.id.robustnessTz)
        var expluatation: EditText = findViewById(R.id.expluatationTz)
        var hardware: EditText = findViewById(R.id.hardwareTz)
        var compatability: EditText = findViewById(R.id.compatibilityTz)
        var packaging: EditText = findViewById(R.id.packagingTz)
        var transport: EditText = findViewById(R.id.transportTz)
        sec.setFunctions(functions.text.toString())
        sec.setInter(interfaces.text.toString())
        sec.setRobustness(robustness.text.toString())
        sec.setUser(expluatation.text.toString())
        sec.setHardware(hardware.text.toString())
        sec.setCompatability(compatability.text.toString())
        sec.setPackaging(packaging.text.toString())
        sec.setStorage(transport.text.toString())
        val db = PDFDataBase.get(this)
        Thread{
            db.getDao().update(sec)
        }.start()
        var tzCheckActivity = Intent(this, TzCheckActivity::class.java)
        tzCheckActivity.putExtra("name", sec.getProjectName())
        startActivity(tzCheckActivity)
    }
}