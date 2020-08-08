package com.example.ssvgifaculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class StudentsListMark extends AppCompatActivity {

    Intent intent;
    TextView tv1,tv2,tv3;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list_mark);

        tv1 =findViewById(R.id.mt1);
        tv2 =findViewById(R.id.mt2);
        tv3 =findViewById(R.id.mt3);
        listView=findViewById(R.id.mlist);


        intent=getIntent();
        tv1.setText(intent.getStringExtra("p1course"));
        tv2.setText(intent.getStringExtra("p1department"));
        tv3.setText(intent.getStringExtra("p1batch"));

        MyData md=new MyData();
        String data=md.marksstudentList(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString());
        final String msg[]=data.split(",");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, msg);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message=msg[position];
                intent=new Intent(StudentsListMark.this,EnterMarks.class);
                intent.putExtra("id1",message);
                startActivity(intent);
            }
        });


    }
}
