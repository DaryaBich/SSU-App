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
            String alf_en = "ABVGDEZIIKLMNOPRSTUFHCEUabvgdeziiklmnoprstufhceu";
            String alf_ru = "АБВГДЕЗИЙКЛМНОПРСТУФХЦЭЮабвгдезийклмнопрстуфхцэю";
            String url = lessonData[0].geturl();
            Integer num = lessonData[0].getnum();
            String gr = lessonData[0].getgr();
            String gr_en = "";
            for (int i = 0; i < gr.length(); i++){ //меняем русские буквы на английские
                if (alf_ru.indexOf(gr.charAt(i)) != -1)
                    gr_en += alf_en.charAt(alf_ru.indexOf(gr.charAt(i)));
                else
                    gr_en += gr.charAt(i);
            }
            url = url.substring(0, url.lastIndexOf('/') + 1) + gr_en;
            Document document = null;
            try {
                document = Jsoup.connect(url).timeout(100000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements listLessons;
           // listLessons = document.select("td[id*=1_2]");
            String str = "td[id$=" + num + "]";
            listLessons = document.select("tr").select(str);
            //String str = "td[id$=" + num + "]";
           // listLessons = document.select(str);
            Elements listtime = document.select("tr");
            Integer i = 1;
            for (Element element : listLessons) {
//                for (int i = 1; i < 9; i++) {
//                    String les = element.select("div[class*=l-dn]").text();
//                }
                String les = element.select("div[class=l-dn]").text();
                String lec_pr = element.select("div[class=l-pr-t]").text();
                String ch_zn = element.select("div[class=l-pr-r]").text();
                String g = element.select("div[class=l-pr-g]").text();
                String teacher = element.select("div[class=l-tn]").text();
                String place = element.select("div[class=l-p]").text();
                String time = listtime.get(i).select("th").text();
                lessonsLinkedList.add(new LessonData(les, url, num, gr, lec_pr + " " + g, ch_zn, teacher, place, time));
                i++;
            }
            return lessonsLinkedList;
        }

        @Override
        protected void onPostExecute(LinkedList<LessonData> lessons) {
            super.onPostExecute(lessons);
        }
    }
}
