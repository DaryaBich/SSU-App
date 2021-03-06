package com.example.mobilessu.news_page

class NewsPresenter(var view: ActivityNews) :
    NewsInterface.Presenter {
    var model: NewsInterface.Model =
        NewsModel()
    override fun getData() {
        val list = model.getNews()
        view.showNews(list)
    }
}