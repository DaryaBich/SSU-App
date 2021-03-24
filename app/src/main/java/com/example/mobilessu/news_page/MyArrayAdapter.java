package com.example.mobilessu.news_page;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.example.mobilessu.R;
import com.example.mobilessu.entities.News;
import java.util.List;
public class MyArrayAdapter extends ArrayAdapter<News> {
    Context context;
    int resource;
    List<News> newsList;
    public MyArrayAdapter(Context context, int resource,
                          List<News> newsList) {
        super(context, resource, newsList);
        this.context = context;
        this.newsList = newsList;
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater
                .from(context);
        View view = inflater.inflate(R.layout.news_list_items,
                null);
        TextView textViewDate = view
                .findViewById(R.id.itemDate);
        TextView textViewTitle = view
                .findViewById(R.id.itemTitle);
        News news = newsList.get(position);
        textViewDate.setText(news.getDate());
        textViewTitle.setText(news.getTitle());
        return view;
    }
}
