package com.example.admin;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class View_Faculty extends Fragment {

    ListView listView;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_view__faculty, container, false);
        listView=v.findViewById(R.id.facultylist);

        CustomFacultyAdapter adapter=new CustomFacultyAdapter(getActivity());
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message1= ((TextView) view.findViewById(R.id.tv2)).getText().toString();
                EditText et=new EditText(getActivity());
                et.setText(message1);

                MyData md=new MyData();
                boolean data=md.facultydetailvalid(et.getText().toString());
                if (data == true) {
                    intent=new Intent(getActivity().getApplication(),Faculty_details.class);
                    intent.putExtra("fdID",message1);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity().getApplication(), "Invalid ID and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

}
