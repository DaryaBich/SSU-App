package com.example.mobilessu.schedule_page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobilessu.R;
import com.example.mobilessu.entities.LessonData;

import java.util.List;

public class MyArrayAdapterLesson extends ArrayAdapter<LessonData> {
    Context context;
    int resource;
    List<LessonData> lessonsList;
    public MyArrayAdapterLesson(Context context, int resource, List<LessonData> lessonsList) {
        super(context, resource, lessonsList);
        this.context = context;
        this.lessonsList = lessonsList;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.schedules_list_items,null);
        TextView Textname = view.findViewById(R.id.item_name);
        TextView Textlec_pr = view.findViewById(R.id.item_lec_pr);
        TextView Textch_zn = view.findViewById(R.id.item_ch_zn);
        TextView Textteacher = view.findViewById(R.id.item_teacher);
        TextView Textplace = view.findViewById(R.id.item_place);
        TextView Texttime = view.findViewById(R.id.item_time);
        LessonData lessons = lessonsList.get(position);
        Textname.setText(lessons.getname());
        Textlec_pr.setText(lessons.getlec_pr());
        Textch_zn.setText(lessons.getch_zn());
        Textteacher.setText(lessons.getteacher());
        Textplace.setText(lessons.getplace());
        Texttime.setText(lessons.gettime());
        return view;
    }
}
