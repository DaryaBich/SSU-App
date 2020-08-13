package com.example.mobilessu.teacher_or_student_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilessu.R
import com.example.mobilessu.student_faculty_page.StudentFacultyActivity
import com.example.mobilessu.teacher_page.FindTeacherActivity

class TeacherOrStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher_or_student)
    }

    fun click_schedule_teacher(view: View){
        val randomIntent = Intent(this, FindTeacherActivity::class.java)
        startActivity(randomIntent)
    }

    fun click_schedule_students(view: View){
        val randomIntent = Intent(this, StudentFacultyActivity::class.java)
        startActivity(randomIntent)
    }

    fun click_back(view: View){
        //val randomIntent = Intent(this, TeacherOrStudentActivity::class.java)
        //startActivity(randomIntent)
        finish()
    }
}