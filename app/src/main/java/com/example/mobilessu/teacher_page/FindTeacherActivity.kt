package com.example.mobilessu.teacher_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilessu.R

class FindTeacherActivity :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_find_teacher)


    }

    fun click_back(view: View) {
        finish()
    }
}