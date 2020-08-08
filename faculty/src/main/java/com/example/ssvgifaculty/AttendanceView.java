package com.example.ssvgifaculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AttendanceView extends AppCompatActivity {

    LinearLayout linearLayout;
    Intent intent;
    TextView tv1,tv2,tv3,tv4;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_view);

        linearLayout=findViewById(R.id.ll_attendanceView);

        tv1 =findViewById(R.id.t1);
        tv2 =findViewById(R.id.t2);
        tv3 =findViewById(R.id.t3);
        tv4 =findViewById(R.id.t4);
        b1=findViewById(R.id.btn_a_submit);
        b2=findViewById(R.id.btn_a_cancel);


        intent=getIntent();
        tv1.setText(intent.getStringExtra("pcourse"));
        tv2.setText(intent.getStringExtra("pdepartment"));
        tv3.setText(intent.getStringExtra("pbatch"));
        tv4.setText(intent.getStringExtra("tdate"));

        MyData md=new MyData();
        String data=md.attendancestudent(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
        String msg[]=data.split(",");

        for (String msgs:msg) {
            CheckBox checkBox=new CheckBox(AttendanceView.this);
            checkBox.setText(msgs);
            checkBox.setTextSize(20);
            checkBox.setTextColor(Color.BLACK);
            linearLayout.addView(checkBox);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String values="";
                for (int i=0;i<linearLayout.getChildCount();i++)
                {
                    CheckBox k=(CheckBox)linearLayout.getChildAt(i);
                    if (k.isChecked())
                        values=values+k.getText().toString()+",";

                    String atten[]=values.split(",");

                    for (String msgs1:atten) {
                        Toast.makeText(AttendanceView.this, msgs1, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(AttendanceView.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
