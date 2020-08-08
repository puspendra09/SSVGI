package com.example.ssvgifaculty;

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

        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/faculty_login.jsp";
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

    public String attendancestudent(String ncourse, String ndepartment, String nbatch) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/attendancelist.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("mcourse", CHAR_SET) + "=" + URLEncoder.encode(ncourse, CHAR_SET);
            data += "&" + URLEncoder.encode("mdepartment", CHAR_SET) + "=" + URLEncoder.encode(ndepartment, CHAR_SET);
            data += "&" + URLEncoder.encode("mbatch", CHAR_SET) + "=" + URLEncoder.encode(nbatch, CHAR_SET);

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

    public String marksstudentList(String mcourse, String mdepartment, String mbatch) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/marksStudentlist.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("course", CHAR_SET) + "=" + URLEncoder.encode(mcourse, CHAR_SET);
            data += "&" + URLEncoder.encode("department", CHAR_SET) + "=" + URLEncoder.encode(mdepartment, CHAR_SET);
            data += "&" + URLEncoder.encode("batch", CHAR_SET) + "=" + URLEncoder.encode(mbatch, CHAR_SET);

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

    public String tfacultymon(String tfmon) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/ftmonday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("tfacultyid", CHAR_SET) + "=" + URLEncoder.encode(tfmon, CHAR_SET);

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

    public String tfacultytues(String tftues) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/fttuesday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("tfacultyid", CHAR_SET) + "=" + URLEncoder.encode(tftues, CHAR_SET);

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

    public String tfacultywed(String tfwed) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/ftwednesday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("tfacultyid", CHAR_SET) + "=" + URLEncoder.encode(tfwed, CHAR_SET);

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

    public String tfacultythru(String tfthru) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/ftthrusday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("tfacultyid", CHAR_SET) + "=" + URLEncoder.encode(tfthru, CHAR_SET);

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

    public String tfacultyfri(String tffri) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/ftfriday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("tfacultyid", CHAR_SET) + "=" + URLEncoder.encode(tffri, CHAR_SET);

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

    public String tfacultysat(String tfsat) {
        final String SERVER_URL = "http://192.168.43.210:8080/ssvgi/ftsaturday.jsp";
        final String CHAR_SET = "UTF-8";
        OutputStream output = null;
        String response = "";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String data = URLEncoder.encode("tfacultyid", CHAR_SET) + "=" + URLEncoder.encode(tfsat, CHAR_SET);

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