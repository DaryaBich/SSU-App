package com.example.mobilessu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Activity_group : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}