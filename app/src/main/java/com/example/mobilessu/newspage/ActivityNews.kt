package com.example.mobilessu.newspage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilessu.R
import com.example.mobilessu.entities.News
import com.example.mobilessu.menu_page.Activity_menu
import kotlinx.android.synthetic.main.activitynews.*


class ActivityNews : NewsInterface.View,AppCompatActivity(){
    var x1: Float = 0.0F
    var y1: Float = 0.0F
    var x2: Float = 0.0F
    var y2: Float = 0.0F

    var presenter: NewsInterface.Presenter =
        NewsPresenter(this)
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitynews)
        presenter.getData()
        handler = Handler()
        swipe_refresh.setOnRefreshListener {
            // Initialize a new Runnable
            runnable = Runnable {
                // Hide swipe to refresh icon animation
                swipe_refresh.isRefreshing = false
            }
            // Execute the task after specified time
            handler.postDelayed(
                runnable, 3000.toLong()
            )
        }
        swipe_refresh.setColorSchemeResources(R.color.light_blue, R.color.middle_blue,R.color.deep_blue)
//        layout.setOnTouchListener { _, event ->
//                when (event.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        x1 = event.x
//                        y1 = event.y
//                    }
//                    MotionEvent.ACTION_UP -> {
//                        x2 = event.x
//                        y2 = event.y
//                        if (x1 < x2) {
//                            val randomIntent = Intent(this, Activity_menu::class.java)
//                            startActivity(randomIntent)
//                            overridePendingTransition(R.anim.menu_in, R.anim.menu_out)
//                        }
//                    }
//                    else -> return@setOnTouchListener false
//                }
//        }


//        layout.setOnTouchListener({
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                x = event.x.toInt()
//                y = event.y.toInt()
//                when (event.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        sDown = "Down: $x,$y"
//                        sMove = ""
//                        sUp = ""
//                    }
//                    MotionEvent.ACTION_MOVE -> sMove = "Move: $x,$y"
//                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
//                        sMove = ""
//                        sUp = "Up: $x,$y"
//                    }
//                }
//                // tv.setText(sDown + "\n" + sMove + "\n" + sUp)
//                Toast.makeText(
//                    applicationContext,
//                    sDown + "\n" + sMove + "\n" + sUp,
//                    Toast.LENGTH_LONG
//                ).show()
//                return true
//            }
//        })
    }

//    fun OnTouchEvent(event: MotionEvent) : Boolean{
//        when(event.action){
//            MotionEvent.ACTION_DOWN ->{
//                x1 = event.x
//                y1 = event.y
//            }
//            MotionEvent.ACTION_UP ->{
//                x2 = event.x
//                y2 = event.y
//                if (x1 < x2){
//                    val randomIntent = Intent(this, Activity_menu::class.java)
//                    startActivity(randomIntent)
//                    overridePendingTransition(R.anim.menu_in, R.anim.menu_out)
//                }
//            }
//        }
//        return false
//    }

    override fun showNews(list: List<News>) {
        if (list.size > 0) {
            val adapter = MyArrayAdapter(this,
                R.layout.newslistitems, list)
            list_of_news.adapter = adapter
        } else {
            Toast.makeText(
                applicationContext,
                "Check your Internet Connection",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    fun clickmenu(view: View) {
        val randomIntent = Intent(this, Activity_menu::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.menu_in, R.anim.menu_out)
    }
}
