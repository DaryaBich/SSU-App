package com.example.mobilessu.news_page;

import com.example.mobilessu.entities.News;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NewsModel implements NewsInterface.Model {
    // Функция парсинга новостей с сайта www.sgu.ru
    @NotNull
    @Override
    public List<News> getNews() throws IOException {
        //Document document = Jsoup.connect("https://www.sgu.ru/news").get();
        //Element listNews = document.select("");
        return new ArrayList<News>(Collections.singleton(new News("1", "2", "3")));
    }
}
