package com.example.mentorsjoy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TZs")
data class SectionsTZ(@PrimaryKey private var projectName: String) : java.io.Serializable {
    @ColumnInfo(name = "projectNameEnglish")
    private var projectNameEnglish //1.1
            : String? = null

    @ColumnInfo(name = "scope")
    private var scope //1.2
            : String? = null

    @ColumnInfo(name = "docIncentive")
    private var docIncentive //2
            : String? = null

    @ColumnInfo(name = "func")
    private var func //3.1
            : String? = null

    @ColumnInfo(name = "exp")
    private var exp //3.2
            : String? = null

    @ColumnInfo(name = "functions")
    private var functions //4.1
            : String? = null

    @ColumnInfo(name = "inter")
    private var inter //4.2
            : String? = null

    @ColumnInfo(name = "robustness")
    private var robustness //4.3
            : String? = null

    @ColumnInfo(name = "user")
    private var user //4.4
            : String? = null

    @ColumnInfo(name = "hardware")
    private var hardware //4.5
            : String? = null

    @ColumnInfo(name = "compatability")
    private var compatability //4.6
            : String? = null

    @ColumnInfo(name = "packaging")
    private var packaging //4.7
            : String? = null

    @ColumnInfo(name = "storage")
    private var storage //4.8
            : String? = null

    @ColumnInfo(name = "usage")
    private var usage //6.2
            : String? = null

    @ColumnInfo(name = "comparison")
    private var comparison //6.3
            : String? = null

    @ColumnInfo(name = "tests")
    private var tests //8.1
            : String? = null

    @ColumnInfo(name = "acceptance")
    private var acceptance //8.2
            : String? = null

    fun setComparison(comparison: String?) {
        this.comparison = comparison
    }

    fun setUsage(usage: String?) {
        this.usage = usage
    }

    fun setDocIncentive(docIncentive: String?) {
        this.docIncentive = docIncentive
    }

    fun setHardware(hardware: String?) {
        this.hardware = hardware
    }

    fun setProjectName(projectName: String?) {
        if (projectName != null) {
            this.projectName = projectName
        }
    }

    fun setScope(scope: String?) {
        this.scope = scope
    }

    fun setExp(exp: String?) {
        this.exp = exp
    }

    fun setFunc(func: String?) {
        this.func = func
    }

    fun setProjectNameEnglish(projectNameEnglish: String?) {
        this.projectNameEnglish = projectNameEnglish
    }

    fun setAcceptance(acceptance: String?) {
        this.acceptance = acceptance
    }

    fun setCompatability(compatability: String?) {
        this.compatability = compatability
    }

    fun setFunctions(functions: String?) {
        this.functions = functions
    }

    fun setInter(inter: String?) {
        this.inter = inter
    }

    fun setPackaging(packaging: String?) {
        this.packaging = packaging
    }

    fun setRobustness(robustness: String?) {
        this.robustness = robustness
    }

    fun setStorage(storage: String?) {
        this.storage = storage
    }

    fun setTests(tests: String?) {
        this.tests = tests
    }

    fun setUser(user: String?) {
        this.user = user
    }

    fun getComparison(): String? {
        return comparison
    }

    fun getExp(): String? {
        return exp
    }

    fun getDocIncentive(): String? {
        return docIncentive
    }

    fun getFunc(): String? {
        return func
    }

    fun getProjectName(): String? {
        return projectName
    }

    fun getScope(): String? {
        return scope
    }

    fun getProjectNameEnglish(): String? {
        return projectNameEnglish
    }

    fun getHardware(): String? {
        return hardware
    }

    fun getUsage(): String? {
        return usage
    }

    fun getAcceptance(): String? {
        return acceptance
    }

    fun getCompatability(): String? {
        return compatability
    }

    fun getFunctions(): String? {
        return functions
    }

    fun getInter(): String? {
        return inter
    }

    fun getPackaging(): String? {
        return packaging
    }

    fun getRobustness(): String? {
        return robustness
    }

    fun getStorage(): String? {
        return storage
    }

    fun getTests(): String? {
        return tests
    }

    fun getUser(): String? {
        return user
    }
}