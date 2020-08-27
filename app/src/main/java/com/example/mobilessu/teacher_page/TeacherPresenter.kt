package com.example.mobilessu.teacher_page


class TeacherPresenter(var view: TeacherInterface.View):TeacherInterface.Presenter{
    var model :TeacherInterface.Model =
        TeacherModel()
    override fun searchInputTeachers(inputName:String){
        val list = model.getTeachers(inputName)
        view.showTeachers(list)
    }
}