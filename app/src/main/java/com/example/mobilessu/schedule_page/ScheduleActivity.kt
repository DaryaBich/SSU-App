package com.example.mobilessu.schedule_page

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.entities.LessonData
import com.example.mobilessu.entities.ScheduleData
import com.example.mobilessu.group_page.Group_interface
import com.example.mobilessu.group_page.Groups_presenter
import com.example.mobilessu.group_page.MyArrayAdapterGroup
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
            //val faculty = arguments["faculty"].toString()
            //val dayevening = arguments["dayevening"].toString()
            //val course = arguments["course"].toString()
           // val group = arguments["group"].toString()
            val url = arguments["url"].toString()
            val lessonData = LessonData("", url)
            val list = presenter.getData(lessonData) // получение пар
           // val url = "https://www.sgu.ru/schedule$faculty$dayevening/$group"
            //val demoschedule = mutableListOf<String>()
            //val adapter = ArrayAdapter<String>(this, R.layout.listitem, demoschedule)
            //var doc: Document? = null

//            val downloadThread: Thread = object : Thread() {
//                override fun run() {
//                    //var doc: Document? = null
//                    try {
//                        doc = Jsoup.connect(url).get()
//                        //val title = doc.title()
//                            //print(title)
////                        var listschedule: Elements
////                        val demoschedule = mutableListOf<String>()
////                        listschedule = doc.select("td[id*=1_2]")
////                        for (element in listschedule) {
////                            val gr = element.select("div[class*=1-dn]").text()
////                            demoschedule.add(gr)
////                        }
////                        val adapter = ArrayAdapter<String>(this, R.layout.listitem, demoschedule)
////                        list_schedules.adapter = adapter
//
//
//                    } catch (e: IOException) {
//                        e.printStackTrace()
//                    }
////                    var listschedule: Elements? = null
////                    if (doc != null) {
////                        listschedule = doc.select("td[id*=1_2]")
////                    }
////                    if (listschedule != null) {
////                        for (element in listschedule) {
////                            val gr = element.select("div[class*=l-dn]").text()
////                            demoschedule.add(gr)
////                        }
////                    }
////                    val adapter = ArrayAdapter<String>(this, R.layout.listitem, demoschedule)
////                    list_schedules.adapter = adapter
//                }
//            }
            //downloadThread.start()
//            doc = Jsoup.connect(url).get()
//            var listschedule: Elements? = null
//            if (doc != null) {
//                listschedule = doc!!.select("td[id*=1_2]")
//            }
//            if (listschedule != null) {
//                for (element in listschedule) {
//                    val gr = element.select("div[class*=l-dn]").text()
//                    demoschedule.add(gr)
//                }
//            }
            //val adapter = ArrayAdapter<String>(this, R.layout.listitem, demoschedule)
           // list_schedules.adapter = adapter
            button_lessons.setBackgroundResource(R.drawable.btn_rounded_corner_grey)





//            var document: Document? = null
//            try {
//                document = Jsoup.connect(url).timeout(100000).get()
//            }
//            catch(e: IOException) {
//
//            }
                //val listGroups = document.select("fieldset[class*=zo form_education form-wrapper]")
                //.select("a")
                //val currentDate = Date()
            val c = Calendar.getInstance()
            c.time = Date()
            val dayOfWeek = c[Calendar.DAY_OF_WEEK]
            when (dayOfWeek - 1) {
                0 -> {
                    dayofweek.text = "Понедельник"
                    button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                1 -> {
                    dayofweek.text = "Понедельник"
                    button_day1.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                2 -> {
                    dayofweek.text = "Вторник"
                    button_day2.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                3 -> {
                    dayofweek.text = "Среда"
                    button_day3.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                4 -> {
                    dayofweek.text = "Четверг"
                    button_day4.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                5 -> {
                    dayofweek.text = "Пятница"
                    button_day5.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
                6 -> {
                    dayofweek.text = "Суббота"
                    button_day6.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
                }
            }
        }
    }

    fun showLessons(list: List<String>) {
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

    fun lesson_on(view: View) {
        button_day1.visibility = View.VISIBLE
        button_day2.visibility = View.VISIBLE
        button_day3.visibility = View.VISIBLE
        button_day4.visibility = View.VISIBLE
        button_day5.visibility = View.VISIBLE
        button_day6.visibility = View.VISIBLE
        dayofweek.visibility = View.VISIBLE
        list_schedules.visibility = View.VISIBLE
    }

    fun lesson_off(view: View) {
        button_day1.visibility = View.INVISIBLE
        button_day2.visibility = View.INVISIBLE
        button_day3.visibility = View.INVISIBLE
        button_day4.visibility = View.INVISIBLE
        button_day5.visibility = View.INVISIBLE
        button_day6.visibility = View.INVISIBLE
        dayofweek.visibility = View.INVISIBLE
        list_schedules.visibility = View.INVISIBLE
    }

    fun click_lessons(view: View) {
        button_lessons.setBackgroundResource(R.drawable.btn_rounded_corner_grey)
        button_sessions.setBackgroundResource(R.drawable.btn_rounded_corner)
        lesson_on(view)
    }

    fun click_sessions(view: View) {
        button_lessons.setBackgroundResource(R.drawable.btn_rounded_corner)
        button_sessions.setBackgroundResource(R.drawable.btn_rounded_corner_grey)
        lesson_off(view)
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
    }

    fun click2(view: View){
        dayofweek.text = "Вторник"
        openallbuttons(view)
        button_day2.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
    }

    fun click3(view: View){
        dayofweek.text = "Среда"
        openallbuttons(view)
        button_day3.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
        return
    }

    fun click4(view: View){
        dayofweek.text = "Четверг"
        openallbuttons(view)
        button_day4.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
    }

    fun click5(view: View){
        dayofweek.text = "Пятница"
        openallbuttons(view)
        button_day5.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
    }

    fun click6(view: View){
        dayofweek.text = "Суббота"
        openallbuttons(view)
        button_day6.setBackgroundResource(R.drawable.btn_rounded_corner_for_day_of_week_grey)
    }
}