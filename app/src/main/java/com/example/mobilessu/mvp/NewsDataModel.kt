package com.example.mobilessu.mvp

import com.example.mobilessu.entities.NewsData

// Класс отвечающий за парсинг новостей

public class NewsDataModel : MVPContract.Model {
    // Функция парсинга новостей с сайта www.sgu.ru
    fun getNews(): MutableList<NewsData> {
        return MutableList(1, { x -> NewsData("1", "2", "3") })
    }
}