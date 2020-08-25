package com.example.mobilessu.teacher_page


class Teacher_presenter(var view: Teacher_interface.View):Teacher_interface.Presenter{
    var model :Teacher_interface.Model = Teacher_model()
    override fun searchInputTeachers(inputName:String){
        val list = model.getTeachers(inputName)
        view.showTeachers(list)
    }
}