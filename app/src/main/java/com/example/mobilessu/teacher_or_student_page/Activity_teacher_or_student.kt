package com.example.mobilessu.teacher_or_student_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilessu.R
import com.example.mobilessu.student_faculty_page.Activity_student_faculty
import com.example.mobilessu.teacher_page.Activity_find_teacher

class Activity_teacher_or_student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityteacherorstudent)
    }

    fun click_schedule_teacher(view: View){
        val randomIntent = Intent(this, Activity_find_teacher::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_schedule_students(view: View){
        val randomIntent = Intent(this, Activity_student_faculty::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_back(view: View){
        //val randomIntent = Intent(this, TeacherOrStudentActivity::class.java)
        //startActivity(randomIntent)
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}