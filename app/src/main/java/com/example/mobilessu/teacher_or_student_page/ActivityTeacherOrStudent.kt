package com.example.mobilessu.teacher_or_student_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilessu.R
import com.example.mobilessu.student_faculty_page.ActivityStudentFaculty
import com.example.mobilessu.teacher_page.ActivityFindTeacher

class ActivityTeacherOrStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_or_student)
    }

    fun click_schedule_teacher(view: View){
        val randomIntent = Intent(this, ActivityFindTeacher::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_schedule_students(view: View){
        val randomIntent = Intent(this, ActivityStudentFaculty::class.java)
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