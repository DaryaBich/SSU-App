package com.example.mobilessu.entities

class LessonData (
    private var name: String,
    private var url: String
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
}