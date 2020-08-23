package com.example.mobilessu.group_page

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.entities.News
import com.example.mobilessu.entities.ScheduleData
import com.example.mobilessu.news_page.MyArrayAdapter
import com.example.mobilessu.news_page.News_interface
import com.example.mobilessu.news_page.News_presenter
import kotlinx.android.synthetic.main.activity_group.*
import kotlinx.android.synthetic.main.activity_news.*
import org.jsoup.Jsoup


class Activity_group : AppCompatActivity() {
    var presenter: Group_interface.Presenter = Groups_presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        presenter.getData() // получение новостей
    }

    override fun showGroups(list: List<ScheduleData>) {
        if (list.size > 0) {
            val adapter = MyArrayAdapter(this,R.layout.news_list_items, list)
            list_of_news.adapter = adapter
        } else {
            Toast.makeText(
                applicationContext,
                "Проверьте подключение к интернету",
                Toast.LENGTH_LONG
            ).show()
        }

    }

//            textView.setText(
//                """
//                    Name: $name
//                    Company: $company
//                    Price: $price
//                    """.trimIndent()
//            )

    fun click_back(view: View){
        finish()
        overridePendingTransition(
            R.anim.fide_in,
            R.anim.fide_out
        );
    }
}