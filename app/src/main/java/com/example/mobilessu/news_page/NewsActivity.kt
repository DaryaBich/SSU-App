package com.example.mobilessu.news_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilessu.R
import com.example.mobilessu.entities.News


class NewsActivity : NewsInterface.View, AppCompatActivity() {

    var presenter: NewsInterface.Presenter = NewsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getData()
    }

    override fun showNews(list: List<News>) {
        // вывод входного списка на экран
    }

    //fun clickmenu(view: View){
    //    val randomIntent = Intent(this, MainActivity_student_faculty::class.java)
    //     startActivity(randomIntent)
    // }
}