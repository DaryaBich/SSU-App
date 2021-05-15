package com.example.mobilessu.session_page

import com.example.mobilessu.entities.LessonData
import com.example.mobilessu.entities.SessionData
import java.io.IOException
import java.util.concurrent.ExecutionException

interface SessionInterface {
    interface Model {
        @Throws(IOException::class, ExecutionException::class, InterruptedException::class)
        fun getSessions(sessionData: SessionData):List<SessionData>
    }
    interface View {
        fun showGroups(list:List<SessionData>)
    }
    interface Presenter {
        fun getData(sessionData: SessionData):List<SessionData>
    }
}