package com.example.mobilessu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilessu.mvp.MVPContract

class MainActivity_teacher_or_student : MVPContract.View, AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teacher_or_student)
    }
}