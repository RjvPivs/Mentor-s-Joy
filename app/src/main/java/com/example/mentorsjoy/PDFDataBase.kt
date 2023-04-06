package com.example.mentorsjoy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PdfData::class], version = 1)
abstract class PDFDataBase : RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{
        fun get(context: Context) : PDFDataBase{
            return Room.databaseBuilder(context.applicationContext, PDFDataBase::class.java, "PDFDB.db").build()
        }
    }
}