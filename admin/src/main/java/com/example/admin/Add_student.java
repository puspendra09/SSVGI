package com.example.admin;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;


public class Add_student extends Fragment implements RadioGroup.OnCheckedChangeListener  {

    Button b1,b2;
    EditText et1,et2,et3,et4,et5,et6,et7;
    Spinner sp1,sp2,sp3;
    Intent intent;
    RadioGroup radioGroup;
    String gender;

    public Add_student() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_add_student, container, false);
        b1=v.findViewById(R.id.btn_addstudent);
        b2=v.findViewById(R.id.btn_cancelstudent);
        et1=v.findViewById(R.id.reg_studentname);
        et2=v.findViewById(R.id.reg_fathername);
        et3=v.findViewById(R.id.reg_mothername);
        et4=v.findViewById(R.id.reg_dateofbirth);
        et5=v.findViewById(R.id.reg_mobileno);
        et6=v.findViewById(R.id.reg_emailid);
        et7=v.findViewById(R.id.reg_address);
        sp1=v.findViewById(R.id.reg_coure);
        sp2=v.findViewById(R.id.reg_department);
        sp3=v.findViewById(R.id.reg_batch);
        radioGroup =v.findViewById(R.id.radioSex);
        radioGroup.setOnCheckedChangeListener(this);


        et4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                final int mYear = c.get(Calendar.YEAR);
                final int mMonth = c.get(Calendar.MONTH);
                final int mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                et4.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        addListenerOnButton();


       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               intent=new Intent(getActivity().getApplication(),MainActivity.class);
               startActivity(intent);
               getActivity().finish();
           }
       });

        return v;

    }

    private void addListenerOnButton() {

        radioGroup.setOnCheckedChangeListener(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String course = sp1.getSelectedItem().toString();
                final String department = sp2.getSelectedItem().toString();
                final String batch = sp3.getSelectedItem().toString();

                String name=et1.getText().toString();
                String father=et2.getText().toString();
                String mother=et3.getText().toString();
                String dateofbirth=et4.getText().toString();
                String mobile=et5.getText().toString();
                String email=et6.getText().toString();
                String address=et7.getText().toString();

                if (TextUtils.isEmpty(name)){
                    et1.setError("Student Name blank");
                    return;

                }else if (TextUtils.isEmpty(father)){
                    et2.setError("Father Name blank");
                    return;
                }else if (TextUtils.isEmpty(mother)){
                    et3.setError("Mother Name Blank");
                    return;
                }else if (TextUtils.isEmpty(gender)){
                    Toast.makeText(getActivity().getApplication(), "Gender Not selected", Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(dateofbirth)){
                    et4.setError("Date of Birth blank");
                    return;
                }else if (TextUtils.isEmpty(mobile)){
                    et5.setError("Mobile No blank");
                    return;
                }else if (TextUtils.isEmpty(email)){
                    et6.setError("Email Id blank");
                    return;
                }else if (TextUtils.isEmpty(address)){
                    et7.setError("Address blank");
                    return;
                }else {

                }

                intent=new Intent(getActivity().getApplication(),Confirm_Student_reg.class);
                intent.putExtra("sStudent_Name",et1.getText().toString());
                intent.putExtra("sFather_Name", et2.getText().toString());
                intent.putExtra("sMother_Name",et3.getText().toString());
                intent.putExtra("sDateofbirth",et4.getText().toString());
                intent.putExtra("sMobile_no",et5.getText().toString());
                intent.putExtra("sEmail_no",et6.getText().toString());
                intent.putExtra("sAddress",et7.getText().toString());
                intent.putExtra("sGender",gender);
                intent.putExtra("sCourse",course);
                intent.putExtra("sDepartment",department);
                intent.putExtra("sBatch",batch);
                startActivity(intent);


            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.radioFemale:
                gender="Female";
                break;

            case R.id.radioMale:
                gender="Male";
                break;
        }
    }
}
