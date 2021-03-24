package com.example.mobilessu.news_page;
import android.os.AsyncTask;
import android.util.Log;
import com.example.mobilessu.entities.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
public class NewsModel implements NewsInterface.Model {
    @Override
    public List<News> getNews() {
        try {
            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute();
            return myAsyncTask.get();
        } catch (ExecutionException | InterruptedException e) {
            Log.d("ERROR", "Problem with multithreading");
            return new LinkedList<>();
        }
    }
    private static class MyAsyncTask extends
            AsyncTask<Void, Void, LinkedList<News>> {
        @Override
        protected LinkedList<News> doInBackground
                (Void... voids) {
            LinkedList<News> newsLinkedList =
                    new LinkedList<>();
            try { Document document = Jsoup
                        .connect("https://www.sgu.ru/news")
                        .get();
                Elements listNews = document
                        .select("div.region.region"
                                +"-local-navigation")
                        .select("div[class*=smart-links]");
                for (Element element : listNews) {
                    String date = element
                            .select("span.date-display"
                                    +"-single")
                            .get(0).attr("content");
                    date = date.substring(8, 10)+"."
                            + date.substring(5,7) +"."
                            + date.substring(0, 4);
                    String title = element.select("a[href]")
                            .get(0).text();
                    String url = "https://www.sgu.ru"
                            + element.select("a[href]")
                            .get(0).attr("href");
                    newsLinkedList.add(
                            new News(date, title, url));
                }
                return newsLinkedList;
            } catch (IOException e) {
                return newsLinkedList;
            }
        }
        @Override
        protected void onPostExecute(LinkedList<News> news){
            super.onPostExecute(news);
        }
    }
}