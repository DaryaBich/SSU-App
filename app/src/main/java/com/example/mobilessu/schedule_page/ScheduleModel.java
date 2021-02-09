package com.example.mobilessu.schedule_page;

import android.os.AsyncTask;
import android.util.Log;

import com.example.mobilessu.entities.LessonData;
import com.example.mobilessu.entities.ScheduleData;
import com.example.mobilessu.group_page.Group_interface;
import com.example.mobilessu.group_page.Groups_model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ScheduleModel implements ScheduleInterface.Model{
    private MyAsyncTask myAsyncTask;
    @Override
    public List<String> getLessons(LessonData lessonData) throws IOException, ExecutionException, InterruptedException {
        try {
            myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(lessonData);
            return myAsyncTask.get();
        } catch (ExecutionException | InterruptedException e) {
            Log.d("ERROR", "Problem with multithreading");
            return new LinkedList<>();
        }
    }
    // первый параметр это тип входных параметров, третий - тип выходных параметров
    //private static class MyAsyncTask extends AsyncTask<ScheduleData, Void, LinkedList<ScheduleData>>
    private static class MyAsyncTask extends AsyncTask<LessonData, Void, LinkedList<String>> {

        // private ScheduleData scheduleData;
        @Override
        // Тогда здесь входным параметром будет ScheduleData
        //protected LinkedList<ScheduleData> doInBackground(ScheduleData... sheduleData)
        protected LinkedList<String> doInBackground(LessonData... lessonData) {

            //LinkedList<ScheduleData> groupsLinkedList = new LinkedList<>();
            LinkedList<String> lessonsLinkedList = new LinkedList<>();


            // тогда здесь ты просто берешь первый элемент списка,
            // если сюда приходит точно ровно один элемент:
            // scheduleData[0]
            //ScheduleData object = scheduleData[0];
            //if (scheduleData.length == 1) {
            // ScheduleData scheduleData1;
            String url = lessonData[0].geturl();
           // String faculty = scheduleData[0].getDepartment();
            //String day_evening = scheduleData[0].getEducationForm();
           // String course = scheduleData[0].getCourse();
            // try {
            // Bundle data = getIntent.getExtras();
            // String faculty = scheduleData.getDepartment();
            //String url = "https://www.sgu.ru/schedule" + faculty; //+ day_evening;
            Document document = null;
            try {
                document = Jsoup.connect(url).timeout(100000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements listLessons;
           // listLessons = document.select("td[id*=1_2]");
            listLessons = document.select("td[id$=2]");
            //Integer i = 2;
            //(document.select("td[id*=1_2]"));




//            if (day_evening.equals("/do"))

//                listGroups = document.select("fieldset[class*=do form_education form-wrapper]")
//                        //.select("fieldset[Name=1 курс:]")
//                        .select("a");
//            else if (day_evening.equals("/zo"))
//                listGroups = document.select("fieldset[class*=zo form_education form-wrapper]")
//                        .select("a");
//            else //if (day_evening == "vo/")
//                listGroups = document.select("fieldset[class*=vo form_education form-wrapper]")
//                        .select("a");


            for (Element element : listLessons) {
//                for (int i = 1; i < 9; i++) {
//                    String les = element.select("div[class*=l-dn]").text();
//                }
                String les = element.select("div[class*=l-dn]").text();
                //String date = element.select("span.date-display-single").get(0)
                //         .attr("content");
                // date = date.substring(8, 10) + "." + date.substring(5, 7) + "." + date.substring(0, 4);
                //String title = element.select("a[href]").get(0).text();
                //String url = "https://www.sgu.ru" + element.select("a[href]").get(0)
                //  .attr("href");
                //if (gr.charAt(0) == course.charAt(0))
                    //groupsLinkedList.add(new ScheduleData(faculty, day_evening, course, gr));
                lessonsLinkedList.add(les);
            }
            return lessonsLinkedList;
            // } catch (IOException e) {
            //     return groupsLinkedList;
            //  }
            // }
            // return groupsLinkedList;
        }

//        val arguments = intent.extras
//        if (arguments != null) {
//            val url = arguments["url"].toString()
//            val faculty = arguments["faculty"].toString()
//            val day_evening = arguments["day_evening"].toString()
//            val course = arguments["course"].toString()
//            val sum = url + faculty + day_evening
//            try {
//                val document = Jsoup.connect(sum).get()
//            }
//            catch () {
//                //return newsLinkedList;
//            }

        @Override
        protected void onPostExecute(LinkedList<String> lessons) {
            super.onPostExecute(lessons);
        }
    }
}
