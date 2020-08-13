package com.example.mobilessu.menu_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilessu.R
import com.example.mobilessu.teacher_or_student_page.TeacherOrStudentActivity

class MainActivity_menu :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    fun click_schedule(view: View){
        val randomIntent = Intent(this, TeacherOrStudentActivity::class.java)
        startActivity(randomIntent)
    }

    fun click_back(view: View){
        finish()
    }
}