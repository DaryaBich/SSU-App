package com.example.mobilessu.news_page

import android.content.Intent


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mobilessu.R
import com.example.mobilessu.entities.News
import com.example.mobilessu.menu_page.Activity_menu

class Activity_news : News_interface.View, AppCompatActivity() {

    var presenter: News_interface.Presenter = News_presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        presenter.getData() // получение новостей
    }

    override fun showNews(list: List<News>) {
        if (list.size > 0) {
            // вывод входного списка на экран
        } else {
            Toast.makeText(
                applicationContext,
                "Проверьте подключение к интернету",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    fun clickmenu(view: View) {
        val randomIntent = Intent(this, Activity_menu::class.java)
        startActivity(randomIntent)
    }

}