package com.example.mobilessu.teacher_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mobilessu.R
import com.example.mobilessu.entities.Teacher
import kotlinx.android.synthetic.main.activityfindteacher.*

class ActivityFindTeacher :  AppCompatActivity() , TeacherInterface.View{
    var presenter: TeacherInterface.Presenter = TeacherPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityfindteacher)
        button_teacher.setOnClickListener {
            if(teacher_name.text.toString()!=""){
                presenter.searchInputTeachers(teacher_name.text.toString())
            }
            else{
                Toast.makeText(
                    applicationContext,
                    "Введите ФИО",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun click_back(view: View) {
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }

    override fun showTeachers(list: List<Teacher>) {
        if (list.size > 0) {
            val adapter = TeacherArrayAdapter(this,R.layout.newslistitems, list)
            teacher_list.adapter = adapter
        } else {
            Toast.makeText(
                applicationContext,
                "По запросу ничего не найдено",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}