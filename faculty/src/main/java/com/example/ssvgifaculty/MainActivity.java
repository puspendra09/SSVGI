package com.example.ssvgifaculty;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    Intent intent;
    String profilename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sp=getSharedPreferences("mypress",MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        profilename=sp.getString("username","");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        View headerview=navigationView.getHeaderView(0);
        TextView textView=headerview.findViewById(R.id.userName);

        intent = getIntent();
        textView.setText(profilename);
        textView.setTextColor(Color.BLACK);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout,new Dashboard());
        ft.commit();

        navigationView.setCheckedItem(R.id.nav_dashboard);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_changePassword) {
            final Dialog d=new Dialog(MainActivity.this);
            d.setContentView(R.layout.change_password);
            Button bt=d.findViewById(R.id.btn_submit_changePassword);
            final EditText et=d.findViewById(R.id.oldPassword);
            final EditText et1=d.findViewById(R.id.newPassword);
            final EditText et2=d.findViewById(R.id.confirm_NewPassword);



            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String oldpassword=et.getText().toString();
                    final String password=et1.getText().toString();
                    final String confirmpassword=et2.getText().toString();


                    if (TextUtils.isEmpty(oldpassword)){
                        et.setError("Old Password blank");
                        return;

                    }else if (TextUtils.isEmpty(password)){
                        et1.setError("New Password blank");
                        return;

                    }else if (TextUtils.isEmpty(confirmpassword)){
                        et2.setError("Confirm Password blank");
                        return;

                    }else {
                        if (password.equals(confirmpassword)) {

                            MyData md = new MyData();
                            Toast.makeText(MainActivity.this, "matched", Toast.LENGTH_SHORT).show();
                            d.dismiss();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Password not Match", Toast.LENGTH_SHORT).show();
                        }

                    }
                    return;


                }
            });
            d.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {

            Fragment frag=new Dashboard();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        } else if (id == R.id.nav_studentView) {

            Fragment frag=new View_Students();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        } else if (id == R.id.nav_attendance) {

            Fragment frag=new Attendance();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        } else if (id == R.id.nav_timetable) {

            intent=new Intent(MainActivity.this,Timetable2.class);
            intent.putExtra("ftname",profilename);
            startActivity(intent);

           /* Fragment frag=new Time_Table();
            Bundle args = new Bundle();
            args.putString("idt1",profilename);
            frag.setArguments(args);


            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();
*/
        } else if (id == R.id.nav_lecturePlan) {

            Fragment frag=new Lesson_plan();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        } else if (id == R.id.nav_academicCalendar) {

            Fragment frag=new Academic_calendar();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        } else if (id == R.id.nav_marks) {

            Fragment frag=new Marks();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        } else if (id == R.id.nav_studentGrievance) {

            Fragment frag=new Student_Grievance();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        } else if (id == R.id.nav_creativeCell) {

            Fragment frag=new Creative_Cell();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        }else if (id == R.id.nav_about) {

            Fragment frag=new About();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        }else if (id == R.id.nav_logout) {

            AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
            b.setTitle("Logout");
            b.setMessage("Are You sure to Logout");

            b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences preferences =getSharedPreferences("mypress", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.commit();
                    finish();
                }
            });
            b.show();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.attendance)
        {
            Fragment frag=new Attendance();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        }

        else if(view.getId() == R.id.timetable)



        {
            intent=new Intent(MainActivity.this,Timetable2.class);
            intent.putExtra("ftname",profilename);
            startActivity(intent);

          /*  Fragment frag=new Time_Table();
            Bundle args = new Bundle();
            args.putString("idt1",profilename);
            frag.setArguments(args);

            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();
*/
        }

        else if(view.getId() == R.id.marks)
        {
            Fragment frag=new Marks();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        }
        else if(view.getId() == R.id.view_student)
        {
            Fragment frag=new View_Students();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        }
        else if(view.getId() == R.id.academic_Calendar)
        {
            Fragment frag=new Academic_calendar();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        }
        else if(view.getId() == R.id.creative_cell)
        {
            Fragment frag=new Creative_Cell();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        }
        else if(view.getId() == R.id.lessonplan)
        {
            Fragment frag=new Lesson_plan();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        }
        else if(view.getId() == R.id.about)
        {
            Fragment frag=new About();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();

        }
        else if(view.getId() == R.id.studentgrievance)
        {
            Fragment frag=new Student_Grievance();
            getSupportFragmentManager().beginTransaction().add(new Dashboard(),"Dashboard").addToBackStack("Dashboard").replace(R.id.frame_layout,frag).commit();
        }

    }
}
