package com.example.springcomp.socketService;

import com.example.springcomp.api.dtos.CreateUserDTO;
import com.example.springcomp.api.dtos.UserLoginDTO;
import com.example.springcomp.enums.UserTypeEnum;
import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;

public class ApiDataLink {

    private static File file;
    private static LocalDataRepo localData;
    private static File cacheDir;
    private static final String filedir = "data.txt";

    public static void init(){
        if(cacheDir == null)
            throw new NullPointerException("Cache directory missing!");
        localData = LocalDataRepo.readLocal(cacheDir,filedir);
        System.out.println(localData);
        System.out.println(localData.toString());
    }

    public static void setUserData(String u,String pw){
        localData.setEmail(u);
        localData.setPassword(pw);
        saveLocalData();
    }
    public static void setUserData(String name, String phone, String email, String pword, String address, UserTypeEnum userType){
        localData.setAddress(address);
        localData.setEmail(email);
        localData.setName(name);
        localData.setPhone(phone);
        localData.setPassword(pword);
        localData.setUserType(userType);
        saveLocalData();
    }

    public static Boolean saveLocalData(){
        return LocalDataRepo.saveLocal(localData,cacheDir,filedir);
    }


    public static HashMap attemptLogin() throws Exception{
        String link = "http://" + ApiDataLink.getLocalData().getServerIP() + ":" + ApiDataLink.getLocalData().getServerPort() + ApiServerLink.MAIN_PATH + ApiServerLink.USER_LINK + ApiServerLink.USER_LOGIN+"?email="+ApiDataLink.getLocalData().getEmail()+"&password="+ApiDataLink.getLocalData().getPassword();
        String formdata = new Gson().toJson(new UserLoginDTO().setEmail(localData.getEmail()).setPassword(localData.getPassword()));
        HashMap serverResponse = ServerCommunication.getResponseBody(link, formdata);
        return serverResponse;
    }

    public static HashMap<String, String> attemptSignup() throws Exception{
        String link = "http://"+ApiDataLink.getLocalData().getServerIP()+":"+ApiDataLink.getLocalData().getServerPort()+ApiServerLink.MAIN_PATH + ApiServerLink.USER_LINK;
        Gson g = new Gson();
        HashMap<String,String> serverResponse = ServerCommunication.makePost(link, g.toJson(new CreateUserDTO().setEmail(localData.getEmail())
                .setPword(localData.getPassword()).setAddress(localData.getAddress()).setName(localData.getName()).setPhone(localData.getPhone()).setUserType(localData.getUserType())));
        return serverResponse;
    }


    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        ApiDataLink.file = file;
    }

    public static LocalDataRepo getLocalData() {
        return localData;
    }

    public static void setLocalData(LocalDataRepo localData) {
        ApiDataLink.localData = localData;
    }

    public static File getCacheDir() {
        return cacheDir;
    }

    public static void setCacheDir(File cacheDir) {
        ApiDataLink.cacheDir = cacheDir;
    }
}
