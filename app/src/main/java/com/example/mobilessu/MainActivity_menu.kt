package com.example.mobilessu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilessu.mvp.MVPContract

class MainActivity_menu : MVPContract.View, AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }
}