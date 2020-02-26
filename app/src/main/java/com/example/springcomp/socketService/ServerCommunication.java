package com.example.springcomp.socketService;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerCommunication {

    private static final OkHttpClient client = new OkHttpClient();
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

    public static HashMap getResponseBody(String urlString, String formdata) throws Exception{
        System.out.println("connecting: "+urlString);
        HashMap returnHash = new HashMap();
        Request request = new Request.Builder()
                    .url(urlString)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    //System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    returnHash.put(responseHeaders.name(i),responseHeaders.value(i));
                }
                //System.out.println(response.body().string());
                returnHash.put("response",response.body().string());
            }
            return returnHash;
    }

    public static HashMap makePost(String urlString,String formData) throws Exception{
        HashMap hashReturn = new HashMap();
        Request request = new Request.Builder()
                .url(urlString)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, formData))
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            System.out.println("Post Response:" + response.body().string());
            hashReturn.put("response",response.body().string());
        }
        return hashReturn;
    }
    /*public static HashMap makePost(String urlString, String formdata){
        HttpURLConnection connection = null;
        try{
            System.out.println(urlString);
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length",Integer.toString(formdata.getBytes().length));
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            System.out.println("Send Data");
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(formdata);
            out.flush();
            out.close();
            System.out.println("Get data");
            InputStream in = connection.getInputStream();
            BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
            String l = null;
            StringBuffer response = new StringBuffer();
            System.out.println("Server::");
            while((l = inReader.readLine()) != null) {
                response.append(l);
                System.out.println(l);
                response.append('\r');
            }
            inReader.close();
            HashMap lr = new HashMap<String,String>();
            lr.put("response",response.toString());
            lr.put("responseCode",Integer.valueOf(connection.getResponseCode()));
            System.out.println("makePost Stonks");
            return lr;
        }catch (Exception e){
            System.out.println("makePost Untonks");
            System.err.println(e);
        }finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }*/
}
