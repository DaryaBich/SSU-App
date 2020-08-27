package com.example.mobilessu.teacher_page

import com.example.mobilessu.entities.Teacher

interface TeacherInterface{
    interface Presenter{
        fun searchInputTeachers(inputName:String)
    }
    interface Model{
        fun getTeachers(inputName:String):List<Teacher>
    }
    interface View{
        fun showTeachers(list:List<Teacher>)
    }
}