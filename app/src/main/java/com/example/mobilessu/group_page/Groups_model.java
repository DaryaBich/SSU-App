package com.example.mobilessu.group_page;

import android.app.DirectAction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.mobilessu.entities.News;
import com.example.mobilessu.entities.ScheduleData;
import com.example.mobilessu.news_page.News_interface;
import com.example.mobilessu.news_page.News_model;

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

    @NotNull
    @Override
    public List<ScheduleData> getGroups(@NotNull ScheduleData scheduleData) throws IOException, ExecutionException, InterruptedException {
        try {
            myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute();
            return myAsyncTask.get();
        } catch (ExecutionException | InterruptedException e) {
            Log.d("ERROR", "Problem with multithreading");
            return new LinkedList<>();
        }
    }
    // первый параметр это тип входных параметров, третий - тип выходных параметров
    //private static class MyAsyncTask extends AsyncTask<ScheduleData, Void, LinkedList<ScheduleData>>
    private static class MyAsyncTask extends AsyncTask<Void, Void, LinkedList<ScheduleData>> {

       // private ScheduleData scheduleData;
        @Override
        // Тогда здесь входным параметром будет ScheduleData
        //protected LinkedList<ScheduleData> doInBackground(ScheduleData... sheduleData)
        protected LinkedList<ScheduleData> doInBackground(Void... voids) {
            LinkedList<ScheduleData> groupsLinkedList = new LinkedList<>();
            // тогда здесь ты просто берешь первый элемент списка,
            // если сюда приходит точно ровно один элемент:
            // scheduleData[0]
            try {
               // Bundle data = getIntent.getExtras();
               // String faculty = scheduleData.getDepartment();
                Document document = Jsoup.connect("https://www.sgu.ru/news").get();
                Elements listGroups = document.select("div.region.region-local-navigation")
                        .select("div[class*=smart-links]");
                for (Element element : listGroups) {
                    String date = element.select("span.date-display-single").get(0)
                            .attr("content");
                    date = date.substring(8, 10)+"." + date.substring(5,7) +"."+ date.substring(0, 4);
                    String title = element.select("a[href]").get(0).text();
                    String url = "https://www.sgu.ru" + element.select("a[href]").get(0)
                            .attr("href");
                    //groupsLinkedList.add(new ScheduleData(date, title, url,411));
                }
                return groupsLinkedList;
            } catch (IOException e) {
                return groupsLinkedList;
            }
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
        protected void onPostExecute(LinkedList<ScheduleData> groups) {
            super.onPostExecute(groups);
        }
    }
}
