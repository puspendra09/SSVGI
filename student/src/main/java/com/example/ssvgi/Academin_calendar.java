package com.example.ssvgi;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Academin_calendar extends Fragment {

    CalendarView mcalendar;
    EditText et1;
    String dateselected;
    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_academin_calendar, container, false);

        mcalendar=v.findViewById(R.id.mCalendar);
        et1=v.findViewById(R.id.hiddenEvent);
        linearLayout=v.findViewById(R.id.ll_event);

        mcalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                et1.setText(dayOfMonth + "/" + month + "/" + year);
                dateselected = et1.getText().toString();

                MyData md = new MyData();
                String data = md.showevent(et1.getText().toString());
                linearLayout.removeAllViews();
                String msg[]=data.split(";");

                for(int i=0 ; i<msg.length;i++) {
                    TextView tv = new TextView(getActivity());
                    tv.setText(msg[i]);
                    tv.setTextSize(22);
                    tv.setTextColor(Color.BLACK);
                    tv.setPadding(10, 0, 0, 0);
                    linearLayout.addView(tv);
                }
            }
        });


        return v;
    }

}
