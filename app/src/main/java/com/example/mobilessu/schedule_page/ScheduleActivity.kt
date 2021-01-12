package com.example.mobilessu.schedule_page

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.mobilessu.R
import kotlinx.android.synthetic.main.activity_schedule.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException
import java.util.*


class ScheduleActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        val arguments = intent.extras
        if (arguments != null) {
            val faculty = arguments["faculty"].toString()
            val dayevening = arguments["dayevening"].toString()
            val course = arguments["course"].toString()
            val group = arguments["group"].toString()
            val url = "https://www.sgu.ru/schedule$faculty$dayevening/$group"


            val downloadThread: Thread = object : Thread() {
                override fun run() {
                    val doc: Document
                    try {
                        doc = Jsoup.connect(url).get()
                        val title = doc.title()
                        print(title)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
            downloadThread.start()




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
                0 -> dayofweek.text = "Понедельник"
                1 -> dayofweek.text = "Понедельник"
                2 -> dayofweek.text = "Вторник"
                3 -> dayofweek.text = "Среда"
                4 -> dayofweek.text = "Четверг"
                5 -> dayofweek.text = "Пятница"
                6 -> dayofweek.text = "Суббота"
            }
        }
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    private fun returner(view: View): Int {
        when (dayofweek.text) {
            "Понедельник" -> return 1
            "Вторник" -> return 2
            "Среда" -> return 3
            "Четверг" -> return 4
            "Пятница" -> return 5
            "Суббота" -> return 6
            else -> return 1
        }
    }

    fun openallbuttons(view: View) {
        button_day1.isActivated = true
        button_day2.isActivated = true
        button_day3.isActivated = true
        button_day4.isActivated = true
        button_day5.isActivated = true
        button_day6.isActivated = true
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
        button_day1.isActivated = false
    }

    fun click2(view: View){
        dayofweek.text = "Вторник"
        openallbuttons(view)
        button_day2.isActivated = false
    }

    fun click3(view: View){
        dayofweek.text = "Среда"
        openallbuttons(view)
        button_day3.isActivated = false
    }

    fun click4(view: View){
        dayofweek.text = "Четверг"
        openallbuttons(view)
        button_day4.isActivated = false
    }

    fun click5(view: View){
        dayofweek.text = "Пятница"
        openallbuttons(view)
        button_day5.isActivated = false
    }

    fun click6(view: View){
        dayofweek.text = "Суббота"
        openallbuttons(view)
        button_day6.isActivated = false
    }
}