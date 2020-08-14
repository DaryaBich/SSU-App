package com.example.mobilessu.choose_course

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.mobilessu.Activity_group
import com.example.mobilessu.R
import com.example.mobilessu.choose_day_evening.Activity_day_evening
import kotlinx.android.synthetic.main.activity_course.*
import kotlinx.android.synthetic.main.activity_student_faculty.*

class Activity_course : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        val demodata = mutableListOf<String>()

        demodata.add("1 курс")
        demodata.add("2 курс")
        demodata.add("3 курс")
        demodata.add("4 курс")
        demodata.add("5 курс")

        val adapter = ArrayAdapter<String>(this, R.layout.list_item, demodata)

        listcourse.adapter = adapter
        listcourse.setOnItemClickListener { adapterView, view, i, l ->
            //Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
            click_course(view)
        }

    }

    fun click_course(view: View){
        val randomIntent = Intent(this, Activity_group::class.java)
        startActivity(randomIntent)
    }



    fun click_back(view: View){
        finish()
    }
}