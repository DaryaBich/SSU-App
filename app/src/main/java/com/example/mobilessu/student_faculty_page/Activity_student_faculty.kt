package com.example.mobilessu.student_faculty_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.mobilessu.R
import kotlinx.android.synthetic.main.activity_student_faculty.*

class Activity_student_faculty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_faculty)
        val demodata = MutableList(5, {x -> "Item$x"})
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, demodata)
        listfaculty.adapter = adapter
        listfaculty.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
        }


    }
}