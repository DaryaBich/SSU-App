package com.example.mobilessu.schedule_page

import com.example.mobilessu.entities.LessonData
import com.example.mobilessu.entities.ScheduleData
import com.example.mobilessu.group_page.Activity_group
import com.example.mobilessu.group_page.Group_interface
import com.example.mobilessu.group_page.Groups_model

class SchedulePresenter (var view: ScheduleActivity): ScheduleInterface.Presenter {
    var model: ScheduleInterface.Model = ScheduleModel()
    override fun getData(lessonData: LessonData):List<LessonData> {
        val list = model.getLessons(lessonData)
        view.showLessons(list)
        return list
    }
}