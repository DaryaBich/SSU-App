package com.example.mobilessu.session_page

import com.example.mobilessu.entities.LessonData
import com.example.mobilessu.entities.SessionData
import com.example.mobilessu.schedule_page.ScheduleActivity
import com.example.mobilessu.schedule_page.ScheduleInterface
import com.example.mobilessu.schedule_page.ScheduleModel

class SessionPresenter (var view: SessionActivity): SessionInterface.Presenter {
    var model: SessionInterface.Model = SessionModel()
    override fun getData(sessionData: SessionData):List<SessionData> {
        val list = model.getSessions(sessionData)
        view.showSessions(list)
        return list
    }
}