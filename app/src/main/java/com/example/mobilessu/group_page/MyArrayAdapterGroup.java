package com.example.mobilessu.group_page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobilessu.R;
import com.example.mobilessu.entities.News;
import com.example.mobilessu.entities.ScheduleData;

import java.util.List;

public class MyArrayAdapterGroup extends ArrayAdapter<ScheduleData> {
    Context context;
    int resource;
    List<ScheduleData> newsList;

    public MyArrayAdapter(Context context, int resource, List<ScheduleData> newsList) {
        super(context, resource, newsList);
        this.context = context;
        this.newsList = newsList;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.news_list_items,null);
        TextView textViewDate = view.findViewById(R.id.itemDate);
        TextView textViewTitle = view.findViewById(R.id.itemTitle);
        LinearLayout linearLayout = view.findViewById(R.id.linearLayout);
        ScheduleData groups = newsList.get(position);
        textViewDate.setText(groups.getDate());
        textViewTitle.setText(groups.getTitle());
        return view;
    }
}
