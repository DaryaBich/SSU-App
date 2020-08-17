package com.example.mobilessu.teacher_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilessu.R

class Activity_find_teacher :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_teacher)


    }

    fun click_back(view: View) {
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}