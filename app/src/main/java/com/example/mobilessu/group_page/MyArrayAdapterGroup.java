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

import java.util.List;

public class MyArrayAdapterGroup extends ArrayAdapter<String> {
    Context context;
    int resource;
    List<String> groupsList;

    public MyArrayAdapterGroup(Context context, int resource, List<String> groupsList) {
        super(context, resource, groupsList);
        this.context = context;
        this.groupsList = groupsList;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.groups_list_items,null);
      //  View view = inflater.inflate(R.layout.listitem,null);
        TextView textViewGroup = view.findViewById(R.id.itemGroup);
       // TextView textViewTitle = view.findViewById(R.id.itemTitle);
        LinearLayout linearLayout = view.findViewById(R.id.linearLayout);


        String groups = groupsList.get(position);
        //textViewGroup.setText(groups.getGroup());
        textViewGroup.setText(groups);


       // textViewGroup.setText("39);
       // textViewTitle.setText(groups.getTitle());
        return view;
    }
}
