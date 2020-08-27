package com.example.mobilessu.newspage
import com.example.mobilessu.entities.News
import java.io.IOException
import java.util.concurrent.ExecutionException
interface NewsInterface {
    interface Model {
        @Throws(IOException::class,
            ExecutionException::class,
            InterruptedException::class)
        fun getNews() :List<News>
    }
    interface View {
        fun showNews(list:List<News>)
    }
    interface Presenter {
        fun getData()
    }
}