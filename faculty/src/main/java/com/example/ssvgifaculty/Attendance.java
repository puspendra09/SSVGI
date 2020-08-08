package com.example.ssvgifaculty;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Attendance extends Fragment {

    Button b1,b2;
    Spinner sp1,sp2,sp3;
    Intent intent;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_attendance, container, false);

        sp1=v.findViewById(R.id.as_course);
        sp2=v.findViewById(R.id.as_department);
        sp3=v.findViewById(R.id.as_batch);
        b1=v.findViewById(R.id.btn_as_submit);
        b2=v.findViewById(R.id.btn_as_cancel);
        textView=v.findViewById(R.id.tdate);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String currentDateandTime = sdf.format(new Date());
        textView.setText(currentDateandTime);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String mcourse=sp1.getSelectedItem().toString();
                final String mdepartment=sp2.getSelectedItem().toString();
                final String mbatch=sp3.getSelectedItem().toString();

                    intent=new Intent(getActivity().getApplication(),AttendanceView.class);
                    intent.putExtra("pcourse",mcourse);
                    intent.putExtra("pdepartment",mdepartment);
                    intent.putExtra("pbatch",mbatch);
                    intent.putExtra("tdate",textView.getText().toString());
                    startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity().getApplication(),MainActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}