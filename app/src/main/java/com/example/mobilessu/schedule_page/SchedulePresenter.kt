package com.example.mobilessu.schedule_page

import com.example.mobilessu.entities.LessonData

class SchedulePresenter (var view: ScheduleActivity): ScheduleInterface.Presenter {
    var model: ScheduleInterface.Model = ScheduleModel()
    override fun getData(lessonData: LessonData):List<LessonData> {
        var list = model.getLessons(lessonData)
        view.showLessons(list)
//        lessonData.setnum(2)
//        list = model.getLessons(lessonData)
//        view.showLessons(list)
//        lessonData.setnum(3)
//        list = model.getLessons(lessonData)
//        view.showLessons(list)
//        lessonData.setnum(4)
//        list = model.getLessons(lessonData)
//        view.showLessons(list)
//        lessonData.setnum(5)
//        list = model.getLessons(lessonData)
//        view.showLessons(list)
//        lessonData.setnum(6)
//        list = model.getLessons(lessonData)
//        view.showLessons(list)
        return list
    }
}