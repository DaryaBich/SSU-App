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
        View view = inflater.inflate(R.layout.scheduleslistitems,null);
        //  View view = inflater.inflate(R.layout.listitem,null);
        TextView Textname = view.findViewById(R.id.item_name);
        TextView Textlec_pr = view.findViewById(R.id.item_lec_pr);
        TextView Textch_zn = view.findViewById(R.id.item_ch_zn);
        TextView Textteacher = view.findViewById(R.id.item_teacher);
        TextView Textplace = view.findViewById(R.id.item_place);
        // TextView textViewTitle = view.findViewById(R.id.itemTitle);
        //LinearLayout linearLayout = view.findViewById(R.id.linearLayout);

        LessonData lessons = lessonsList.get(position);
        //textViewGroup.setText(groups.getGroup());
        Textname.setText(lessons.getname());
        Textlec_pr.setText(lessons.getlec_pr());
        Textch_zn.setText(lessons.getch_zn());
        Textteacher.setText(lessons.getteacher());
        Textplace.setText(lessons.getplace());


        // textViewGroup.setText("39);
        // textViewTitle.setText(groups.getTitle());
        return view;
    }
}
