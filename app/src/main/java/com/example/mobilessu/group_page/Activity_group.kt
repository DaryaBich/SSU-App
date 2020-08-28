package com.example.mobilessu.group_page

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.entities.ScheduleData
import kotlinx.android.synthetic.main.activitygroup.*


class Activity_group : AppCompatActivity() {
    var presenter: Group_interface.Presenter = Groups_presenter(this)
    //val arguments = intent.extras

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitygroup)
        val arguments = intent.extras
        if (arguments != null) {
            val faculty = arguments["faculty"].toString()
            val dayevening = arguments["dayevening"].toString()
            val course = arguments["course"].toString()
            val scheduleData = ScheduleData(faculty, dayevening, course, "0")
            presenter.getData(scheduleData) // получение групп
        }
    }

    fun showGroups(list: List<ScheduleData>) {
        if (list.isNotEmpty()) {
            val adapter = MyArrayAdapterGroup(this, R.layout.groupslistitems, list)
            list_group.adapter = adapter
        } else {
            Toast.makeText(
                applicationContext,
                "Проверьте подключение к интернету",
                Toast.LENGTH_LONG
            ).show()
        }

    }

//            textView.setText(
//                """
//                    Name: $name
//                    Company: $company
//                    Price: $price
//                    """.trimIndent()
//            )

    fun click_back(view: View){
        finish()
        overridePendingTransition(
            R.anim.fide_in,
            R.anim.fide_out
        );
    }
}