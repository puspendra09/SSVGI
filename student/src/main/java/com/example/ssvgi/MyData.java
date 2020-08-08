package com.example.ssvgi;

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

        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/student_login.jsp";
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
}