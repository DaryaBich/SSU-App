package com.example.mobilessu.entities

// класс хранит данные для поиска расписания

public class ScheduleData(private var department: String) {
    private var educationForm: String = ""
    private var course: String = ""
    fun getDepartment() {
        department
    }

    fun getEducationForm() {
        educationForm
    }

    fun getCourse() {
        course
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