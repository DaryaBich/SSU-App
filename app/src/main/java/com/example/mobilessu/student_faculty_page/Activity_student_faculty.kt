package com.example.mobilessu.student_faculty_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.mobilessu.R
import kotlinx.android.synthetic.main.activity_student_faculty.*

class Activity_student_faculty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//<<<<<<< HEAD:app/src/main/java/com/example/mobilessu/student_faculty_page/StudentFacultyActivity.kt
//        setContentView(R.layout.activity_student_faculty)


       // val demodata = MutableList(25, {x -> "Item$x"})
       // val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, demodata)
            //listfaculty.adapter = adapter
        //listfaculty.setOnItemClickListener { adapterView, view, i, l ->
       //     Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
       // }
//=======

        setContentView(R.layout.activity_student_faculty)
        val demodata = MutableList(5, {x -> "Item$x"})
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, demodata)
        listfaculty.adapter = adapter
        listfaculty.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
        }
//>>>>>>> 92e20a2b554b26c93864bc01ba7368930bb4aa4c:app/src/main/java/com/example/mobilessu/student_faculty_page/Activity_student_faculty.kt

    }

    fun click_back(view: View){
        finish()
    }
}