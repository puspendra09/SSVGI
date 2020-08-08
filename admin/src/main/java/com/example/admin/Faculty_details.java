package com.example.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Faculty_details extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    Intent intent;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);

        tv1=findViewById(R.id.d_fname);
        tv2=findViewById(R.id.d_fquali);
        tv3=findViewById(R.id.d_fgender);
        tv4=findViewById(R.id.d_fdateofjoining);
        tv5=findViewById(R.id.d_fdepartment);
        tv6=findViewById(R.id.d_fmobileno);
        tv7=findViewById(R.id.d_femailid);
        tv8=findViewById(R.id.d_fpassword);
        tv9=findViewById(R.id.d_faddress);
        b1=findViewById(R.id.btn_fdEdit);
        b2=findViewById(R.id.btn_fdBack);


        intent=getIntent();
        tv7.setText(intent.getStringExtra("fdID"));

        MyData md=new MyData();
        String data=md.facultydetail(tv7.getText().toString());
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
                tv8.setText(c[8]);
                tv9.setText(c[7]);


            }
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Faculty_details.this, "Click on Edit", Toast.LENGTH_SHORT).show();
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(Faculty_details.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
