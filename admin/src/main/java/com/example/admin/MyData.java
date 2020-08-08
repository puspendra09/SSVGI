package com.example.admin;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MyData {

    boolean isvalid(String username, String password) {
        boolean valid = false;

        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/admin_login.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("id", CHAR_SET) + "=" + URLEncoder.encode(username, CHAR_SET);
            data += "&" + URLEncoder.encode("password", CHAR_SET) + "=" + URLEncoder.encode(password, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
            if (response.trim().equals("valid"))
                return true;
            else
                return false;
        } catch (Exception io) {
        }
        return valid;
    }

    String studentregistration(String student_id, String student_name, String father_name, String mother_name, String gender, String dateofbirth, String course, String department, String batch, String mobile_no, String email_id, String address) {
        String msg = "";
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/studentsregistration.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("id", CHAR_SET) + "=" + URLEncoder.encode(student_id, CHAR_SET);
            data += "&" + URLEncoder.encode("student_name", CHAR_SET) + "=" + URLEncoder.encode(student_name, CHAR_SET);
            data += "&" + URLEncoder.encode("father_name", CHAR_SET) + "=" + URLEncoder.encode(father_name, CHAR_SET);
            data += "&" + URLEncoder.encode("mother_name", CHAR_SET) + "=" + URLEncoder.encode(mother_name, CHAR_SET);
            data += "&" + URLEncoder.encode("gender", CHAR_SET) + "=" + URLEncoder.encode(gender, CHAR_SET);
            data += "&" + URLEncoder.encode("dateofbirth", CHAR_SET) + "=" + URLEncoder.encode(dateofbirth, CHAR_SET);
            data += "&" + URLEncoder.encode("course", CHAR_SET) + "=" + URLEncoder.encode(course, CHAR_SET);
            data += "&" + URLEncoder.encode("department", CHAR_SET) + "=" + URLEncoder.encode(department, CHAR_SET);
            data += "&" + URLEncoder.encode("batch", CHAR_SET) + "=" + URLEncoder.encode(batch, CHAR_SET);
            data += "&" + URLEncoder.encode("mobile_no", CHAR_SET) + "=" + URLEncoder.encode(mobile_no, CHAR_SET);
            data += "&" + URLEncoder.encode("email_id", CHAR_SET) + "=" + URLEncoder.encode(email_id, CHAR_SET);
            data += "&" + URLEncoder.encode("address", CHAR_SET) + "=" + URLEncoder.encode(address, CHAR_SET);
            data += "&" + URLEncoder.encode("password", CHAR_SET) + "=" + URLEncoder.encode(dateofbirth, CHAR_SET);

            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception io) {
        }
        return response;

    }

    String facultyregistration(String faculty_id, String faculty_name, String qualification, String gender, String dateofjoining, String department, String mobile_no, String email_id, String address,String password) {
        String msg = "";
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/facultyregistration.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("id", CHAR_SET) + "=" + URLEncoder.encode(faculty_id, CHAR_SET);
            data += "&" + URLEncoder.encode("faculty_name", CHAR_SET) + "=" + URLEncoder.encode(faculty_name, CHAR_SET);
            data += "&" + URLEncoder.encode("qualification", CHAR_SET) + "=" + URLEncoder.encode(qualification, CHAR_SET);
            data += "&" + URLEncoder.encode("gender", CHAR_SET) + "=" + URLEncoder.encode(gender, CHAR_SET);
            data += "&" + URLEncoder.encode("dateofjoining", CHAR_SET) + "=" + URLEncoder.encode(dateofjoining, CHAR_SET);
            data += "&" + URLEncoder.encode("department", CHAR_SET) + "=" + URLEncoder.encode(department, CHAR_SET);
            data += "&" + URLEncoder.encode("mobile_no", CHAR_SET) + "=" + URLEncoder.encode(mobile_no, CHAR_SET);
            data += "&" + URLEncoder.encode("email_id", CHAR_SET) + "=" + URLEncoder.encode(email_id, CHAR_SET);
            data += "&" + URLEncoder.encode("address", CHAR_SET) + "=" + URLEncoder.encode(address, CHAR_SET);
            data += "&" + URLEncoder.encode("password", CHAR_SET) + "=" + URLEncoder.encode(password, CHAR_SET);

            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
                output.close();
            }
        } catch (Exception io) {
        }
        return response;

    }

    public String studentDisplay() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/studentsDisplay.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }

    public String studentDisplayID() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/studentsDisplayID.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }

    boolean studentdetailvalid(String id) {
        boolean valid = false;

        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/slistvalid.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("id", CHAR_SET) + "=" + URLEncoder.encode(id, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
            if (response.trim().equals("valid"))
                return true;
            else
                return false;
        } catch (Exception io) {
        }
        return valid;
    }

    boolean facultydetailvalid(String id) {
        boolean valid = false;

        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/flistvalid.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("id", CHAR_SET) + "=" + URLEncoder.encode(id, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
            if (response.trim().equals("valid"))
                return true;
            else
                return false;
        } catch (Exception io) {
        }
        return valid;
    }


    public String studentdetail(String id) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/studentdetail.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("id", CHAR_SET) + "=" + URLEncoder.encode(id, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }


    public String facultydetail(String id) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/facultydetail.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("id", CHAR_SET) + "=" + URLEncoder.encode(id, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }


    public String facultyDisplay() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/facultyDisplay.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }

    public String facultyDisplayID() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/facultyDisplayID.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }


    String changepassword(String student_id, String password) {
        String msg = "";
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/ChangePassword.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("id", CHAR_SET) + "=" + URLEncoder.encode(student_id, CHAR_SET);
            data += "&" + URLEncoder.encode("password", CHAR_SET) + "=" + URLEncoder.encode(password, CHAR_SET);


            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception io) {
        }
        return response;

    }


    String addCalendar(String date, String event) {
        String msg = "";
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/addCalendar.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("date", CHAR_SET) + "=" + URLEncoder.encode(date, CHAR_SET);
            data += "&" + URLEncoder.encode("event", CHAR_SET) + "=" + URLEncoder.encode(event, CHAR_SET);

            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception io) {
        }
        return response;
    }

    public String showevent(String date) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/showCalendarEvent.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("date", CHAR_SET) + "=" + URLEncoder.encode(date, CHAR_SET);
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }


    String addTimetable(String facultyid1, String course1, String department1, String batch1,String day1, String lectureno, String tsubject) {
        String msg = "";
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/addtimetable.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("faculty_id", CHAR_SET) + "=" + URLEncoder.encode(facultyid1, CHAR_SET);
            data += "&" + URLEncoder.encode("course", CHAR_SET) + "=" + URLEncoder.encode(course1, CHAR_SET);
            data += "&" + URLEncoder.encode("department", CHAR_SET) + "=" + URLEncoder.encode(department1, CHAR_SET);
            data += "&" + URLEncoder.encode("batch", CHAR_SET) + "=" + URLEncoder.encode(batch1, CHAR_SET);
            data += "&" + URLEncoder.encode("day1", CHAR_SET) + "=" + URLEncoder.encode(day1, CHAR_SET);
            data += "&" + URLEncoder.encode("lecture_no", CHAR_SET) + "=" + URLEncoder.encode(lectureno, CHAR_SET);
            data += "&" + URLEncoder.encode("tsubject", CHAR_SET) + "=" + URLEncoder.encode(tsubject, CHAR_SET);

            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
            output.close();
        } catch (Exception io) {
        }
        return response;
    }

    public String showtimetablelistTues() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/tFacultylistTuesday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }
    public String showtimetablelistWed() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/tFacultylistWednesday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }
    public String showtimetablelistThrus() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/tFacultylistThursday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }
    public String showtimetablelistFri() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/tFacultylistFriday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }
    public String showtimetablelistSat() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/tFacultylistSaturday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }
    public String showtimetablelistMon() {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/tFacultylistMonday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = "";
            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }
    public String tfacultydetail(String tfdetail) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/tfacultydetail.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("tfacultyid", CHAR_SET) + "=" + URLEncoder.encode(tfdetail, CHAR_SET);

            URLConnection connection = new URL(SERVER_URL).openConnection();
            connection.setDoOutput(true); // This means POST method to be used
            connection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            output = null;
            output = connection.getOutputStream();
            output.write(data.getBytes(CHAR_SET));
            output.flush();
            output.close();
//------------------------------------------------------ END: PREPARE CONNETION AND REQUEST --------------------------------- //
            InputStream responseStream = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET));
            String line = null;
            while ((line = rd.readLine()) != null) // Read the response line-by-line from the bufferedReader
            {
                response += line;
            }
        } catch (Exception e) {
        }
        return response;
    }
}