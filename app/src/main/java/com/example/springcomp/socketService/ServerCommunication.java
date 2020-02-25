package com.example.springcomp.socketService;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerCommunication {

    public static HashMap makePost(String urlString, String formdata){
        HttpURLConnection connection = null;
        try{
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length",Integer.toString(formdata.getBytes().length));

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(formdata);
            out.flush();
            out.close();

            InputStream in = connection.getInputStream();
            BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
            String l = null;
            StringBuffer response = new StringBuffer();
            while((l = inReader.readLine()) != null) {
                response.append(l);
                response.append('\r');
            }
            inReader.close();

            HashMap lr = new HashMap<String,String>();
            lr.put("response",response.toString());
            lr.put("responseCode",Integer.valueOf(connection.getResponseCode()));
            return lr;
        }catch (Exception e){
            System.out.println("makePost Stonks");
        }finally {
            if(connection != null) {
                connection.disconnect();
            }
        }


        return null;
    }
}
