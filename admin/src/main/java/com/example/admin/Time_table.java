package com.example.admin;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Time_table extends Fragment {

Button b1,b2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_time_table, container, false);
        b1=v.findViewById(R.id.add_timeTable);
        b2=v.findViewById(R.id.update_timeTable);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getActivity().getApplication(),AddTimeTable.class);
               startActivity(intent);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity().getApplication(),UpdateTime_Table .class);
                startActivity(intent);
            }
        });


        return v;
    }

}
