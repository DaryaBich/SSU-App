package com.example.mobilessu.news_page;

import android.os.AsyncTask;
import android.util.Log;

import com.example.mobilessu.entities.News;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class NewsModel implements NewsInterface.Model {
    // Функция парсинга новостей с сайта www.sgu.ru
    @NotNull
    @Override
    public List<News> getNews() {
        try {
            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute();
            return myAsyncTask.get();
        } catch (ExecutionException e ) {
            Log.d("ERROR", "Problem with multithreading");
            return new LinkedList<>();
        } catch (InterruptedException e) {
            Log.d("ERROR", "Problem with multithreading");
            return new LinkedList<>();
        }
    }

    private static class MyAsyncTask extends AsyncTask<String, Integer, LinkedList<News>> {
        @Override
        protected LinkedList<News> doInBackground(String... strings) {
            LinkedList<News> resultNews = new LinkedList<>();
            try {
                Document document = Jsoup.connect("https://www.sgu.ru/news").get();
                Elements listNews = document.select("div[class^=views-row]");
                for (Element element : listNews) {
                    String date = element.select("div.field-content").get(0).attr("content");
                    String title = element.select("a[href]").get(0).text();
                    String url = element.select("a[href]").get(0).attr("href");
                    resultNews.add(new News(date, title, url));
                }
                return resultNews;
            } catch (IOException e) {
                return resultNews;
            }
        }
    }
}
