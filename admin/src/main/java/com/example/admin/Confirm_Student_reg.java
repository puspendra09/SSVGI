package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Confirm_Student_reg extends AppCompatActivity {


    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12;
    Button b1,b2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__student_reg);
        tv1 =findViewById(R.id.c_studentId);
        tv2 =findViewById(R.id.c_studentName);
        tv3 =findViewById(R.id.c_fatherName);
        tv4 =findViewById(R.id.c_motherName);
        tv5 =findViewById(R.id.c_gender);
        tv6 =findViewById(R.id.c_dateofbirth);
        tv7 =findViewById(R.id.c_course);
        tv8 =findViewById(R.id.c_department);
        tv9 =findViewById(R.id.c_batch);
        tv10=findViewById(R.id.c_mobileNo);
        tv11=findViewById(R.id.c_email);
        tv12=findViewById(R.id.c_address);
        b1=findViewById(R.id.btn_confirm);
        b2=findViewById(R.id.btn_confirm_cancel);

        intent=getIntent();



        tv1.setText(intent.getStringExtra("sEmail_no"));
        tv2.setText(intent.getStringExtra("sStudent_Name"));
        tv3.setText(intent.getStringExtra("sFather_Name"));
        tv4.setText(intent.getStringExtra("sMother_Name"));
        tv5.setText(intent.getStringExtra("sGender"));
        tv6.setText(intent.getStringExtra("sDateofbirth"));
        tv7.setText(intent.getStringExtra("sCourse"));
        tv8.setText(intent.getStringExtra("sDepartment"));
        tv9.setText(intent.getStringExtra("sBatch"));
        tv10.setText(intent.getStringExtra("sMobile_no"));
        tv11.setText(intent.getStringExtra("sEmail_no"));
        tv12.setText(intent.getStringExtra("sAddress"));



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyData md=new MyData();
                String msg=md.studentregistration(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString(),tv4.getText().toString(),tv5.getText().toString(),tv6.getText().toString(),tv7.getText().toString(),tv8.getText().toString(),tv9.getText().toString(),tv10.getText().toString(),tv11.getText().toString(),tv12.getText().toString());
                Toast.makeText(Confirm_Student_reg.this, msg, Toast.LENGTH_SHORT).show();
                Confirm_Student_reg.this.finish();

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               intent=new Intent(Confirm_Student_reg.this,MainActivity.class);
               startActivity(intent);
               finish();
            }
        });

    }
}
