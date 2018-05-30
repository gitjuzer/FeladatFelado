package com.example.fzksb.feladatfelado.Model;

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
