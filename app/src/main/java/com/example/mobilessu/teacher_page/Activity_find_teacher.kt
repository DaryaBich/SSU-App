package com.example.mobilessu.teacher_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mobilessu.R
import com.example.mobilessu.entities.Teacher
import com.example.mobilessu.news_page.MyArrayAdapter
import com.example.mobilessu.news_page.News_interface
import com.example.mobilessu.news_page.News_presenter
import kotlinx.android.synthetic.main.activity_find_teacher.*
import kotlinx.android.synthetic.main.activity_news.*

class Activity_find_teacher :  AppCompatActivity() , Teacher_interface.View{
    var presenter: Teacher_interface.Presenter = Teacher_presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_teacher)
        button_teacher.setOnClickListener {
            if(teacher_name.text.toString()!=""){
                presenter.searchInputTeachers(teacher_name.text.toString())
            }
            Toast.makeText(
                applicationContext,
                "Введите ФИО",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    fun click_back(view: View) {
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    override fun showTeachers(list: List<Teacher>) {
        if (list.size > 0) {
            val adapter = TeacherArrayAdapter(this,R.layout.news_list_items, list)
            teacher_list.adapter = adapter
        } else {
            Toast.makeText(
                applicationContext,
                "По запросу ничего не найдено",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}