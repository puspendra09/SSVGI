package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Confirm_Faculty_reg extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    Button b1,b2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__faculty_reg);

        tv1 =findViewById(R.id.c_facultyId);
        tv2 =findViewById(R.id.c_facultyName);
        tv3 =findViewById(R.id.c_qualification);
        tv4 =findViewById(R.id.c_faculty_gender);
        tv5 =findViewById(R.id.c_dateofjoining);
        tv6 =findViewById(R.id.c_faculty_department);
        tv7 =findViewById(R.id.c_faculty_MobileNo);
        tv8 =findViewById(R.id.c_faculty_email);
        tv9 =findViewById(R.id.c_faculty_address);
        b1=findViewById(R.id.btn_faculty_confirm);
        b2=findViewById(R.id.btn_confirm_faculty_cancel);

        intent=getIntent();
        tv1.setText(intent.getStringExtra("femail_id"));
        tv2.setText(intent.getStringExtra("fname"));
        tv3.setText(intent.getStringExtra("fqualification"));
        tv4.setText(intent.getStringExtra("fgender"));
        tv5.setText(intent.getStringExtra("fdateofjoining"));
        tv6.setText(intent.getStringExtra("fdepartment"));
        tv7.setText(intent.getStringExtra("fmobile_no"));
        tv8.setText(intent.getStringExtra("femail_id"));
        tv9.setText(intent.getStringExtra("faddress"));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyData md=new MyData();
                String msg=md.facultyregistration(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString(),tv4.getText().toString(),tv5.getText().toString(),tv6.getText().toString(),tv7.getText().toString(),tv8.getText().toString(),tv9.getText().toString(),tv5.getText().toString());
                Toast.makeText(Confirm_Faculty_reg.this, msg, Toast.LENGTH_SHORT).show();
                Confirm_Faculty_reg.this.finish();
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Confirm_Faculty_reg.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
