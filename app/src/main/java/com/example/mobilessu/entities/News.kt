package com.example.mobilessu.entities

// класс хранит данные о новостях

public class News(
    private var date: String, private var title: String,
    private var url: String
) {
    fun getDate() {
        date
    }

    fun getTitle() {
        title
    }

    fun getUrl() {
        url
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