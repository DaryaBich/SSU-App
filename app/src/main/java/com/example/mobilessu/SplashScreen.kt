package com.example.mobilessu

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.mobilessu.news_page.ActivityNews


class SplashScreen: Activity() {
    private val SPLASH_DISPLAY_LENGHT = 5000
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        handler = Handler()
        runnable = Runnable {
            val mainIntent = Intent(this, ActivityNews::class.java)
            startActivity(mainIntent)
            finish()
        }
        handler.postDelayed(
            runnable, 3000.toLong())
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}