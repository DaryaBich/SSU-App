package com.example.mobilessu.menu_page

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.schedule_page.ScheduleActivity
import com.example.mobilessu.teacher_or_student_page.Activity_teacher_or_student
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader

class Activity_menu :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitymenu)
    }

    fun click_schedule(view: View){
        val randomIntent = Intent(this, Activity_teacher_or_student::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.news_in, R.anim.news_out);

    }
    fun click_personal_account(view: View) {
        var sumstr: String = ""
        try {
            // открываем поток для чтения
            val br = BufferedReader(
                InputStreamReader(
                    openFileInput("file")
                )
            )
            var str: String? = ""
            // читаем содержимое
            while (br.readLine().also({str = it}) != null) {
                //Log.d(LOG_TAG, str)
                sumstr += str
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val randomIntent = Intent(this, ScheduleActivity::class.java)
        randomIntent.putExtra("url", sumstr)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}