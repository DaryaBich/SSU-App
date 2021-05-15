package com.example.mobilessu.session_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mobilessu.R
import com.example.mobilessu.entities.SessionData
import com.example.mobilessu.schedule_page.ScheduleActivity
import kotlinx.android.synthetic.main.activity_schedule.*

class SessionActivity : AppCompatActivity() {
    var presenter: SessionInterface.Presenter = SessionPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)
        val arguments = intent.extras
        if (arguments != null) {
            val url = arguments["url"].toString()
            var sessionData = SessionData("", url, "", "", "", "")
            var list = presenter.getData(sessionData) // получение аттестаций

        }
    }

    fun showSessions(list: List<SessionData>) {
        if (list.isNotEmpty()) {
            val adapter = MyArrayAdapterSession(this, R.layout.groups_list_items, list)
            list_sessions.adapter = adapter
        } else {
            Toast.makeText(
                applicationContext,
                "По вашему запросу ничего не найдено. Проверьте подключение к интернету или укажите другие параметры.",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    fun click_sessions(view: View) {
    }

    fun click_lessons(view: View) {
        val randomIntent = Intent(this, ScheduleActivity::class.java)
        val arguments = intent.extras
        val url = arguments?.get("url").toString()
        randomIntent.putExtra("url", url)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.quick_in, R.anim.quick_out)
    }
}