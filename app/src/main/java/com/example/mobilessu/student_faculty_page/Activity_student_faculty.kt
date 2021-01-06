package com.example.mobilessu.student_faculty_page

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.choose_course.Activity_course
import com.example.mobilessu.choose_day_evening.Activity_day_evening
import kotlinx.android.synthetic.main.activitystudentfaculty.*


class Activity_student_faculty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//<<<<<<< HEAD:app/src/main/java/com/example/mobilessu/student_faculty_page/StudentFacultyActivity.kt
//        setContentView(R.layout.activitystudentfaculty)


       // val demodata = MutableList(25, {x -> "Item$x"})
       // val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, demodata)
            //listfaculty.adapter = adapter
        //listfaculty.setOnItemClickListener { adapterView, view, i, l ->
       //     Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
       // }
//=======

        setContentView(R.layout.activitystudentfaculty)
            // val demodata = MutableList(2, {"Биологический факультет"; "Географический факультет"})
        val demodata = mutableListOf<String>()
        val demodata1 = mutableListOf<String>()

        demodata.add("Биологический факультет")
        demodata.add("Географический факультет")
        demodata.add("Геологический факультет")
        demodata.add("Институт дополнительного профессионального образования")
        demodata.add("Институт искусств")
        demodata.add("Институт истории и международных отношений")
        demodata.add("Институт физической культуры и спорта")
        demodata.add("Институт филологии и журналистики")
        demodata.add("Институт химии")
        demodata.add("Механико-математический факультет")
        demodata.add("Социологический факультет")
        demodata.add("Факультет иностранных языков и лингводидактики")
        demodata.add("Факультет компьютерных наук и информационных технологий")
        demodata.add("Факультет нано- и биомедицинских технологий")
        demodata.add("Факультет нелинейных процессов")
        demodata.add("Факультет психологии")
        demodata.add("Факультет психолого-педагогического и специального образования")
        demodata.add("Физический факультет")
        demodata.add("Философский факультет")
        demodata.add("Экономический факультет")
        demodata.add("Юридический факультет")

        demodata1.add("Геологический колледж")
        demodata1.add("Колледж радиоэлектроники им. П.Н. Яблочкова")

        val adapter = ArrayAdapter<String>(this, R.layout.listitem, demodata)
        val adapter1 = ArrayAdapter<String>(this, R.layout.listitem, demodata1)
        listfaculty.adapter = adapter
        listcolledge.adapter = adapter1

        //listfaculty.layoutParams.
//        val params = listfaculty.getLayoutParams()
//        params.height = params.height * demodata.size
//        listfaculty.setLayoutParams(params);
        listfaculty.setOnItemClickListener { adapterView, view, i, l ->
            //Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
            val element = (view as TextView).text // получаем текст нажатого элемента
           // val document = Jsoup.connect("https://www.sgu.ru/schedule").get()
           // val list_faculty = document.select("div[class*=panes_item panes_item__type_group]")



            //click_faculty(view)
            val randomIntent = Intent(this, Activity_day_evening::class.java)
            when(element){
                "Биологический факультет" ->
                    randomIntent.putExtra("faculty", "/bf") //передали факультет
                "Географический факультет" ->
                    randomIntent.putExtra("faculty", "/gf")
                "Геологический факультет" ->
                    randomIntent.putExtra("faculty", "/gl") //передали факультет
                "Институт дополнительного профессионального образования" ->
                    randomIntent.putExtra("faculty", "/idpo")
                "Институт искусств" ->
                    randomIntent.putExtra("faculty", "/ii") //передали факультет
                "Институт истории и международных отношений" ->
                    randomIntent.putExtra("faculty", "/imo")
                "Институт физической культуры и спорта" ->
                    randomIntent.putExtra("faculty", "/ifk") //передали факультет
                "Институт филологии и журналистики" ->
                    randomIntent.putExtra("faculty", "/ifg")
                "Институт химии" ->
                    randomIntent.putExtra("faculty", "/ih") //передали факультет
                "Механико-математический факультет" ->
                    randomIntent.putExtra("faculty", "/mm")
                "Социологический факультет" ->
                    randomIntent.putExtra("faculty", "/sf") //передали факультет
                "Факультет иностранных языков и лингводидактики" ->
                    randomIntent.putExtra("faculty", "/fi")
                "Факультет компьютерных наук и информационных технологий" ->
                    randomIntent.putExtra("faculty", "/knt") //передали факультет
                "Факультет нано- и биомедицинских технологий" ->
                    randomIntent.putExtra("faculty", "/fn")
                "Факультет нелинейных процессов" ->
                    randomIntent.putExtra("faculty", "/fnp") //передали факультет
                "Факультет психологии" ->
                    randomIntent.putExtra("faculty", "/fps")
                "Факультет психолого-педагогического и специального образования" ->
                    randomIntent.putExtra("faculty", "/fppso") //передали факультет
                "Физический факультет" ->
                    randomIntent.putExtra("faculty", "/ff")
                "Философский факультет" ->
                    randomIntent.putExtra("faculty", "/fp") //передали факультет
                "Экономический факультет" ->
                    randomIntent.putExtra("faculty", "/ef")
                "Юридический факультет" ->
                    randomIntent.putExtra("faculty", "/uf")
                else ->
                    randomIntent.putExtra("faculty", "")
            }
            //val randomIntent = Intent(this, Activity_day_evening::class.java)
            startActivity(randomIntent)
            overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
        }
        listcolledge.setOnItemClickListener { adapterView, view, i, l ->

            val element = (view as TextView).text // получаем текст нажатого элемента
            // val document = Jsoup.connect("https://www.sgu.ru/schedule").get()
            // val list_faculty = document.select("div[class*=panes_item panes_item__type_group]")
            //click_faculty(view)
            val randomIntent = Intent(this, Activity_course::class.java)
            when(element){
                "Геологический колледж" ->
                    randomIntent.putExtra("faculty", "/kgl") //передали факультет
                "Колледж радиоэлектроники им. П.Н. Яблочкова" ->
                    randomIntent.putExtra("faculty", "/cre")
                else ->
                    randomIntent.putExtra("faculty", "")
            }
            randomIntent.putExtra("dayevening", "/do")
            //val randomIntent = Intent(this, Activity_day_evening::class.java)
            startActivity(randomIntent)
            overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
        }
//>>>>>>> 92e20a2b554b26c93864bc01ba7368930bb4aa4c:app/src/main/java/com/example/mobilessu/student_faculty_page/Activity_student_faculty.kt
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}