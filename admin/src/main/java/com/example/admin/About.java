package com.example.admin;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class About extends Fragment implements View.OnClickListener{


    public About() {
        // Required empty public constructor
    }

    ImageButton b1,b2,b3,b4;
    TextView tv,bug;
    String url;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_about, container, false);

        b1=v.findViewById(R.id.btn_whatapp);
        b2=v.findViewById(R.id.btn_fb);
        b3=v.findViewById(R.id.btn_instra);
        b4=v.findViewById(R.id.btn_twitter);
        tv=v.findViewById(R.id.website);
        bug=v.findViewById(R.id.bug_report);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url="http://www.ssvgi.org/";
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"puspendra09singh@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"");
                intent.putExtra(Intent.EXTRA_TEXT,"");
                intent.putExtra(Intent.EXTRA_CC,"");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });

        return v;
    }

    @Override
    public void onClick(View view) {
        ImageButton b=(ImageButton)view;
        if (b==b1){
            intent=new Intent(Intent.ACTION_SEND);
            String[] recipients={"info@ssvgi.org"};
            intent.putExtra(Intent.EXTRA_EMAIL, recipients);
            intent.putExtra(Intent.EXTRA_SUBJECT,"");
            intent.putExtra(Intent.EXTRA_TEXT,"");
            intent.putExtra(Intent.EXTRA_CC,"");
            intent.setType("text/html");
            intent.setPackage("com.google.android.gm");
            startActivity(Intent.createChooser(intent, "Send mail"));
        }
        else if (b==b2){
            url="https://www.facebook.com/ssvgiofficial/";
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);

        }else if (b==b3){
            url="https://www.instagram.com/shrisiddhivinayakofficial/";
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }else {
            url="https://twitter.com/search?q=%23SSVGI&src=typd";
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
    }
}
