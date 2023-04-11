package com.example.mentorsjoy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TPs")
data class SectionsTP(@PrimaryKey private var projectName: String) : java.io.Serializable{
    @ColumnInfo(name = "intro")
    private var intro //1
            : String? = null

    @ColumnInfo(name = "source")
    private var source //2
            : String? = null

    fun setProjectName(projectName: String?) {
        if (projectName != null) {
            this.projectName = projectName
        }
    }

    fun setIntro(intro: String?) {
        this.intro = intro
    }

    fun setSource(source: String?) {
        this.source = source
    }

    fun getProjectName(): String? {
        return projectName
    }

    fun getIntro(): String? {
        return intro
    }

    fun getSource(): String? {
        return source
    }
}
