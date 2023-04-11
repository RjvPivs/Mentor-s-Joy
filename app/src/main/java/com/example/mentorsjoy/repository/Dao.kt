package com.example.mentorsjoy.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mentorsjoy.model.*
import kotlinx.coroutines.flow.Flow

@androidx.room.Dao
interface Dao {
    @Insert
    fun insert(pdf: PdfData)
    @Insert
    fun insert(sec: SectionsPZ)
    @Insert
    fun insert(sec: SectionsTZ)
    @Insert
    fun insert(sec: SectionsTP)
    @Insert
    fun insert(sec: SectionsPMI)
    @Insert
    fun insert(sec: SectionsRO)
    @Update
    fun update(sec: SectionsPZ)
    @Update
    fun update(sec: SectionsTZ)
    @Update
    fun update(sec: SectionsPMI)
    @Update
    fun update(sec: SectionsTP)
    @Update
    fun update(sec: SectionsRO)
    @Query("Select * FROM Pzs WHERE :s = projectName")
    fun getPzs(s: String?) : List<SectionsPZ>
    @Query("Select * FROM Tzs WHERE :s = projectName")
    fun getTzs(s: String?) : List<SectionsTZ>
    @Query("Select * FROM TPs WHERE :s = projectName")
    fun getTPs(s: String?) : List<SectionsTP>
    @Query("Select * FROM PMIs WHERE :s = projectName")
    fun getPMIs(s: String?) : List<SectionsPMI>
    @Query("Select * FROM ROs WHERE :s = projectName")
    fun getROs(s: String?) : List<SectionsRO>
    @Query("SELECT * FROM PDfs")
    fun getAllPdf(): Flow<List<PdfData>>
    @Query("Select * FROM PDFs WHERE :s = projectName")
    fun getPdf(s: String?) : List<PdfData>
    @Delete
    fun delete(pdf: PdfData)
    @Delete
    fun delete(sec: SectionsPZ)
    @Delete
    fun delete(sec: SectionsTZ)
    @Delete
    fun delete(sec: SectionsTP)
    @Delete
    fun delete(sec: SectionsPMI)
    @Delete
    fun delete(sec: SectionsRO)
}