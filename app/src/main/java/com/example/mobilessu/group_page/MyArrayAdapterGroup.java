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
import com.example.mobilessu.entities.ScheduleData;

import java.util.List;

public class MyArrayAdapterGroup extends ArrayAdapter<ScheduleData> {
    Context context;
    int resource;
    List<ScheduleData> groupsList;

    public MyArrayAdapterGroup(Context context, int resource, List<ScheduleData> groupsList) {
        super(context, resource, groupsList);
        this.context = context;
        this.groupsList = groupsList;
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
        ScheduleData groups = groupsList.get(position);
        textViewGroup.setText(groups.getGroup());
       // textViewGroup.setText("39);
       // textViewTitle.setText(groups.getTitle());
        return view;
    }
}
