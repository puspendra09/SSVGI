package com.example.admin;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class T_mon extends Fragment {

    ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_t_mon, container, false);
        listView=v.findViewById(R.id.ttl);

        MyData md=new MyData();
        String data=md.showtimetablelistMon();
        final String msg[]=data.split(",");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getActivity().getApplication(), android.R.layout.simple_list_item_1, msg);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message=msg[position];

                Intent intent=new Intent(getActivity().getApplication(),ShowTimetable.class);
                intent.putExtra("idt",message);
                startActivity(intent);
            }
        });



        return v;
    }

}
