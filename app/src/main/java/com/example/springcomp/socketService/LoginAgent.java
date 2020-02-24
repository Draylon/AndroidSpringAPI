package com.example.springcomp.socketService;

import android.widget.Toast;
import com.example.springcomp.MainActivity;
import com.example.springcomp.socketService.ServerCommunication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LoginAgent {
    private static File file;

    private static String username;
    private static String password;
    private static Boolean logged = false;

    static{
        file = new File("login.txt");
        List<String> l = null;
        Scanner sc;
        try {
            sc = new Scanner(file);
            Boolean hasline=false;
            while (sc.hasNextLine()){
                hasline=true;
                l.add(sc.nextLine());
            }
            if(hasline){
                username=l.get(0);
                password=l.get(1);
                logged=Boolean.parseBoolean(l.get(2));
            }
        } catch (FileNotFoundException e) {

        }

        System.out.println(LoginAgent.username + " " + LoginAgent.password + " " + LoginAgent.logged);
    }

    public static void setUserData(String u,String pw){
        setUsername(u);
        setPassword(pw);
    }

    public static void attemptLogin(){
        ServerCommunication.receiveForm();
    }


    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        LoginAgent.file = file;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        LoginAgent.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        LoginAgent.password = password;
    }

    public static Boolean getLogged() {
        return logged;
    }

    public static void setLogged(Boolean logged) {
        LoginAgent.logged = logged;
    }
}
