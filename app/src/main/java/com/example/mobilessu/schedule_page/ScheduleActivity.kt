package com.example.mobilessu.schedule_page

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.choose_course.Activity_course
import com.example.mobilessu.entities.LessonData
import com.example.mobilessu.entities.ScheduleData
import com.example.mobilessu.group_page.Activity_group
import com.example.mobilessu.group_page.Group_interface
import com.example.mobilessu.group_page.Groups_presenter
import com.example.mobilessu.group_page.MyArrayAdapterGroup
import com.example.mobilessu.session_page.SessionActivity
import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.activitygroup.*
import kotlinx.android.synthetic.main.activitymenu.view.*
import kotlinx.android.synthetic.main.activitystudentfaculty.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException
import java.security.AccessController.getContext
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
            var lessonData = LessonData("", url, 1, "", "", "", "", "")
            var list = presenter.getData(lessonData) // получение пар
            //button_lessons.setBackgroundResource(R.drawable.btn_rounded_corner_grey)
            val c = Calendar.getInstance()
            c.time = Date()
            val dayOfWeek = c[Calendar.DAY_OF_WEEK]
            when (dayOfWeek - 1) {
                0 -> {
                    dayofweek.text = "Понедельник"
                    button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                    update_schedule(1);
                }
                1 -> {
                    dayofweek.text = "Понедельник"
                    button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                    update_schedule(1);
                }
                2 -> {
                    dayofweek.text = "Вторник"
                    button_day2.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                    update_schedule(2);
                }
                3 -> {
                    dayofweek.text = "Среда"
                    button_day3.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                    update_schedule(3);
                }
                4 -> {
                    dayofweek.text = "Четверг"
                    button_day4.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                    update_schedule(4);
                }
                5 -> {
                    dayofweek.text = "Пятница"
                    button_day5.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                    update_schedule(5);
                }
                6 -> {
                    dayofweek.text = "Суббота"
                    button_day6.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                    update_schedule(6);
                }
            }
        }
    }

    fun showLessons(list: List<LessonData>) {
        if (list.isNotEmpty()) {
            val adapter = MyArrayAdapterLesson(this, R.layout.groupslistitems, list)
            //  val adapter = MyArrayAdapterGroup(this, R.layout.listitem, list)
            list_schedules.adapter = adapter
        } else {
            Toast.makeText(
                applicationContext,
                "По вашему запросу ничего не найдено. Проверьте подключение к интернету или укажите другие параметры.",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    fun click_back(view: View){
        //val randomIntent = Intent(this, Activity_group::class.java)
        //startActivity(randomIntent)
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

//    private fun returner(view: View): Int {
//        when (dayofweek.text) {
//            "Понедельник" -> return 1
//            "Вторник" -> return 2
//            "Среда" -> return 3
//            "Четверг" -> return 4
//            "Пятница" -> return 5
//            "Суббота" -> return 6
//            else -> return 1
//        }
//    }

    fun update_schedule(num: Int){
        val arguments = intent.extras
        var lessonData = LessonData("", "", num, "", "", "", "", "")
        if (arguments != null) {
            val url = arguments["url"].toString()
            lessonData = LessonData("", url, num, "", "", "", "", "")
        }
        var list = presenter.getData(lessonData) // получение пар
    }

//    fun lesson_on(view: View) {
//        button_day1.visibility = View.VISIBLE
//        button_day2.visibility = View.VISIBLE
//        button_day3.visibility = View.VISIBLE
//        button_day4.visibility = View.VISIBLE
//        button_day5.visibility = View.VISIBLE
//        button_day6.visibility = View.VISIBLE
//        dayofweek.visibility = View.VISIBLE
//        list_schedules.visibility = View.VISIBLE
//    }

//    fun lesson_off(view: View) {
//        button_day1.visibility = View.INVISIBLE
//        button_day2.visibility = View.INVISIBLE
//        button_day3.visibility = View.INVISIBLE
//        button_day4.visibility = View.INVISIBLE
//        button_day5.visibility = View.INVISIBLE
//        button_day6.visibility = View.INVISIBLE
//        dayofweek.visibility = View.INVISIBLE
//        list_schedules.visibility = View.INVISIBLE
//    }

    fun click_lessons(view: View) {
//        button_lessons.setBackgroundResource(R.drawable.btn_rounded_corner_grey)
//        button_sessions.setBackgroundResource(R.drawable.btn_rounded_corner)
//        lesson_on(view)
    }

    fun click_sessions(view: View) {
        //button_lessons.setBackgroundResource(R.drawable.btn_rounded_corner)
        //button_sessions.setBackgroundResource(R.drawable.btn_rounded_corner_grey)
        val randomIntent = Intent(this, SessionActivity::class.java)
        val arguments = intent.extras
        val url = arguments?.get("url").toString()
        randomIntent.putExtra("url", url)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.quick_in, R.anim.quick_out)
        //lesson_off(view)
    }

    fun openallbuttons(view: View) {
        button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day2.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day3.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day4.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day5.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
        button_day6.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week)
    }




//    fun updatelocationbuttons(view: View) {
//        when(returner(view)) {
//            1 -> {
//                val params: RelativeLayout.LayoutParams = new RelativeLayout.LayoutParams
//                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
//                button_day1.layoutParams = params
//            }
//        }
//    }

    fun click1(view: View){
        dayofweek.text = "Понедельник"
        openallbuttons(view)
        button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        update_schedule(1)
        overridePendingTransition(R.anim.quick_in, R.anim.quick_out)
    }

    fun click2(view: View){
        dayofweek.text = "Вторник"
        openallbuttons(view)
        button_day2.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        update_schedule(2)
    }

    fun click3(view: View){
        dayofweek.text = "Среда"
        openallbuttons(view)
        button_day3.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        update_schedule(3)
        return
    }

    fun click4(view: View){
        dayofweek.text = "Четверг"
        openallbuttons(view)
        button_day4.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        update_schedule(4)
    }

    fun click5(view: View){
        dayofweek.text = "Пятница"
        openallbuttons(view)
        button_day5.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        update_schedule(5)
    }

    fun click6(view: View){
        dayofweek.text = "Суббота"
        openallbuttons(view)
        button_day6.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        update_schedule(6)
    }
}