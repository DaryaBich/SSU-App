package com.example.mobilessu.schedule_page

import com.example.mobilessu.entities.LessonData

class SchedulePresenter (var view: ScheduleActivity): ScheduleInterface.Presenter {
    var model: ScheduleInterface.Model = ScheduleModel()
    override fun getData(lessonData: LessonData):List<LessonData> {
        val list = model.getLessons(lessonData)
        view.showLessons(list)
        return list
    }
}