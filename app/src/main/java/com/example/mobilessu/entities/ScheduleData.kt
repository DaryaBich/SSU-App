package com.example.mobilessu.entities

// класс хранит данные для поиска расписания

public class ScheduleData(
    private var department: String,
    private var educationForm: String,
    private var course: String,
    private var group: String
){

    fun getGroup(): String {
       return group
    }

    fun setGroup(group: String) {
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
