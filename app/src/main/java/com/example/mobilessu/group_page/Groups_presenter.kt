package com.example.mobilessu.group_page

import com.example.mobilessu.entities.ScheduleData

class Groups_presenter(var view: Activity_group): Group_interface.Presenter {
    var model: Group_interface.Model = Groups_model()

    override fun getData(scheduleData:ScheduleData) {
        val list = model.getGroups(scheduleData)
        view.showGroups(list)
    }
}