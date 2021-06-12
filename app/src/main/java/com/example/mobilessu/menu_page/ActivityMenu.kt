package com.example.mobilessu.menu_page

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.schedule_page.ScheduleActivity
import com.example.mobilessu.teacher_or_student_page.ActivityTeacherOrStudent
import com.example.mobilessu.contacts_page.ActivityContacts
import com.example.mobilessu.choose_theme.ActivityChooseTheme
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader
import android.util.Log
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_menu.*

class ActivityMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun click_schedule(view: View){
        val randomIntent = Intent(this, ActivityTeacherOrStudent::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_theme(view: View){
        val randomIntent = Intent(this, ActivityChooseTheme::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.news_in, R.anim.news_out);
    }

    // нажатие на кнопку с контактами
    fun click_contacts(view: View) {
        val randomIntent = Intent(this, ActivityContacts::class.java)
        startActivity(randomIntent)
        Log.d("CONTACTS", "Intent started")
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out)
    }

    fun click_my_schedule(view: View) {
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
            while (br.readLine().also {str = it} != null) {
                //Log.d(LOG_TAG, str)
                sumstr += str
            }
            val randomIntent = Intent(this, ScheduleActivity::class.java)
            randomIntent.putExtra("url", sumstr)
            startActivity(randomIntent)
            overridePendingTransition(R.anim.fide_in, R.anim.fide_out)
        } catch (e: FileNotFoundException) {
            //e.printStackTrace()
            Toast.makeText(
                applicationContext,
                "Выберите свою группу по кнопке \"Расписание занятий\"",
                Toast.LENGTH_LONG
            ).show()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}