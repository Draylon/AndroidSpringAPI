package com.example.springcomp.socketService;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerCommunication {

    private static Socket socket;
    private static PrintWriter out;
    private static BufferedReader in;


    public static void startConnection(String address,int port) {
        try{
            socket = new Socket(address,port);
            setOut(new PrintWriter(socket.getOutputStream(),true));
            setIn(new BufferedReader(new InputStreamReader(socket.getInputStream())));
        }catch (IOException e){}
    }

    public static void receiveJSON() {

    }

    public static void sendJSON(List<String> l){
        getOut().println(new Gson().toJson(l));
    }



    public static Boolean getConnected() { return getSocket().isConnected(); }
    public static Socket getSocket() { return socket; }
    public static void setSocket(Socket socket) { ServerCommunication.socket = socket; }
    public static PrintWriter getOut() { return out; }
    public static void setOut(PrintWriter out) { ServerCommunication.out = out; }
    public static BufferedReader getIn() { return in; }
    public static void setIn(BufferedReader in) { ServerCommunication.in = in; }
}
