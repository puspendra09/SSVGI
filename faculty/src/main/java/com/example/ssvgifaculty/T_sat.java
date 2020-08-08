package com.example.ssvgifaculty;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class T_sat extends Fragment {

    LinearLayout linearLayout;
    Intent intent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_t_sat, container, false);

        linearLayout=v.findViewById(R.id.ll_tsatshow);

        intent=getActivity().getIntent();
        String nid=intent.getStringExtra("ftname");


        MyData md=new MyData();
        String data=md.tfacultysat(nid);
        String msg[]=data.split(";");

        for (String msgs:msg) {
            TextView textView=new TextView(getActivity().getApplication());
            textView.setText(msgs);
            textView.setTextSize(16);
            textView.setTextColor(Color.BLACK);
            linearLayout.addView(textView);
        }
        return v;

    }

}
