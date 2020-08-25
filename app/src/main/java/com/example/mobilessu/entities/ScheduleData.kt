package com.example.mobilessu.entities

// класс хранит данные для поиска расписания

public class ScheduleData(
    private var department: String,
    private var educationForm: String,
    private var course: String,
    private var group: Int
){

    fun getGroup(): String {
       return group.toString()
    }

    fun setGroup(group: Int) {
        this.group = group
    }

    fun getDepartment(): String {
       return department
    }

    fun getEducationForm(): String {
        return educationForm
    }

    fun getCourse():String {
        return course
    }

    fun setDepartment(department: String) {
        this.department = department
    }

    fun setEducationForm(educationForm: String) {
        this.educationForm = educationForm
    }

    fun setCourse(course: String) {
        this.course = course
    }
}
