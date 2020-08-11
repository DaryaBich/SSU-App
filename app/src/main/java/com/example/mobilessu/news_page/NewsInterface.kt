package com.example.mobilessu.news_page

import com.example.mobilessu.entities.News
import java.io.IOException

interface NewsInterface {
    interface Model {
        @Throws(IOException::class)
        fun getNews() :List<News>
    }

    interface View {
        fun showNews(list:List<News>)
    }

    interface Presenter {
        fun getData()
        fun onDestroy()
    }
}
