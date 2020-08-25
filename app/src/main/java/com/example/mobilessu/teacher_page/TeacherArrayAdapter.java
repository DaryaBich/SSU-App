package com.example.mobilessu.teacher_page;

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
import com.example.mobilessu.entities.Teacher;

import java.util.List;

public class TeacherArrayAdapter extends ArrayAdapter<Teacher> {
    Context context;
    int resource;
    List<Teacher> teacherList;

    public TeacherArrayAdapter(Context context, int resource, List<Teacher> teacherList) {
        super(context, resource, teacherList);
        //super(context, resource, teacherList);
        this.context = context;
        this.teacherList = teacherList;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.teacher_list_item,null);
        TextView textViewTeacher = view.findViewById(R.id.itemTeacher);
        LinearLayout linearLayout = view.findViewById(R.id.linearLayout);
        Teacher teacher = teacherList.get(position);
        textViewTeacher.setText(teacher.getName()+" " + teacher.getPatronymic()+" " + teacher.getSurname());
        return view;
    }
}
