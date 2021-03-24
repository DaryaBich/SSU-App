package com.example.mobilessu.choose_day_evening

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mobilessu.R
import com.example.mobilessu.choose_course.ActivityСourse
import kotlinx.android.synthetic.main.activity_day_evening.*

class ActivityDayEvening : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_evening)
        val arguments = intent.extras
        if (arguments != null) {
            val faculty = arguments["faculty"].toString()

            val demodata = mutableListOf<String>()
            demodata.add("Дневная")
            demodata.add("Вечерняя")
            demodata.add("Заочная")

            val adapter = ArrayAdapter<String>(this, R.layout.list_items, demodata)

            list_day_evening.adapter = adapter
            list_day_evening.setOnItemClickListener { adapterView, view, i, l ->
                //Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
                val element = (view as TextView).text // получаем текст нажатого элемента
                val randomIntent = Intent(this, ActivityСourse::class.java)
                randomIntent.putExtra("faculty", faculty)
                when (element) {
                    "Дневная" ->
                        randomIntent.putExtra("dayevening", "/do") //передали форму обучения
                    "Вечерняя" ->
                        randomIntent.putExtra("dayevening", "/vo")
                    "Заочная" ->
                        randomIntent.putExtra("dayevening", "/zo")
                    else ->
                        randomIntent.putExtra("dayevening", "")
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