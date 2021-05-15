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
    private static class MyAsyncTask extends AsyncTask<SessionData, Void, LinkedList<SessionData>> {
        @Override
        // Тогда здесь входным параметром будет ScheduleData
        protected LinkedList<SessionData> doInBackground(SessionData... sessionData) {
            LinkedList<SessionData> sessionsLinkedList = new LinkedList<>();
            String url = sessionData[0].geturl();
            Document document = null;
            try {
                document = Jsoup.connect(url).timeout(100000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements listSessions;
            listSessions = document.select("table#session").select("tr");

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
            return sessionsLinkedList;
        }

        @Override
        protected void onPostExecute(LinkedList<SessionData> sessions) {
            super.onPostExecute(sessions);
        }
    }
}
