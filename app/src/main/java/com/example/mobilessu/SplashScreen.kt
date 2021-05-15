package com.example.mobilessu

import android.R.anim
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.mobilessu.news_page.ActivityNews
import kotlinx.android.synthetic.main.splash_screen.*


class SplashScreen: Activity() {
    private val SPLASH_DISPLAY_LENGHT = 5000
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        img.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_splash_in))
        handler = Handler()
        runnable = Runnable {
            val mainIntent = Intent(this, ActivityNews::class.java)
            startActivity(mainIntent)
            finish()
            //overridePendingTransition(R.anim.quick_in, R.anim.quick_out)
        }
        handler.postDelayed(
            runnable, 4000.toLong())
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}