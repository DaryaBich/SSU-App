package com.example.mobilessu.entities

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.mobilessu.R
import com.example.mobilessu.SplashScreen
import com.example.mobilessu.news_page.ActivityNews
import com.example.mobilessu.news_page.MyArrayAdapter
import com.example.mobilessu.news_page.NewsInterface
import com.example.mobilessu.news_page.NewsPresenter

class NotificationsWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
   companion object {
        var NOTIFICATION_ID = 101
        const val CHANNEL_ID = "channelID"
    }

    fun createChannelIfNeeded(manager: NotificationManager){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel =
                NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(notificationChannel)
        }
    }


    override fun doWork(): Result {
        Log.d(TAG, "doWork: start");
        try {
            //Ваш код
           // var presenter: NewsInterface.Presenter = NewsPresenter(ActivityNews)

            //val randomIntent = Intent(applicationContext, ActivityNews::class.java)
            //val adapter = MyArrayAdapter(applicationContext, R.layout.news_list_items, list)
           // list_of_news.adapter = adapter
            val notificationManager =
                applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val rIntent = Intent(applicationContext, SplashScreen::class.java)
            rIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            rIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            val pendingIntent = PendingIntent
                .getActivity(applicationContext, 0, rIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            // Создаём уведомление
            val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Напоминание")
                .setContentText("Пора покормить кота")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                //.setContentIntent(pendingIntent)
                .addAction(
                    R.mipmap.ic_launcher, "Открыть новости",
                    pendingIntent)
            createChannelIfNeeded(notificationManager)
            notificationManager.notify(NOTIFICATION_ID++, builder.build())
            // Удаляем конкретное уведомление
            //notificationManager.cancel(NOTIFY_ID);
            // Удаляем все свои уведомления
            //notificationManager.cancelAll();
        } catch (ex: Exception) {
            return Result.failure();
        }
        Log.d(TAG, "doWork: end");
        return Result.success()
    }
}