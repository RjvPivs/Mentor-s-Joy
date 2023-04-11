package com.example.mentorsjoy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PZs")
data class SectionsPZ(@PrimaryKey private var projectName: String) : java.io.Serializable {
    @ColumnInfo(name = "projectNameEnglish")
    private var projectNameEnglish //1.1
            : String? = null

    @ColumnInfo(name = "docIncentive")
    private var docIncentive //1.2
            : String? = null

    @ColumnInfo(name = "func")
    private var func //2.1
            : String? = null

    @ColumnInfo(name = "exp")
    private var exp //2.2
            : String? = null

    @ColumnInfo(name = "scope")
    private var scope //2.3
            : String? = null

    @ColumnInfo(name = "task")
    private var task //3.1
            : String? = null

    @ColumnInfo(name = "algorithm")
    private var algorithm //3.2
            : String? = null

    @ColumnInfo(name = "iO")
    private var iO //3.3
            : String? = null

    @ColumnInfo(name = "hardware")
    private var hardware //3.4
            : String? = null

    @ColumnInfo(name = "usage")
    private var usage //4.2
            : String? = null

    @ColumnInfo(name = "comparison")
    private var comparison //4.3
            : String? = null

    fun setProjectNameEnglish(projectNameEnglish: String?) {
        this.projectNameEnglish = projectNameEnglish
    }

    fun setProjectName(projectName: String?) {
        if (projectName != null) {
            this.projectName = projectName
        }
    }

    fun setHardware(hardware: String?) {
        this.hardware = hardware
    }

    fun setDocIncentive(docIncentive: String?) {
        this.docIncentive = docIncentive
    }

    fun setComparison(comparison: String?) {
        this.comparison = comparison
    }

    fun setAlgorithm(algorithm: String?) {
        this.algorithm = algorithm
    }

    fun setFunc(func: String?) {
        this.func = func
    }

    fun setExp(exp: String?) {
        this.exp = exp
    }

    fun setIO(iO: String?) {
        this.iO = iO
    }

    fun setScope(scope: String?) {
        this.scope = scope
    }

    fun setTask(task: String?) {
        this.task = task
    }

    fun setUsage(usage: String?) {
        this.usage = usage
    }

    fun getProjectName(): String? {
        return projectName
    }

    fun getHardware(): String? {
        return hardware
    }

    fun getUsage(): String? {
        return usage
    }

    fun getTask(): String? {
        return task
    }

    fun getProjectNameEnglish(): String? {
        return projectNameEnglish
    }

    fun getDocIncentive(): String? {
        return docIncentive
    }

    fun getScope(): String? {
        return scope
    }

    fun getFunc(): String? {
        return func
    }

    fun getExp(): String? {
        return exp
    }

    fun getComparison(): String? {
        return comparison
    }

    fun getAlgorithm(): String? {
        return algorithm
    }

    fun getIO(): String? {
        return iO
    }
}