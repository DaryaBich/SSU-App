package com.example.mobilessu.newspage
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mobilessu.R
import com.example.mobilessu.entities.News
import com.example.mobilessu.menu_page.Activity_menu
import kotlinx.android.synthetic.main.activitynews.*
import kotlinx.android.synthetic.main.activitynews.view.*

class ActivityNews : NewsInterface.View,AppCompatActivity(){
    var presenter: NewsInterface.Presenter =
        NewsPresenter(this)
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
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
    }

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
