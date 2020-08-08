package com.example.admin;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        MyData md=new MyData();
        String data=md.facultyDisplay();
        final String fname[]=data.split(";");




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
