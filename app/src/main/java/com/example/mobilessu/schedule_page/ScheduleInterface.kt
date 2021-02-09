package com.example.mobilessu.schedule_page

import com.example.mobilessu.entities.LessonData
import java.io.IOException
import java.util.concurrent.ExecutionException

interface ScheduleInterface {
    interface Model {
        @Throws(IOException::class, ExecutionException::class, InterruptedException::class)
        fun getLessons(lessonData: LessonData):List<String>
    }

    interface View {
        fun showGroups(list:List<String>)
    }

    interface Presenter {
        fun getData(lessonData: LessonData):List<String>
    }
}