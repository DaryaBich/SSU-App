package com.example.mobilessu.group_page;

import android.os.AsyncTask;
import android.util.Log;

import com.example.mobilessu.entities.ScheduleData;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Groups_model implements Group_interface.Model {
    private MyAsyncTask myAsyncTask;
    // Функция парсинга новостей с сайта www.sgu.ru

    //@NotNull
    @Override
    public List<String> getGroups(ScheduleData scheduleData) throws IOException, ExecutionException, InterruptedException {
        try {
            myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(scheduleData);
            return myAsyncTask.get();
        } catch (ExecutionException | InterruptedException e) {
            Log.d("ERROR", "Problem with multithreading");
            return new LinkedList<>();
        }
    }
    // первый параметр это тип входных параметров, третий - тип выходных параметров
    //private static class MyAsyncTask extends AsyncTask<ScheduleData, Void, LinkedList<ScheduleData>>
    private static class MyAsyncTask extends AsyncTask<ScheduleData, Void, LinkedList<String>> {

       // private ScheduleData scheduleData;
        @Override
        // Тогда здесь входным параметром будет ScheduleData
        //protected LinkedList<ScheduleData> doInBackground(ScheduleData... sheduleData)
        protected LinkedList<String> doInBackground(ScheduleData... scheduleData) {

            //LinkedList<ScheduleData> groupsLinkedList = new LinkedList<>();
            LinkedList<String> groupsLinkedList = new LinkedList<>();


            // тогда здесь ты просто берешь первый элемент списка,
            // если сюда приходит точно ровно один элемент:
            // scheduleData[0]
            //ScheduleData object = scheduleData[0];
            //if (scheduleData.length == 1) {
           // ScheduleData scheduleData1;
                String faculty = scheduleData[0].getDepartment();
                String day_evening = scheduleData[0].getEducationForm();
                String course = scheduleData[0].getCourse();
               // try {
                    // Bundle data = getIntent.getExtras();
                    // String faculty = scheduleData.getDepartment();
                    String url = "https://www.sgu.ru/schedule" + faculty; //+ day_evening;
            Document document = null;
            try {
                document = Jsoup.connect(url).timeout(100000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements listGroups;
                    if (day_evening.equals("/do"))
                        listGroups = document.select("fieldset[class*=do form_education form-wrapper]")
                                //.select("fieldset[Name=1 курс:]")
                                .select("a");
                    else if (day_evening.equals("/zo"))
                        listGroups = document.select("fieldset[class*=zo form_education form-wrapper]")
                                .select("a");
                    else //if (day_evening == "vo/")
                        listGroups = document.select("fieldset[class*=vo form_education form-wrapper]")
                                .select("a");
                    for (Element element : listGroups) {
                        String gr = element.select("a[href]").get(0).text();
                        //String date = element.select("span.date-display-single").get(0)
                       //         .attr("content");
                       // date = date.substring(8, 10) + "." + date.substring(5, 7) + "." + date.substring(0, 4);
                        //String title = element.select("a[href]").get(0).text();
                        //String url = "https://www.sgu.ru" + element.select("a[href]").get(0)
                              //  .attr("href");
                        if (gr.charAt(0) == course.charAt(0) & !faculty.equals("/kgl") & !faculty.equals("/cre"))
                            //groupsLinkedList.add(new ScheduleData(faculty, day_evening, course, gr));
                            groupsLinkedList.add(gr);
                        else if (gr.charAt(1) == course.charAt(0) & faculty.equals("/kgl"))
                            groupsLinkedList.add(gr);
                        else if (gr.charAt(gr.length() - 3) == course.charAt(0) & faculty.equals("/cre"))
                            groupsLinkedList.add(gr);
                    }
                    return groupsLinkedList;
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
        protected void onPostExecute(LinkedList<String> groups) {
            super.onPostExecute(groups);
        }
    }
}
