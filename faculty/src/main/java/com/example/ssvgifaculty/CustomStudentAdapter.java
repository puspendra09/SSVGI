package com.example.ssvgifaculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomStudentAdapter extends BaseAdapter {
    Context c;
    MyData md=new MyData();
    String data=md.studentDisplay();
    final String slist[]=data.split(",");

    String data2=md.studentDisplayID();
    final String sID[]=data2.split(",");

    public CustomStudentAdapter(Context ctx)
    {
        this.c=ctx;
    }

    @Override
    public int getCount() {
        return slist.length;
    }

    @Override
    public Object getItem(int position) {
        return slist[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.listlayout,null);

        }

        TextView sname=(TextView) convertView.findViewById(R.id.tv);
        TextView sid=(TextView) convertView.findViewById(R.id.tv2);

        sname.setText(slist[position]);
        sid.setText(sID[position]);


        return convertView;
    }
}

