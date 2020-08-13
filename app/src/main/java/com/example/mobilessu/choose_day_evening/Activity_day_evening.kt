package com.example.mobilessu.choose_day_evening

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilessu.R

class Activity_day_evening : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_evening)
    }

    fun click_back(view: View){
        finish()
    }
}