package com.example.admin;



import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class View_Students extends Fragment{

    ListView listView;
    Intent intent;
    SearchView searchView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_view__students, container, false);
        listView=v.findViewById(R.id.studentlist);
        searchView=v.findViewById(R.id.search_Student);

        CustomStudentAdapter adapter=new CustomStudentAdapter(getActivity());

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String message= ((TextView) view.findViewById(R.id.tv2)).getText().toString();
                EditText et=new EditText(getActivity());
                et.setText(message);

                MyData md=new MyData();
                boolean data=md.studentdetailvalid(et.getText().toString());
                if (data == true) {
                    intent=new Intent(getActivity().getApplication(),Student_deatils.class);
                    intent.putExtra("sdID",message);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity().getApplication(), "Invalid ID and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });





        return v;
    }
}

