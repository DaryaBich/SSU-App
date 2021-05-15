package com.example.mobilessu.schedule_page

import android.annotation.SuppressLint
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
            val c = Calendar.getInstance()
            c.time = Date()
            val dayOfWeek = c[Calendar.DAY_OF_WEEK]
            when (dayOfWeek - 1) {
                0 -> {
                    scroll.smoothScrollTo(0, 0)
                    button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                1 -> {
                    scroll.smoothScrollTo(0, 0)
                    button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                2 -> {
                    scroll.smoothScrollTo(820, 0)
                    button_day2.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                3 -> {
                    scroll.smoothScrollTo(1730, 0)
                    button_day3.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                4 -> {
                    scroll.smoothScrollTo(2640, 0)
                    button_day4.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                5 -> {
                    scroll.smoothScrollTo(3550, 0)
                    button_day5.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                6 -> {
                    scroll.smoothScrollTo(5000, 0)
                    button_day6.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
            }
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

    fun openallbuttons(view: View) {
        button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day2.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day3.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day4.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day5.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day6.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
    }

    fun click1(view: View){
        openallbuttons(view)
        button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        scroll.smoothScrollTo(0, 0)
    }

    fun click2(view: View){
        openallbuttons(view)
        button_day2.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        scroll.smoothScrollTo(820, 0)
    }

    fun click3(view: View){
        openallbuttons(view)
        button_day3.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        scroll.smoothScrollTo(1730, 0)
        return
    }

    fun click4(view: View){
        openallbuttons(view)
        button_day4.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        scroll.smoothScrollTo(2640, 0)
    }

    fun click5(view: View){
        openallbuttons(view)
        button_day5.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        scroll.smoothScrollTo(3550, 0)
    }

    fun click6(view: View){
        openallbuttons(view)
        button_day6.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        scroll.smoothScrollTo(5000, 0)
    }
}