package com.example.mentorsjoy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ROs")
data class SectionsRO(@PrimaryKey private var projectName: String) {
    @ColumnInfo(name = "func")
    private var func //1.1
            : String? = null

    @ColumnInfo(name = "exp")
    private var exp //1.2
            : String? = null

    @ColumnInfo(name = "funcList")
    private var funcList //1.3
            : String? = null

    @ColumnInfo(name = "hardware")
    private var hardware //2.1
            : String? = null

    @ColumnInfo(name = "software")
    private var software //2.2
            : String? = null

    @ColumnInfo(name = "user")
    private var user //2.3
            : String? = null

    @ColumnInfo(name = "install")
    private var install //3.1
            : String? = null

    @ColumnInfo(name = "launch")
    private var launch //3.2
            : String? = null

    @ColumnInfo(name = "work")
    private var work //3.3
            : String? = null

    @ColumnInfo(name = "finish")
    private var finish //3.4
            : String? = null

    @ColumnInfo(name = "msg")
    private var msg //4.1
            : String? = null

    @ColumnInfo(name = "errors")
    private var errors //4.2
            : String? = null

    fun setHardware(hardware: String?) {
        this.hardware = hardware
    }

    fun setProjectName(projectName: String?) {
        if (projectName != null) {
            this.projectName = projectName
        }
    }

    fun setExp(exp: String?) {
        this.exp = exp
    }

    fun setFunc(func: String?) {
        this.func = func
    }

    fun setUser(user: String?) {
        this.user = user
    }

    fun setErrors(errors: String?) {
        this.errors = errors
    }

    fun setFinish(finish: String?) {
        this.finish = finish
    }

    fun setInstall(install: String?) {
        this.install = install
    }

    fun setLaunch(launch: String?) {
        this.launch = launch
    }

    fun setMsg(msg: String?) {
        this.msg = msg
    }

    fun setWork(work: String?) {
        this.work = work
    }

    fun setFuncList(funcList: String?) {
        this.funcList = funcList
    }

    fun setSoftware(software: String?) {
        this.software = software
    }

    fun getExp(): String? {
        return exp
    }

    fun getFunc(): String? {
        return func
    }

    fun getProjectName(): String? {
        return projectName
    }

    fun getHardware(): String? {
        return hardware
    }

    fun getUser(): String? {
        return user
    }

    fun getErrors(): String? {
        return errors
    }

    fun getFinish(): String? {
        return finish
    }

    fun getInstall(): String? {
        return install
    }

    fun getLaunch(): String? {
        return launch
    }

    fun getMsg(): String? {
        return msg
    }

    fun getWork(): String? {
        return work
    }

    fun getFuncList(): String? {
        return funcList
    }

    fun getSoftware(): String? {
        return software
    }
}
