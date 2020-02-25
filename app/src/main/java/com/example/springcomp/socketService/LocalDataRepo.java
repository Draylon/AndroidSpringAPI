package com.example.springcomp.socketService;

import android.util.Base64;
import com.example.springcomp.enums.UserTypeEnum;
import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class LocalDataRepo {
    private String serverIP;
    private Integer serverPort;
    private String email;
    private String password;
    private Boolean logged = false;
    private byte[] hash;

    private Integer id;
    private String name;
    private String phone;
    private String address;
    private UserTypeEnum userType;


    public static LocalDataRepo readLocal(String filename) {
        try {
            String sc = new Scanner(new File(filename)).useDelimiter("\\Z").next();
            Gson g = new Gson();
            LocalDataRepo localData = g.fromJson(sc, LocalDataRepo.class);
            return localData;
        } catch (FileNotFoundException e) {}
        return null;
    }

    public static Boolean saveLocal(LocalDataRepo localData,String filename){
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(new Gson().toJson(localData));
            fw.close();
            return true;
        } catch (IOException e) {return false;}
    }

    public String getHash() {
        return Base64.encodeToString(hash,Base64.DEFAULT);
    }

    public LocalDataRepo setHash(String hash) {
        this.hash = Base64.encode(hash.getBytes(),Base64.DEFAULT);
        return this;
    }

    //====================GETTER_SETTER====================================
    public String getServerIP() {
        return serverIP;
    }

    public LocalDataRepo setServerIP(String serverIP) {
        this.serverIP = serverIP;
        return this;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public LocalDataRepo setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LocalDataRepo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LocalDataRepo setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getLogged() {
        return logged;
    }

    public LocalDataRepo setLogged(Boolean logged) {
        this.logged = logged;
        return this;
    }

    public String getName() {
        return name;
    }

    public LocalDataRepo setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDataRepo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public LocalDataRepo setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public LocalDataRepo setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public LocalDataRepo setUserType(UserTypeEnum userType) {
        this.userType = userType;
        return this;
    }
}
