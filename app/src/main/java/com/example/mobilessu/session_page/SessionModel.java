package com.example.mobilessu.session_page;

import android.os.AsyncTask;
import android.util.Log;

import com.example.mobilessu.entities.LessonData;
import com.example.mobilessu.entities.SessionData;
import com.example.mobilessu.schedule_page.ScheduleInterface;
import com.example.mobilessu.schedule_page.ScheduleModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SessionModel implements SessionInterface.Model{
    private SessionModel.MyAsyncTask myAsyncTask;
    @Override
    public List<SessionData> getSessions(SessionData sessionData) throws IOException, ExecutionException, InterruptedException {
        try {
            myAsyncTask = new SessionModel.MyAsyncTask();
            myAsyncTask.execute(sessionData);
            return myAsyncTask.get();
        } catch (ExecutionException | InterruptedException e) {
            Log.d("ERROR", "Problem with multithreading");
            return new LinkedList<>();
        }
    }
    // первый параметр это тип входных параметров, третий - тип выходных параметров
    //private static class MyAsyncTask extends AsyncTask<ScheduleData, Void, LinkedList<ScheduleData>>
    private static class MyAsyncTask extends AsyncTask<SessionData, Void, LinkedList<SessionData>> {

        // private ScheduleData scheduleData;
        @Override
        // Тогда здесь входным параметром будет ScheduleData
        //protected LinkedList<ScheduleData> doInBackground(ScheduleData... sheduleData)
        protected LinkedList<SessionData> doInBackground(SessionData... sessionData) {

            //LinkedList<ScheduleData> groupsLinkedList = new LinkedList<>();
            LinkedList<SessionData> sessionsLinkedList = new LinkedList<>();

            String url = sessionData[0].geturl();
            //Integer num = lessonData[0].getnum();
            Document document = null;
            try {
                document = Jsoup.connect(url).timeout(100000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements listSessions;
            // listLessons = document.select("td[id*=1_2]");
           // String str = "td[id$=" + num + "]";
            listSessions = document.select("table#session").select("tr");
            //String str = "td[id$=" + num + "]";
            // listLessons = document.select(str);
            //Elements listtime = document.select("tr");
            //Integer i = 1;

            for (int i = 0; i < listSessions.size(); i++) {
                Element element = listSessions.get(i);
                Elements list1 = element.select("td");
                String date = list1.get(0).text();
                String time = list1.get(1).text();
                String name = list1.get(2).text() + " " + list1.get(3).text();
                i++;
                element = listSessions.get(i);
                String teacher = element.select("td").text();
                i++;
                element = listSessions.get(i);
                String place = element.select("td").text();
                sessionsLinkedList.add(new SessionData(name, url, date, time, teacher, place));
            }
//            for (Element element : listSessions) {
////                for (int i = 1; i < 9; i++) {
////                    String les = element.select("div[class*=l-dn]").text();
////                }
//                String les = element.select("div[class=l-dn]").text();
//                String lec_pr = element.select("div[class=l-pr-t]").text();
//                String ch_zn = element.select("div[class=l-pr-r]").text();
//                String g = element.select("div[class=l-pr-g]").text();
//                String teacher = element.select("div[class=l-tn]").text();
//                String place = element.select("div[class=l-p]").text();
//                //String time = listtime.get(i).select("th").text();
//
//
//                lessonsLinkedList.add(new LessonData(les, url, num, lec_pr + " " + g, ch_zn, teacher, place, time));
//                i++;
//            }
            return sessionsLinkedList;
        }

        @Override
        protected void onPostExecute(LinkedList<SessionData> sessions) {
            super.onPostExecute(sessions);
        }
    }
}
