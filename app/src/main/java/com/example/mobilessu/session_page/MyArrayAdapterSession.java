package com.example.mobilessu.session_page;

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
import com.example.mobilessu.entities.SessionData;

import java.util.List;

public class MyArrayAdapterSession extends ArrayAdapter<SessionData> {
    Context context;
    int resource;
    List<SessionData> sessionsList;
    public MyArrayAdapterSession(Context context, int resource, List<SessionData> sessionsList) {
        super(context, resource, sessionsList);
        this.context = context;
        this.sessionsList = sessionsList;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sessionslistitems,null);
        //  View view = inflater.inflate(R.layout.listitem,null);
        TextView Textname = view.findViewById(R.id.item_name);
        TextView Textdate = view.findViewById(R.id.item_date);
        //TextView Textlec_pr = view.findViewById(R.id.item_lec_pr);
        //TextView Textch_zn = view.findViewById(R.id.item_ch_zn);
        TextView Textteacher = view.findViewById(R.id.item_teacher);
        TextView Textplace = view.findViewById(R.id.item_place);
        TextView Texttime = view.findViewById(R.id.item_time);
        // TextView textViewTitle = view.findViewById(R.id.itemTitle);
        //LinearLayout linearLayout = view.findViewById(R.id.linearLayout);

        SessionData sessions = sessionsList.get(position);
        //textViewGroup.setText(groups.getGroup());

        Textdate.setText(sessions.getdate());
        Textname.setText(sessions.getname());
        Textteacher.setText(sessions.getteacher());
        Textplace.setText(sessions.getplace());
        Texttime.setText(sessions.gettime());

        // textViewGroup.setText("39);
        // textViewTitle.setText(groups.getTitle());
        return view;
    }
}
