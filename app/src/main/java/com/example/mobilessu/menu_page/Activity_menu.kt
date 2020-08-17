package com.example.mobilessu.menu_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilessu.R
import com.example.mobilessu.teacher_or_student_page.Activity_teacher_or_student

class Activity_menu :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun click_schedule(view: View){
        val randomIntent = Intent(this, Activity_teacher_or_student::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);

    }
}