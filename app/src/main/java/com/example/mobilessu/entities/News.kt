package com.example.mobilessu.entities

// класс хранит данные о новостях

public class News(
    private var date: String, private var title: String,
    private var url: String
) {
    fun getDate() :String{
        return date
    }

    fun getTitle() :String{
        return title
    }

    fun getUrl() :String{
        return url
    }

    fun setDate(date: String) {
        this.date = date
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun setUrl(url: String) {
        this.url = url
    }
}