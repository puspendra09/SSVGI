package com.example.ssvgifaculty;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;



public class Marks extends Fragment {

    Button b1,b2;
    Spinner sp1,sp2,sp3,sp4;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_marks, container, false);

        sp1=v.findViewById(R.id.marks_course);
        sp2=v.findViewById(R.id.marks_department);
        sp3=v.findViewById(R.id.marks_batch);
        b1=v.findViewById(R.id.btn_marks_submit);
        b2=v.findViewById(R.id.btn_marks_cancel);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String m1course=sp1.getSelectedItem().toString();
                final String m1department=sp2.getSelectedItem().toString();
                final String m1batch=sp3.getSelectedItem().toString();

                intent=new Intent(getActivity().getApplication(),StudentsListMark.class);
                intent.putExtra("p1course",m1course);
                intent.putExtra("p1department",m1department);
                intent.putExtra("p1batch",m1batch);
                startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getActivity().getApplication(),MainActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

}
