package com.example.mobilessu.choose_course

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mobilessu.group_page.Activity_group
import com.example.mobilessu.R
import com.example.mobilessu.group_page.Groups_model
import kotlinx.android.synthetic.main.activityсourse.*

class Activity_course : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityСourse)
        val arguments = intent.extras
        if (arguments != null) {
            val faculty = arguments["faculty"].toString()
            val day_evening = arguments["day_evening"].toString()
            val demodata = mutableListOf<String>()

            demodata.add("1 курс")
            demodata.add("2 курс")
            demodata.add("3 курс")
            demodata.add("4 курс")
            demodata.add("5 курс")

            val adapter = ArrayAdapter<String>(this, R.layout.listitem, demodata)

            listcourse.adapter = adapter
            listcourse.setOnItemClickListener { adapterView, view, i, l ->
                //Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
                val element = (view as TextView).text // получаем текст нажатого элемента
                //val randomIntent = Intent(this, Activity_group::class.java)
                val randomIntent1 = Intent(this, Activity_group::class.java)
                val randomIntent = Intent(this, Groups_model::class.java)
                randomIntent.putExtra("faculty", faculty)
                randomIntent.putExtra("day_evening", day_evening)
                when (element) {
                    "1 курс" -> randomIntent.putExtra("course", "1") //передали курс
                    else -> randomIntent.putExtra("course", "")
                }
                startActivity(randomIntent1)
                overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
            }
        }

    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}