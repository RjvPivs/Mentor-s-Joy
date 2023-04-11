package com.example.mentorsjoy.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mentorsjoy.model.*

@Database(entities = [PdfData::class, SectionsPZ::class, SectionsTZ::class, SectionsPMI::class, SectionsRO::class, SectionsTP::class], version = 3)
abstract class PDFDataBase : RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{
        fun get(context: Context) : PDFDataBase {
            return Room.databaseBuilder(context.applicationContext, PDFDataBase::class.java, "PDFDB.db").fallbackToDestructiveMigration().build()
        }
    }
}