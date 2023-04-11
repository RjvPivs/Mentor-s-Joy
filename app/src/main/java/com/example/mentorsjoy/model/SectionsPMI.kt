package com.example.mentorsjoy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PMIs")
data class SectionsPMI(@PrimaryKey private var projectName: String) : java.io.Serializable {
    @ColumnInfo(name = "projectNameEnglish")
    private var projectNameEnglish //1.1
            : String? = null

    @ColumnInfo(name = "scope")
    private var scope //1.2
            : String? = null

    @ColumnInfo(name = "target")
    private var target //2
            : String? = null

    @ColumnInfo(name = "functions")
    private var functions //3.1
            : String? = null

    @ColumnInfo(name = "inter")
    private var inter //3.2
            : String? = null

    @ColumnInfo(name = "robustness")
    private var robustness //3.3
            : String? = null

    @ColumnInfo(name = "doc")
    private var doc //4
            : String? = null

    @ColumnInfo(name = "hardware")
    private var hardware //5.1
            : String? = null

    @ColumnInfo(name = "testsOrder")
    private var testsOrder //5.2
            : String? = null

    @ColumnInfo(name = "docTests")
    private var docTests //6.1
            : String? = null

    @ColumnInfo(name = "funcTests")
    private var funcTests //6.2
            : String? = null

    @ColumnInfo(name = "interTests")
    private var interTests //6.3
            : String? = null

    @ColumnInfo(name = "robustTests")
    private var robustTests //6.4
            : String? = null

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

    fun setProjectNameEnglish(projectNameEnglish: String?) {
        this.projectNameEnglish = projectNameEnglish
    }

    fun setFunctions(functions: String?) {
        this.functions = functions
    }

    fun setInter(inter: String?) {
        this.inter = inter
    }

    fun setRobustness(robustness: String?) {
        this.robustness = robustness
    }

    fun setDoc(doc: String?) {
        this.doc = doc
    }

    fun setDocTests(docTests: String?) {
        this.docTests = docTests
    }

    fun setFuncTests(funcTests: String?) {
        this.funcTests = funcTests
    }

    fun setInterTests(interTests: String?) {
        this.interTests = interTests
    }

    fun setRobustTests(robustTests: String?) {
        this.robustTests = robustTests
    }

    fun setTarget(target: String?) {
        this.target = target
    }

    fun setTestsOrder(testsOrder: String?) {
        this.testsOrder = testsOrder
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

    fun getFunctions(): String? {
        return functions
    }

    fun getInter(): String? {
        return inter
    }

    fun getRobustness(): String? {
        return robustness
    }

    fun getDoc(): String? {
        return doc
    }

    fun getDocTests(): String? {
        return docTests
    }

    fun getFuncTests(): String? {
        return funcTests
    }

    fun getInterTests(): String? {
        return interTests
    }

    fun getRobustTests(): String? {
        return robustTests
    }

    fun getTarget(): String? {
        return target
    }

    fun getTestsOrder(): String? {
        return testsOrder
    }
}