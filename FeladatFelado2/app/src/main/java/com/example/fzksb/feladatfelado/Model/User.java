package com.example.fzksb.feladatfelado.Model;

import com.example.fzksb.feladatfelado.Helper.DatabaseHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String username;
    private String password;
    private String studentId = null;

    public User(){

    }

    public User(int id,String username, String password) {
        this.username = username;
        setPassword(password);
    }
    public User(int id, String username, String password, int studentId) {
        this.id = id;
        this.username = username;
        setPassword(password);
        this.studentId = String.valueOf(studentId);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
            this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = md5(password);
    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
