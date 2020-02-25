package com.example.springcomp.socketService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ApiLinkAgent {


    private static File file;

    private static String username;
    private static String password;
    private static Boolean logged = false;
    private static Map<String,String> dataMap = new HashMap<>();

    static{
        file = new File("data.txt");
        Map<String,String> l = new HashMap<>();
        Scanner sc;
        try {
            sc = new Scanner(file);
            Boolean hasline=false;
            while (sc.hasNextLine()){
                hasline=true;
                String[] s = sc.nextLine().split("=:=");
                l.put(s[0],s[1]);
            }
            if(hasline){
                username=l.get("username");
                password=l.get("password");
                logged=Boolean.parseBoolean(l.get("logged"));
            }
        } catch (FileNotFoundException e) { }

        System.out.println(ApiLinkAgent.username + " " + ApiLinkAgent.password + " " + ApiLinkAgent.logged);
    }

    public static void setUserData(String u,String pw){
        setUsername(u);
        setPassword(pw);

    }

    public static void makeLogin(){
        String link = ApiServerLink.getServerIP()+":"+ApiServerLink.setServerPort()+ApiServerLink.MAIN_PATH + ApiServerLink.USER_QUERY_EMAIL;
        ServerCommunication.makePost();
    }



}
