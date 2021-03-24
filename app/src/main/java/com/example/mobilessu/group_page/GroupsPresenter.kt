package com.example.mobilessu.group_page

import com.example.mobilessu.entities.ScheduleData

class GroupsPresenter(var view: ActivityGroup): GroupInterface.Presenter {
    var model: GroupInterface.Model =
        GroupsModel()

    override fun getData(scheduleData:ScheduleData):List<String> {
        val list = model.getGroups(scheduleData)
        view.showGroups(list)
        return list
    }
}