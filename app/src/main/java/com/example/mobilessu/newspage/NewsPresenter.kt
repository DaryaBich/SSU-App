package com.example.mobilessu.newspage

class NewsPresenter(var view: NewsInterface.View) :
    NewsInterface.Presenter {
    var model: NewsInterface.Model =
        NewsModel()

    override fun getData() {
        val list = model.getNews()
        view.showNews(list)
    }
}