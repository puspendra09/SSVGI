package com.example.admin;


import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class Academic_calendar extends Fragment {

    EditText et1,et2;
    CalendarView mcalendar;
    Button b1;
    String dateselected;
    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

            View v = inflater.inflate(R.layout.fragment_academic_calendar, container, false);

        et1=v.findViewById(R.id.hiddenEvent);
        et2=v.findViewById(R.id.etEvent);
        b1=v.findViewById(R.id.add_Calendar);
        mcalendar=v.findViewById(R.id.mCalendar);
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


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyData md=new MyData();
                String msg=md.addCalendar(dateselected,et2.getText().toString());
                Toast.makeText(getActivity().getApplication(), msg, Toast.LENGTH_SHORT).show();
                et1.setText("");
                et2.setText("");

            }
        });



            return v;

    }




}
