package com.example.mentorsjoy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


data class Sec( var title: String) {
    lateinit var paragraphs: Array<String>

}