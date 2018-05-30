package com.example.fzksb.feladatfelado.Model;

public class WriteTask {
    int id;
    int exam;
    String question;
    int number;

    public WriteTask(){};
    public WriteTask(int exam, String question, int number) {
        this.exam = exam;
        this.question = question;
        this.number = number;
    }
    public WriteTask(int id, int exam, String question, int number) {
        this.id = id;
        this.exam = exam;
        this.question = question;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
