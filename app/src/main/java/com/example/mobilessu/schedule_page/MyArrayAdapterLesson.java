package com.example.mobilessu.schedule_page;

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

import java.util.List;

public class MyArrayAdapterLesson extends ArrayAdapter<String> {
    Context context;
    int resource;
    List<String> lessonsList;
    public MyArrayAdapterLesson(Context context, int resource, List<String> lessonsList) {
        super(context, resource, lessonsList);
        this.context = context;
        this.lessonsList = lessonsList;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.groupslistitems,null);
        //  View view = inflater.inflate(R.layout.listitem,null);
        TextView textViewGroup = view.findViewById(R.id.itemGroup);
        // TextView textViewTitle = view.findViewById(R.id.itemTitle);
        LinearLayout linearLayout = view.findViewById(R.id.linearLayout);


        String lessons = lessonsList.get(position);
        //textViewGroup.setText(groups.getGroup());
        textViewGroup.setText(lessons);


        // textViewGroup.setText("39);
        // textViewTitle.setText(groups.getTitle());
        return view;
    }
}
