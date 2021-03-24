package com.example.mobilessu.choose_course

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mobilessu.group_page.ActivityGroup
import com.example.mobilessu.R
import kotlinx.android.synthetic.main.activity_course.*

class ActivityСourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        val arguments = intent.extras
        if (arguments != null) {
            val faculty = arguments["faculty"].toString()
            val dayevening = arguments["dayevening"].toString()
            val demodata = mutableListOf<String>()

            demodata.add("1 курс")
            demodata.add("2 курс")
            demodata.add("3 курс")
            demodata.add("4 курс")
            demodata.add("5 курс")

            val adapter = ArrayAdapter<String>(this, R.layout.list_items, demodata)

            listcourse.adapter = adapter
            listcourse.setOnItemClickListener { adapterView, view, i, l ->
                //Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
                val element = (view as TextView).text // получаем текст нажатого элемента
                //val randomIntent = Intent(this, Activity_group::class.java)
                val randomIntent1 = Intent(this, ActivityGroup::class.java)
               // val randomIntent = Intent(this, Groups_model::class.java)
                randomIntent1.putExtra("faculty", faculty)
                randomIntent1.putExtra("dayevening", dayevening)
                when (element) {
                    "1 курс" ->
                        randomIntent1.putExtra("course", "1") //передали курс
                    "2 курс" ->
                        randomIntent1.putExtra("course", "2")
                    "3 курс" ->
                        randomIntent1.putExtra("course", "3")
                    "4 курс" ->
                        randomIntent1.putExtra("course", "4")
                    "5 курс" ->
                        randomIntent1.putExtra("course", "5")
                    else ->
                        randomIntent1.putExtra("course", "")
                }
                startActivity(randomIntent1)
                overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
            }
        }

    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}