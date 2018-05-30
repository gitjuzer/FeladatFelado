package com.example.fzksb.feladatfelado.Model;

import com.example.fzksb.feladatfelado.Model.Exam;

import java.util.ArrayList;

public class Student {
    String username;
    String password;
    public String Username(){
        return username;
    }

    public Boolean CheckPwd(String password){
        return this.password == password;
    }

    ArrayList<Exam> exams;
}
