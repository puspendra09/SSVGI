package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShowTimetable extends AppCompatActivity {

    TextView tv1;
    Intent intent;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_timetable);
        tv1=findViewById(R.id.tfid);
        linearLayout=findViewById(R.id.ll_tfname);

        intent=getIntent();
        tv1.setText(intent.getStringExtra("idt"));

        MyData md=new MyData();
        String data=md.tfacultydetail(tv1.getText().toString());
        String msg[]=data.split(";");

        for (String msgs:msg) {
            TextView textView=new TextView(ShowTimetable.this);
            textView.setText(msgs);
            textView.setTextSize(16);
            textView.setTextColor(Color.BLACK);
            linearLayout.addView(textView);
        }

    }
}
