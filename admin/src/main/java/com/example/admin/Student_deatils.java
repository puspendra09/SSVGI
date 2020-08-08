package com.example.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Student_deatils extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12;
    Intent intent;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_deatils);
        tv1=findViewById(R.id.d_sname);
        tv2=findViewById(R.id.d_sfathername);
        tv3=findViewById(R.id.d_smothername);
        tv4=findViewById(R.id.d_sgender);
        tv5=findViewById(R.id.d_sdateofbirth);
        tv6=findViewById(R.id.d_scourse);
        tv7=findViewById(R.id.d_sdepartment);
        tv8=findViewById(R.id.d_sbatch);
        tv9=findViewById(R.id.d_smobileno);
        tv10=findViewById(R.id.d_semailid);
        tv11=findViewById(R.id.d_spassword);
        tv12=findViewById(R.id.d_saddress);
        b1=findViewById(R.id.btn_sdEdit);
        b2=findViewById(R.id.btn_dBack);


        intent=getIntent();
        tv10.setText(intent.getStringExtra("sdID"));


        MyData md=new MyData();
        String data=md.studentdetail(tv10.getText().toString());
        String msg[]=data.split(";");
        for (String msgs:msg) {
            if (msgs.contains(",")) {
                String c[] = msgs.split(",");
                tv1.setText(c[0]);
                tv2.setText(c[1]);
                tv3.setText(c[2]);
                tv4.setText(c[3]);
                tv5.setText(c[4]);
                tv6.setText(c[5]);
                tv7.setText(c[6]);
                tv8.setText(c[7]);
                tv9.setText(c[8]);
                tv11.setText(c[11]);
                tv12.setText(c[10]);

            }
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Student_deatils.this, "Click on Edit", Toast.LENGTH_SHORT).show();
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(Student_deatils.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
