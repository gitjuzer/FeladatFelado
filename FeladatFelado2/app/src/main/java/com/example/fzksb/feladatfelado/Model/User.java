package com.example.fzksb.feladatfelado.Model;

public abstract class User {
    String username;
    String password;
    public String Username(){
        return username;
    }

    public Boolean CheckPwd(String password){
        return this.password == password;
    }
}
