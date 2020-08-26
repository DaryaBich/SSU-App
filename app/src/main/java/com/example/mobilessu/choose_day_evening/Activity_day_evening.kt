package com.example.mobilessu.choose_day_evening

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mobilessu.R
import com.example.mobilessu.choose_course.Activity_course
import kotlinx.android.synthetic.main.activitydayevening.*

class Activity_day_evening : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitydayevening)
        val arguments = intent.extras
        if (arguments != null) {
            val faculty = arguments["faculty"].toString()

            val demodata = mutableListOf<String>()
            demodata.add("Дневная")
            demodata.add("Вечерняя")
            demodata.add("Заочная")

            val adapter = ArrayAdapter<String>(this, R.layout.listitem, demodata)

            list_day_evening.adapter = adapter
            list_day_evening.setOnItemClickListener { adapterView, view, i, l ->
                //Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
                val element = (view as TextView).text // получаем текст нажатого элемента
                val randomIntent = Intent(this, Activity_course::class.java)
                randomIntent.putExtra("faculty", faculty)
                when (element) {
                    "Дневная" -> randomIntent.putExtra(
                        "day_evening",
                        "do/"
                    ) //передали форму обучения
                    else -> randomIntent.putExtra("day_evening", "")
                }

                //val randomIntent = Intent(this, Activity_course::class.java)
                startActivity(randomIntent)
                overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
            }
        }
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}