package com.example.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomFacultyAdapter extends BaseAdapter {

    Context c;
    MyData md=new MyData();
    String data=md.facultyDisplay();
    final String flist[]=data.split(",");
    String data2=md.facultyDisplayID();
    final String fID[]=data2.split(",");
    public CustomFacultyAdapter(Context ctx)
    {
        this.c=ctx;
    }
    @Override
    public int getCount() {
        return flist.length;
    }

    @Override
    public Object getItem(int position) {
        return flist[position];
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

        sname.setText(flist[position]);
        sid.setText(fID[position]);
        return convertView;
    }
}
