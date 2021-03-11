package com.example.mobilessu.entities

class LessonData (
    private var name: String,
    private var url: String,
    private var num: Int,
    private var lec_pr: String,
    private var ch_zn: String,
    private var teacher: String,
    private var place: String,
    private var time: String
    //private var : String,
    //private var course: String,
    //private var group: String
) {

    fun getname(): String {
        return name
    }
    fun geturl(): String {
        return url
    }
    fun getnum(): Int {
        return num
    }
    fun getlec_pr(): String {
        return lec_pr
    }
    fun getch_zn(): String {
        return ch_zn
    }
    fun getplace(): String {
        return place
    }
    fun getteacher(): String {
        return teacher
    }
    fun gettime(): String{
        return time
    }
    fun setnum(num: Int) {
        this.num = num
    }
}