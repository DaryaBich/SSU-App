package com.example.mobilessu.choose_day_evening

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.mobilessu.Activity_group
import com.example.mobilessu.R
import com.example.mobilessu.choose_course.Activity_course
import kotlinx.android.synthetic.main.activity_course.*
import kotlinx.android.synthetic.main.activity_day_evening.*

class Activity_day_evening : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_evening)
        val demodata = mutableListOf<String>()

        demodata.add("Дневная")
        demodata.add("Вечерняя")
        demodata.add("Заочная")

        val adapter = ArrayAdapter<String>(this, R.layout.list_item, demodata)

        list_day_evening.adapter = adapter
        list_day_evening.setOnItemClickListener { adapterView, view, i, l ->
            //Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
            click_day_evening(view)
        }
    }

    fun click_day_evening(view: View){
        val randomIntent = Intent(this, Activity_course::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}