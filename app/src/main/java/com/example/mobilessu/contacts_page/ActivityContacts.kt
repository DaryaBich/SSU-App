package com.example.mobilessu.contacts_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mobilessu.R
import com.example.mobilessu.contacts_list_page.ActivityContactsList
import kotlinx.android.synthetic.main.activity_contacts.*

class ActivityContacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val demodata = mutableListOf<String>()
        demodata.add(getString(R.string.administration))
        demodata.add(getString(R.string.administrative_units))
        demodata.add(getString(R.string.educational_units))
        val adapter = ArrayAdapter<String>(this, R.layout.list_items, demodata)

        list_units.adapter = adapter
        list_units.setOnItemClickListener { adapterView, view, i, l ->
            //Toast.makeText(this, (view as TextView).text, Toast.LENGTH_LONG).show()
            val element = (view as TextView).text // получаем текст нажатого элемента
            val randomIntent = Intent(this, ActivityContactsList::class.java)

            when (element) {
                getString(R.string.administration)->
                    randomIntent.putExtra("unit", "administration") //передали форму обучения
                getString(R.string.administrative_units)->
                    randomIntent.putExtra("unit", "administrative_units")
                getString(R.string.educational_units) ->
                    randomIntent.putExtra("unit", "educational_units")
                else ->
                    randomIntent.putExtra("unit", "")
            }

            //val randomIntent = Intent(this, Activity_course::class.java)
            startActivity(randomIntent)
            overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
        }
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}