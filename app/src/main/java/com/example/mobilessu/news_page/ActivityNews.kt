package com.example.mobilessu.news_page

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.mobilessu.R
import com.example.mobilessu.entities.News
import com.example.mobilessu.entities.NotificationsWorker
import com.example.mobilessu.menu_page.ActivityMenu
import kotlinx.android.synthetic.main.activity_news.*
import java.util.concurrent.TimeUnit


class ActivityNews : NewsInterface.View,AppCompatActivity(){
    var x1: Float = 0.0F
    var y1: Float = 0.0F
    var x2: Float = 0.0F
    var y2: Float = 0.0F

    var presenter: NewsInterface.Presenter =
        NewsPresenter(this)
    lateinit var list_news: List<News>
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
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
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) //обязательно соединение с интернетом
            .setRequiresDeviceIdle(true) //девайс не используется какое-то время и ушел в спячку
            .build()
        val myWorkRequest =
            PeriodicWorkRequest.Builder(NotificationsWorker::class.java, 15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()
        WorkManager.getInstance().enqueue(myWorkRequest)

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

        list_of_news.setOnItemClickListener { adapterView, view, i, l ->
            val address: Uri = Uri.parse(list_news[i].getUrl())
            val openLinkIntent = Intent(Intent.ACTION_VIEW, address)
            //if (openLinkIntent.resolveActivity(packageManager) != null) {
                startActivity(openLinkIntent)
           // }
        }


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
        if (list.isNotEmpty()) {
            list_news = list
            val adapter = MyArrayAdapter(this,
                R.layout.news_list_items, list)
            list_of_news.adapter = adapter
        } else {
            Toast.makeText(
                applicationContext,
                "Check your Internet Connection",
                Toast.LENGTH_LONG
            ).show()
        }
    }

//    companion object {
//        var NOTIFICATION_ID = 101
//        const val CHANNEL_ID = "channelID"
//    }
//
//    fun createChannelIfNeeded(manager: NotificationManager){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            val notificationChannel =
//                NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT)
//            manager.createNotificationChannel(notificationChannel)
//        }
//    }

    fun clickmenu(view: View) {
//        val notificationManager =
//            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        val rIntent = Intent(this, SplashScreen::class.java)
//        rIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//        rIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
//        val pendingIntent = PendingIntent
//            .getActivity(applicationContext, 0, rIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//        // Создаём уведомление
//        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
//            .setSmallIcon(R.mipmap.ic_launcher)
//            .setContentTitle("Напоминание")
//            .setContentText("Пора покормить кота")
//            .setAutoCancel(true)
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            //.setContentIntent(pendingIntent)
//            .addAction(R.mipmap.ic_launcher, "Открыть новости",
//                pendingIntent)
//        createChannelIfNeeded(notificationManager)
//        notificationManager.notify(NOTIFICATION_ID++, builder.build())
//        // Удаляем конкретное уведомление
//        //notificationManager.cancel(NOTIFY_ID);
//        // Удаляем все свои уведомления
//        //notificationManager.cancelAll();

        val randomIntent = Intent(this, ActivityMenu::class.java)
        startActivity(randomIntent)
        overridePendingTransition(R.anim.menu_in, R.anim.menu_out)
    }
}
