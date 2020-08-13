package com.example.mobilessu

// класс отвечающий за выгрузку расписания и выгрузку списка групп

class ScheduleDataModel {
    // Функция получения списка групп по фак-ту и форме обучения
    fun getGroupNumbers(department:String, educationForm:String) {
    }

    // Функция получения списка групп по фак-ту, форме обучения и курсу
    fun getGroupNumbers(department:String, educationForm:String, course:String){
    }

    // очное отделение

    // функция получения расписания сессии по фак-ту и номеру группы
    fun getFullTimeExamsPeriod(department: String, groupNumber:String){
    }

    // функция получения расписания на всю неделю по фак-ту и номеру группы
    fun getFullTimeLesson(department: String, groupNumber: String){

    }


}