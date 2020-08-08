 package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

 public class AddTimeTable extends AppCompatActivity {

     Spinner sp1,sp2,sp3,sp4,sp5,sp6,sp7;
     Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time_table);

        sp1=findViewById(R.id.sp_facultyid);
        sp2=findViewById(R.id.sp_course);
        sp3=findViewById(R.id.sp_department);
        sp4=findViewById(R.id.sp_batch);
        sp5=findViewById(R.id.sp_lactureNo);
        sp6=findViewById(R.id.sp_subject);
        sp7=findViewById(R.id.sp_day);
        b1=findViewById(R.id.btn_addTimeTable);
        b2=findViewById(R.id.btn_cancelTimeTable);

        MyData md=new MyData();
        String data=md.facultyDisplayID();
        final String fid[]=data.split(",");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, fid);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(arrayAdapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facultyid=sp1.getSelectedItem().toString();
                String course=sp2.getSelectedItem().toString();
                String department=sp3.getSelectedItem().toString();
                String batch=sp4.getSelectedItem().toString();
                String day=sp7.getSelectedItem().toString();
                String lectureno=sp5.getSelectedItem().toString();
                String subject=sp6.getSelectedItem().toString();

                MyData md=new MyData();
                String msg=md.addTimetable(facultyid,course,department,batch,day,lectureno,subject);
                Toast.makeText(AddTimeTable.this, msg, Toast.LENGTH_SHORT).show();
                AddTimeTable.this.finish();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(AddTimeTable.this,Time_table.class);
                startActivity(in);
            }
        });
    }
}
