package com.example.ssvgifaculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class EnterMarks extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15;
    Spinner sp1;
    Button b1,b2;
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_marks);
        sp1=findViewById(R.id.examtype);
        et1=findViewById(R.id.subject1);
        et2=findViewById(R.id.subject2);
        et3=findViewById(R.id.subject3);
        et4=findViewById(R.id.subject4);
        et5=findViewById(R.id.subject5);
        et6=findViewById(R.id.om1);
        et7=findViewById(R.id.tm1);
        et8=findViewById(R.id.om2);
        et9=findViewById(R.id.tm2);
        et10=findViewById(R.id.om3);
        et11=findViewById(R.id.tm3);
        et12=findViewById(R.id.om4);
        et13=findViewById(R.id.tm4);
        et14=findViewById(R.id.om5);
        et15=findViewById(R.id.tm5);
        tv1=findViewById(R.id.tvobtain);
        tv2=findViewById(R.id.tvtotal);
        tv3=findViewById(R.id.mmname);
        b1=findViewById(R.id.btn_Emarks_submit);
        b2=findViewById(R.id.btn_Emarks_submit);


        Intent intent=getIntent();
        tv3.setText(intent.getStringExtra("id1"));

        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!et6.getText().toString().equals("")&&!et7.getText().toString().equals("")&&!et8.getText().toString().equals("")
                        &&!et9.getText().toString().equals("")&&!et10.getText().toString().equals("")&&!et11.getText().toString().equals("")
                        &&!et12.getText().toString().equals("")&&!et13.getText().toString().equals("")&&!et14.getText().toString().equals("")
                        &&!et15.getText().toString().equals(""))
                {
                    int temp1=Integer.parseInt(et6.getText().toString());
                    int temp2=Integer.parseInt(et8.getText().toString());
                    int temp3=Integer.parseInt(et10.getText().toString());
                    int temp4=Integer.parseInt(et12.getText().toString());
                    int temp5=Integer.parseInt(et14.getText().toString());
                    int temp6=Integer.parseInt(et7.getText().toString());
                    int temp7=Integer.parseInt(et9.getText().toString());
                    int temp8=Integer.parseInt(et11.getText().toString());
                    int temp9=Integer.parseInt(et13.getText().toString());
                    int temp10=Integer.parseInt(et15.getText().toString());

                    int obt=temp1+temp2+temp3+temp4+temp5;
                    int max=temp6+temp7+temp8+temp9+temp10;

                    tv1.setText(String.valueOf(obt));
                    tv2.setText(String.valueOf(max));

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        et6.addTextChangedListener(textWatcher);
        et7.addTextChangedListener(textWatcher);
        et8.addTextChangedListener(textWatcher);
        et9.addTextChangedListener(textWatcher);
        et10.addTextChangedListener(textWatcher);
        et11.addTextChangedListener(textWatcher);
        et12.addTextChangedListener(textWatcher);
        et13.addTextChangedListener(textWatcher);
        et14.addTextChangedListener(textWatcher);
        et15.addTextChangedListener(textWatcher);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EnterMarks.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
