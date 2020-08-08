package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Loader extends AppCompatActivity {

    Intent intent;
    ImageView imageView;
    private final int SPLASH_DISPLAY_LENGTH=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        imageView=findViewById(R.id.image_loading);


        checkConnection();

      /*
*/
    }


    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    private void checkConnection() {

        if(isOnline()){

            Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation1);
            imageView.startAnimation(aniSlide);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in = new Intent(Loader.this, Login.class);
                    startActivity(in);
                    finish();
                }
            }, SPLASH_DISPLAY_LENGTH);

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(Loader.this);
            builder.setTitle("Internet Connection Alert");
            builder.setMessage("Please ckeck your Internet connection");
            builder.setPositiveButton("Close",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {
                            finish();
                        }
                    });
            builder.show();
        }

    }


}
