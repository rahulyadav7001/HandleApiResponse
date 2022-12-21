package com.example.handleapiresponse.model;

public class RequestBody {
    private String cmd = "";
    private String user = "";
    private String pass = "";

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public RequestBody(String cmd, String user, String pass) {
        this.cmd = cmd;
        this.user = user;
        this.pass = pass;
    }
}
