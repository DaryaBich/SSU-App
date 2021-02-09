package com.example.mobilessu.schedule_page;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobilessu.R;
import com.example.mobilessu.entities.LessonData;
import com.example.mobilessu.entities.ScheduleData;
import com.example.mobilessu.group_page.Group_interface;
import com.example.mobilessu.group_page.Groups_model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ScheduleModel implements ScheduleInterface.Model{
    private MyAsyncTask myAsyncTask;
    @Override
    public List<LessonData> getLessons(LessonData lessonData) throws IOException, ExecutionException, InterruptedException {
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
    private static class MyAsyncTask extends AsyncTask<LessonData, Void, LinkedList<LessonData>> {

        // private ScheduleData scheduleData;
        @Override
        // Тогда здесь входным параметром будет ScheduleData
        //protected LinkedList<ScheduleData> doInBackground(ScheduleData... sheduleData)
        protected LinkedList<LessonData> doInBackground(LessonData... lessonData) {

            //LinkedList<ScheduleData> groupsLinkedList = new LinkedList<>();
            LinkedList<LessonData> lessonsLinkedList = new LinkedList<>();

            String url = lessonData[0].geturl();
            Integer num = lessonData[0].getnum();
            Document document = null;
            try {
                document = Jsoup.connect(url).timeout(100000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements listLessons;
           // listLessons = document.select("td[id*=1_2]");
            String str = "td[id$=" + num + "]";
            listLessons = document.select(str);

            for (Element element : listLessons) {
//                for (int i = 1; i < 9; i++) {
//                    String les = element.select("div[class*=l-dn]").text();
//                }
                String les = element.select("div[class=l-dn]").text();
                String lec_pr = element.select("div[class=l-pr-t]").text();
                String ch_zn = element.select("div[class=l-pr-r]").text();
                String teacher = element.select("div[class=l-tn]").text();
                String place = element.select("div[class=l-p]").text();

                lessonsLinkedList.add(new LessonData(les, url, num, lec_pr, ch_zn, teacher, place));
            }
            return lessonsLinkedList;
        }

        @Override
        protected void onPostExecute(LinkedList<LessonData> lessons) {
            super.onPostExecute(lessons);
        }
    }
}
