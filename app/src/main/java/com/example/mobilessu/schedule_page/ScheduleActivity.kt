package com.example.mobilessu.schedule_page

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import kotlinx.android.synthetic.main.activity_schedule.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException
import java.util.*


class ScheduleActivity : AppCompatActivity() {
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
            when (dayOfWeek) {
                1 -> dayofweek.text = "Понедельник"
                2 -> dayofweek.text = "Вторник"
                3 -> dayofweek.text = "Среда"
                4 -> dayofweek.text = "Четверг"
                5 -> dayofweek.text = "Пятница"
                6 -> dayofweek.text = "Суббота"
                7 -> dayofweek.text = "Воскресенье"
            }
        }
    }


    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}