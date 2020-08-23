package com.example.mobilessu.group_page

import com.example.mobilessu.news_page.News_interface
import com.example.mobilessu.news_page.News_model

class Groups_presenter(var view: Group_interface.View): Group_interface.Presenter {
    var model: Group_interface.Model =
        Group_model()

    override fun getData() {
        val list = model.getGroups()
        view.showGroups(list)
    }
}