package com.example.mobilessu.news_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mobilessu.R
import com.example.mobilessu.entities.News
import com.example.mobilessu.menu_page.MainActivity_menu


class NewsActivity : NewsInterface.View, AppCompatActivity() {

    var presenter: NewsInterface.Presenter = NewsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //presenter.getData() // получение новостей
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
    fun clickmenu(view: View){
        val randomIntent = Intent(this, MainActivity_menu::class.java)
        startActivity(randomIntent)
    }

    //fun clickmenu(view: View){
    //    val randomIntent = Intent(this, MainActivity_student_faculty::class.java)
    //     startActivity(randomIntent)
    // }
}