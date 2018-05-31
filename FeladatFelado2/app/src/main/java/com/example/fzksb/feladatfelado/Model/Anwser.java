package com.example.fzksb.feladatfelado.Model;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.fzksb.feladatfelado.Helper.DatabaseHelper;
import com.example.fzksb.feladatfelado.Interfaces.IAnwser;

public class Anwser {
    int id;
    String anwser;
    int writeTaskId;

    public Anwser(){};
    public Anwser(String anwser, int writeTaskId) {
        this.anwser = anwser;
        this.writeTaskId = writeTaskId;
    }
    public Anwser(int id, String anwser, int writeTaskId) {
        this.id = id;
        this.anwser = anwser;
        this.writeTaskId = writeTaskId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnwser() {
        return anwser;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }

    public int getWriteTaskId() {
        return writeTaskId;
    }

    public void setWriteTaskId(int writeTaskId) {
        this.writeTaskId = writeTaskId;
    }
}
