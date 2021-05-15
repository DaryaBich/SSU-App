package com.example.mobilessu.schedule_page

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.entities.LessonData
import com.example.mobilessu.session_page.SessionActivity
import kotlinx.android.synthetic.main.activity_schedule.*
//import kotlinx.android.synthetic.main.activity_schedule.swipe_refresh
import kotlinx.android.synthetic.main.activity_group.*
import kotlinx.android.synthetic.main.activity_menu.view.*
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.activity_student_faculty.*
import java.io.BufferedWriter
import java.io.FileNotFoundException
import java.io.IOException
import java.io.OutputStreamWriter
import java.util.*


class ScheduleActivity : AppCompatActivity() {
    var presenter: ScheduleInterface.Presenter = SchedulePresenter(this)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        val arguments = intent.extras
        if (arguments != null) {
            val url = arguments["url"].toString()
            val gr = url.substringAfterLast('/')
            var lessonData = LessonData("", url, 1, gr, "", "", "", "", "")
            var list = presenter.getData(lessonData) // получение пар
        }
    }

    fun showLessons(list: List<LessonData>) {
        if (list.isNotEmpty()) {
            for( i in 1..6) { ///////
                val list1 = list.filter { a -> a.getnum() == i } ///////
                val adapter = MyArrayAdapterLesson(this, R.layout.groups_list_items, list1) //////
                when(i){ //////
                    1 -> list_schedules1.adapter = adapter ///////
                    2 -> list_schedules2.adapter = adapter ///////
                    3 -> list_schedules3.adapter = adapter ///////
                    4 -> list_schedules4.adapter = adapter ///////
                    5 -> list_schedules5.adapter = adapter ///////
                    6 -> list_schedules6.adapter = adapter ///////
                }
            }
        } else {
            Toast.makeText(
                applicationContext,
                "По вашему запросу ничего не найдено. Проверьте подключение к интернету или укажите другие параметры.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_lessons(view: View) {
    }

    fun click_sessions(view: View) {
        val randomIntent = Intent(this, SessionActivity::class.java)
        val arguments = intent.extras
        val url = arguments?.get("url").toString()
        randomIntent.putExtra("url", url)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.quick_in, R.anim.quick_out)
    }

    fun click_save_schedule(view: View){
        val arguments = intent.extras
        val url = arguments?.get("url").toString()
        try {
            // отрываем поток для записи
            val bw = BufferedWriter(
                OutputStreamWriter(
                    openFileOutput("file", Context.MODE_PRIVATE)
                )
            )
            // пишем данные
            bw.write(url)
            // закрываем поток
            bw.close()
            //Log.d(LOG_TAG, "Файл записан")
            Toast.makeText(
                applicationContext,
                "Теперь вы можете посмотреть своё расписание по кнопке меню \"Моё расписание\"",
                Toast.LENGTH_LONG
            ).show()
            button_save_schedule.setBackgroundResource(R.drawable.btn_rounded_corner_grey)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}