package org.example;

import java.util.Scanner;

class User {
    private String id;
    private String pw;

    public User(String id, String pw) {
        setId(id);
        setPw(pw);
    }
    public User(String id) {
        setId(id);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        String info = "Id: " + id + "\n";
        info += "Pw: " + pw + "\n";
        return info;
    }

}

public class login extends frame{
    public login(){

    }
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        login frame = new login();
    }
}
