package com.example.springcomp.socketService;

public class ApiDataRepo {
    private String serverIP;
    private Integer serverPort;
    private String username;
    private String password;
    private Boolean logged = false;


    public String getServerIP() {
        return serverIP;
    }

    public ApiDataRepo setServerIP(String serverIP) {
        this.serverIP = serverIP;
        return this;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public ApiDataRepo setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ApiDataRepo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ApiDataRepo setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getLogged() {
        return logged;
    }

    public ApiDataRepo setLogged(Boolean logged) {
        this.logged = logged;
        return this;
    }
}
