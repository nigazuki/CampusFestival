package com.nigazuki.campusfestival.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Timetable_tab1Activity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_timetable_tab1, container, false);

        LinearLayout layout = (LinearLayout) v.findViewById(R.id.timetable_tab1);
        for (int i = 9; i < 19; i++) {
            View view = inflater.inflate(R.layout.timetable_list, null);
            TextView timeTxt = (TextView) view.findViewById(R.id.timetable_list_text);
            timeTxt.setText("test");
            LinearLayout frame = (LinearLayout) view.findViewById(R.id.timetable_list_frame);
            switch(i%3){
                case 0:
                    frame.setBackgroundResource(R.drawable.frame);
                    break;
                default:
                    break;
            }
            layout.addView(view);
        }

        return v;

    }

}