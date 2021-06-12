package com.example.mobilessu.contacts_list_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mobilessu.R
import com.example.mobilessu.contact_display.ActivityContactDisplay
import kotlinx.android.synthetic.main.activity_contacts_list.*
import kotlinx.android.synthetic.main.activity_contacts_list.txt1

class ActivityContactsList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_list)
        // достаем данные, переданные в intent
        val arguments = intent.extras
        // список, в котором будут храниться названия контактов
        val demodata = mutableListOf<String>()
        // Если на предыдущем экране пользователь выбрал "Администрация"
        if (arguments != null) {
            var contacts : Array<String> = arrayOf()
            var unit = ""
            when (arguments["unit"]) {
                "administration" -> {
                    contacts = resources.getStringArray(R.array.dir_contacts)
                    txt1.text = "Руководство"
                    unit = "administration"
                }
                "administrative_units" -> {
                    contacts = resources.getStringArray(R.array.adm_contacts)
                    txt1.text = "Административные подразделения"
                    unit = "administrative_units"
                }
                else -> {
                    contacts = resources.getStringArray(R.array.edu_contacts)
                    txt1.text = "Образовательные подразделения"
                    unit = "educational_units"
                }
            }

            for (contact : String in contacts) {
                demodata.add(contact)
            }

            val adapter = ArrayAdapter<String>(this, R.layout.list_items, demodata)

            list_units.adapter = adapter
            list_units.setOnItemClickListener { adapterView, view, i, l ->

                val element = (view as TextView).text // получаем текст нажатого элемента
                val randomIntent = Intent(this, ActivityContactDisplay::class.java)
                var index = 0
                for (contact : String in contacts) {
                    if (element == contact) {
                        randomIntent.putExtra("unit", unit)
                        randomIntent.putExtra("index", index)
                    }
                    index++
                }

                startActivity(randomIntent)
                overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
            }
        }
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}