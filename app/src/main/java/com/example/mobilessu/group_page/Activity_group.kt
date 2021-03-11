package com.example.mobilessu.group_page

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.entities.ScheduleData
import com.example.mobilessu.schedule_page.ScheduleActivity
import kotlinx.android.synthetic.main.activitygroup.*
import java.io.BufferedWriter
import java.io.FileNotFoundException
import java.io.IOException
import java.io.OutputStreamWriter


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
            val list = presenter.getData(scheduleData) // получение групп

            list_group.setOnItemClickListener { adapterView, view, i, l ->
                //Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
                //val element = (view as TextView).text.toString() // получаем текст нажатого элемента
                val randomIntent = Intent(this, ScheduleActivity::class.java)
                val group = list[i]
                val url = "https://www.sgu.ru/schedule$faculty$dayevening/$group"
                randomIntent.putExtra("url", url)
                try {
                    // отрываем поток для записи
                    val bw = BufferedWriter(
                        OutputStreamWriter(
                            openFileOutput("file", Context.MODE_PRIVATE)
                        )
                    )
                    // пишем данные
                    bw.write(url)
                    // закрываем поток
                    bw.close()
                    //Log.d(LOG_TAG, "Файл записан")
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                //randomIntent.putExtra("faculty", faculty)
                //randomIntent.putExtra("dayevening", dayevening)
               // randomIntent.putExtra("course", course)
                //val list = listOf(list_group[i])
                //randomIntent.putExtra("group", list[i])
//                when (element) {
//                    "Дневная" ->
//                        randomIntent.putExtra("dayevening", "/do") //передали форму обучения
//                    "Вечерняя" ->
//                        randomIntent.putExtra("dayevening", "/vo")
//                    "Заочная" ->
//                        randomIntent.putExtra("dayevening", "/zo")
//                    else ->
//                        randomIntent.putExtra("dayevening", "")
//                }

                //val randomIntent = Intent(this, Activity_course::class.java)
                startActivity(randomIntent)
                overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
            }
        }
    }

    fun showGroups(list: List<String>) {
        if (list.isNotEmpty()) {
          val adapter = MyArrayAdapterGroup(this, R.layout.groupslistitems, list)
          //  val adapter = MyArrayAdapterGroup(this, R.layout.listitem, list)
            list_group.adapter = adapter
        } else {
            Toast.makeText(
                applicationContext,
                "По вашему запросу ничего не найдено. Проверьте подключение к интернету или укажите другие параметры.",
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