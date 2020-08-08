package com.example.ssvgifaculty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText et1,et2;
    Button b1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1=findViewById(R.id.login_userid);
        et2=findViewById(R.id.login_password);
        b1=findViewById(R.id.btn_admin_login);

        final String name=et1.getText().toString();

        SharedPreferences sp=getSharedPreferences("mypress",MODE_PRIVATE);
        if (!sp.getString("username","kaddu").equals("kaddu")){
            Intent in=new Intent(Login.this,MainActivity.class);
            startActivity(in);
            finish();
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uanme=et1.getText().toString();
                String pass=et2.getText().toString();

                if (TextUtils.isEmpty(uanme)){
                    et1.setError("User ID blank");
                    return;

                }else if (TextUtils.isEmpty(pass)) {
                    et2.setError("Password blank");
                    return;
                }else {

                }

                MyData m = new MyData();
                boolean result = m.isvalid(et1.getText().toString(),et2.getText().toString());
                if (result == true) {
                    SharedPreferences sp=getSharedPreferences("mypress",MODE_PRIVATE);
                    SharedPreferences.Editor ed=sp.edit();
                    ed.putString("username",uanme);
                    ed.commit();

                    intent = new Intent(Login.this,MainActivity.class);
                    intent.putExtra("name", et1.getText().toString());
                    startActivity(intent);



                } else {
                    Toast.makeText(Login.this, "Invalid ID and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
