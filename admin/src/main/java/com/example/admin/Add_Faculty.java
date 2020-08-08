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

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Add_Faculty extends Fragment implements RadioGroup.OnCheckedChangeListener {

    Button b1,b2;
    EditText et1,et2,et3,et4,et5,et6;
    Spinner sp1;
    Intent intent;
    RadioGroup radioGroup;
    String gender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_add__faculty, container, false);

        et1=v.findViewById(R.id.reg_facultyName);
        et2=v.findViewById(R.id.reg_qualification);
        et3=v.findViewById(R.id.reg_dateofjoining);
        et4=v.findViewById(R.id.reg_faculty_mobileNo);
        et5=v.findViewById(R.id.reg_faculty_emailID);
        et6=v.findViewById(R.id.reg_faculty_address);
        sp1=v.findViewById(R.id.reg_faculty_department);
        b1=v.findViewById(R.id.btn_faculty_submit);
        b2=v.findViewById(R.id.btn_faculty_cancel);

        radioGroup =v.findViewById(R.id.f_radioSex);
        radioGroup.setOnCheckedChangeListener(this);

        addListenerOnButton();

        et3.setOnClickListener(new View.OnClickListener() {

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

                                et3.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

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
                final String department = sp1.getSelectedItem().toString();
                String name=et1.getText().toString();
                String quali=et2.getText().toString();
                String dateofjoining=et3.getText().toString();
                String mobile=et4.getText().toString();
                String email=et5.getText().toString();
                String address=et6.getText().toString();

                if (TextUtils.isEmpty(name)){
                    et1.setError("Faculty Name blank");
                    return;

                }else if (TextUtils.isEmpty(gender)){
                    Toast.makeText(getActivity().getApplication(), "Gender Not selected", Toast.LENGTH_SHORT).show();
                    return;

                }else if (TextUtils.isEmpty(quali)){
                    et2.setError("Qualification blank");
                    return;
                }else if (TextUtils.isEmpty(dateofjoining)){
                    et3.setError("Date of Joining blank");
                    return;
                }else if (TextUtils.isEmpty(mobile)){
                    et4.setError("Mobile No blank");
                    return;
                }else if (TextUtils.isEmpty(email)){
                    et5.setError("Email Id blank");
                    return;
                }else if (TextUtils.isEmpty(address)){
                    et6.setError("Address blank");
                    return;
                }else {

                }


                intent=new Intent(getActivity().getApplication(),Confirm_Faculty_reg.class);
                intent.putExtra("fname",name);
                intent.putExtra("fqualification",quali);
                intent.putExtra("fdateofjoining",dateofjoining);
                intent.putExtra("fmobile_no",mobile);
                intent.putExtra("femail_id",email);
                intent.putExtra("faddress",address);
                intent.putExtra("fgender",gender);
                intent.putExtra("fdepartment",department);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.f_radioFemale:
                gender="Female";
                break;

            case R.id.f_radioMale:
                gender="Male";
                break;
        }
    }
}
