package com.example.fzksb.feladatfelado.Database;

public class User {
    public static final String TABLE_NAME = "users";

    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USERTYPE = "usertype";

    private int id;
    private String username;
    private String password;
    private String usertype;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + USERNAME + " VARCHAR(250) UNIQUE,"
                    + PASSWORD + " STRING,"
                    + USERTYPE + " STRING"
                    + ")";

    public User() {
    }
    public User(int id, String username, String password, String usertype) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
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
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
