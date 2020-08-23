package com.example.mobilessu.group_page

import com.example.mobilessu.entities.News
import com.example.mobilessu.entities.ScheduleData
import java.io.IOException
import java.util.concurrent.ExecutionException

interface Group_interface {
    interface Model {
        @Throws(IOException::class, ExecutionException::class, InterruptedException::class)
        fun getGroups() :List<ScheduleData>
    }

    interface View {
        fun showGroups(list:List<ScheduleData>)
    }

    interface Presenter {
        fun getData()
    }
}