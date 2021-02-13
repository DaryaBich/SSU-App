package com.example.mobilessu.entities

class SessionData  (
    private var name: String,
    private var url: String,
    private var date: String,
    private var time: String,
    private var teacher: String,
    private var place: String
){
    fun getname(): String {
        return name
    }
    fun geturl(): String {
        return url
    }
    fun getdate(): String {
        return date
    }
    fun gettime(): String {
        return time
    }
    fun getteacher(): String {
        return teacher
    }
    fun getplace(): String {
        return place
    }
}