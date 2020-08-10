package com.example.mobilessu.entities

// класс хранит данные о новостях

public class NewsData(
    private var date: String, private var title: String,
    private var image: String
) {
    fun getDate() {
        date
    }

    fun getTitle() {
        title
    }

    fun getImage() {
        image
    }

    fun setDate(date: String) {
        this.date = date
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun setImage(image: String) {
        this.image = image
    }
}