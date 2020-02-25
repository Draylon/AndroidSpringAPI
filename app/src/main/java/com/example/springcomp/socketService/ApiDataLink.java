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

    static{
        localData = LocalDataRepo.readLocal("data.txt");
    }

    public static void setUserData(String u,String pw){
        localData.setEmail(u);
        localData.setPassword(pw);
        LocalDataRepo.saveLocal(localData,"data.txt");
    }
    public static void setUserData(String name, String phone, String email, String pword, String address, UserTypeEnum userType){
        localData.setAddress(address);
        localData.setEmail(email);
        localData.setName(name);
        localData.setPhone(phone);
        localData.setPassword(pword);
        localData.setUserType(userType);
        LocalDataRepo.saveLocal(localData,"data.txt");
    }


    public static HashMap<String, String> attemptLogin() {
        String link = "http://" + ApiServerLink.getServerIP() + ":" + ApiServerLink.getServerPort() + ApiServerLink.MAIN_PATH + ApiServerLink.USER_LINK + ApiServerLink.USER_LOGIN;
        Gson g = new Gson();
        HashMap<String,String> serverResponse = ServerCommunication.makePost(link, g.toJson(new UserLoginDTO().setEmail(localData.getEmail()).setPassword(localData.getPassword())));
        return serverResponse;
    }

    public static HashMap<String, String> attemptSignup(){
        String link = "http://"+ApiServerLink.getServerIP()+":"+ApiServerLink.getServerPort()+ApiServerLink.MAIN_PATH + ApiServerLink.USER_LINK;
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
}
