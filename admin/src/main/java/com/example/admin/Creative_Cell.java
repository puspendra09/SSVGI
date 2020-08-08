package com.example.admin;


import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Creative_Cell extends Fragment {

    Intent intent;
    CardView cv1,cv2,cv3,cv4,cv5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_creative__cell, container, false);

        cv1=v.findViewById(R.id.annual_fest);
        cv2=v.findViewById(R.id.fresher_party);
        cv3=v.findViewById(R.id.farewell_party);
        cv4=v.findViewById(R.id.sprts_day);
        cv5=v.findViewById(R.id.other_event);


        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getActivity().getApplication(),AnnualFest.class);
                startActivity(intent);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getActivity().getApplication(),Freasher.class);
                startActivity(intent);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getActivity().getApplication(),Farewell.class);
                startActivity(intent);
            }
        });

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getActivity().getApplication(),SportsDay.class);
                startActivity(intent);
            }
        });

        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getActivity().getApplication(),Others.class);
                startActivity(intent);
            }
        });

        return v;

    }

}
