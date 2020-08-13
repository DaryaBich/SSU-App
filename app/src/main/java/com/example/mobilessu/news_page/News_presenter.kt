package com.example.mobilessu.news_page

import com.example.mobilessu.entities.News

class News_presenter(var view: News_interface.View) :
    News_interface.Presenter {
    var model: News_interface.Model =
        News_model()

    override fun getData() {
        val list = model.getNews()
        view.showNews(list)
    }
}