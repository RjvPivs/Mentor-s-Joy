package com.example.mentorsjoy

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

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

    private fun makeRequest() {

    }
}