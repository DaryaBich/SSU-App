package com.example.mobilessu.news_page

class NewsPresenter(var view: NewsInterface.View) :
    NewsInterface.Presenter {
    var model: NewsInterface.Model = NewsModel()

    override fun getData() {
        val list = model.getNews()
        view.showNews(list)
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}