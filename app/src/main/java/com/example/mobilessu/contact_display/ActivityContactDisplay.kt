package com.example.mobilessu.contact_display

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mobilessu.R
import kotlinx.android.synthetic.main.activity_contacts_display.list_units
import android.util.Log

//import kotlinx.android.synthetic.main.contacts_list.*

class ActivityContactDisplay : AppCompatActivity() {
    fun getData(index : kotlin.Int, unit : String) : MutableMap<String, String>{
        val result : MutableMap<String, String> = mutableMapOf()

        var contacts : Array<String> = arrayOf()
        var emails : Array<String> = arrayOf()
        var names : Array<String> = arrayOf()
        var geos : Array<String> = arrayOf()
        var faxes : Array<String> = arrayOf()
        var addresses : Array<String> = arrayOf()

        when (unit) {
            "administration" -> {
                contacts = resources.getStringArray(R.array.dir_contacts)
                emails = resources.getStringArray(R.array.dir_emails)
                names = resources.getStringArray(R.array.dir_names)
                geos = resources.getStringArray(R.array.dir_geos)
                faxes = resources.getStringArray(R.array.dir_faxes)
                addresses = resources.getStringArray(R.array.dir_addresses)
            }
            "administrative_units" -> {
                contacts = resources.getStringArray(R.array.adm_contacts)
                emails = resources.getStringArray(R.array.adm_emails)
                names = resources.getStringArray(R.array.adm_names)
                geos = resources.getStringArray(R.array.adm_geos)
                faxes = resources.getStringArray(R.array.adm_faxes)
                addresses = resources.getStringArray(R.array.adm_addresses)
            }
            "educational_units" -> {
                contacts = resources.getStringArray(R.array.edu_contacts)
                emails = resources.getStringArray(R.array.edu_emails)
                names = resources.getStringArray(R.array.edu_names)
                geos = resources.getStringArray(R.array.edu_geos)
                faxes = resources.getStringArray(R.array.edu_faxes)
                addresses = resources.getStringArray(R.array.edu_addresses)
            }
        }

        result["contact"] = contacts[index]
        result["email"] = emails[index]
        result["address"] = addresses[index]
        result["name"] = names[index]
        result["fax"] = faxes[index]
        result["geo"] = geos[index]

        Log.i("CHECKER", "Data accessed")

        return result
    }

    fun getNumbers(index : kotlin.Int, unit : String) : List<String> {
        var numbers : Array<String> = arrayOf()

        when (unit) {
            "administration" -> {
                numbers = resources.getStringArray(R.array.dir_numbers)
            }
            "administrative_units" -> {
                numbers = resources.getStringArray(R.array.adm_numbers)
            }
            "educational_units" -> {
                numbers = resources.getStringArray(R.array.edu_numbers)
            }
        }

        val result = numbers[index]
        val resultSplitted = result.split(':')

        return resultSplitted
    }

    fun getMapMarker(label: String, geo: String): Uri {
        val uriBegin = "geo:$geo"
        val query = "$geo($label)"
        val encodedQuery = Uri.encode(query)
        val uriString = "$uriBegin?q=$encodedQuery"
        val location = Uri.parse(uriString);

        return location
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_display)

        // достаем данные, переданные в intent
        val args = intent.extras
        // список, в котором будут храниться данные контакта
        val demodata = mutableListOf<String>()

        var data : MutableMap<String, String> = mutableMapOf()
        var numbers : List<String> = listOf()

        if (args != null && args["index"] != null && args["unit"] != null) {
            val index : kotlin.Int = args["index"] as Int
            val unit : String = args["unit"] as String

            data = getData(index, unit)
            numbers = getNumbers(index, unit)

            demodata.add(data["contact"] as String)
            demodata.add(data["name"] as String)
            demodata.add("Адрес: " + data["address"] as String)
            if (data["email"] != "не указан")
                demodata.add("Электронная почта: " + data["email"] as String)
            if (data["fax"] != "не указан")
            demodata.add("Факс: " + data["fax"] as String)

            Log.i("CHECKER", "All data except numbers is added")

            var idx = 1
            for (number in numbers) {
                demodata.add("Телефон №$idx: $number")
                idx++
            }
        }

        Log.i("CHECKER", "List is generated")
        val adapter = ArrayAdapter<String>(this, R.layout.list_contacts, demodata)
        list_units.adapter = adapter

        list_units.setOnItemClickListener {adapterView, view, i, l ->
            val element = (view as TextView).text
            val randomIntent = Intent(this, ActivityContactDisplay::class.java)

            var idx = 1
            when(element) {
                "Адрес: " + data["address"] -> {
                    val uri = getMapMarker(data["address"] as String, data["geo"] as String)
                    val mapIntent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(mapIntent)
                    overridePendingTransition(R.anim.fide_in, R.anim.fide_out)
                }
                else -> for (number in numbers) {
                    if (element == "Телефон №$idx: $number") {
                        val num = Uri.parse("tel:" + number)
                        val callIntent = Intent(Intent.ACTION_DIAL, num)
                        startActivity(callIntent)
                        overridePendingTransition(R.anim.fide_in, R.anim.fide_out)
                    }
                    idx++
                }
            }
        }
    }

    fun click_back(view: View){
        finish()
        overridePendingTransition(R.anim.fide_in, R.anim.fide_out);
    }
}