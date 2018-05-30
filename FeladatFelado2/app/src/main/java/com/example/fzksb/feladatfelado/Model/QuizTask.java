package com.example.fzksb.feladatfelado.Model;

public class QuizTask {
    int id;
    int exam;
    String question;
    String aanwser;
    String banwser;
    String canwser;
    String danwser;
    boolean moreAvailable;
    int number;

    public QuizTask(){};
    public QuizTask(int exam, String question, String aanwser, String banwser, boolean moreAvailable, int number) {
        this.exam = exam;
        this.question = question;
        this.aanwser = aanwser;
        this.banwser = banwser;
        this.moreAvailable = moreAvailable;
        this.number = number;
    }
    public QuizTask(int exam, String question, String aanwser, String banwser, String canwser, boolean moreAvailable, int number) {
        this.exam = exam;
        this.question = question;
        this.aanwser = aanwser;
        this.banwser = banwser;
        this.canwser = canwser;
        this.moreAvailable = moreAvailable;
        this.number = number;
    }
    public QuizTask(int exam, String question, String aanwser, String banwser, String canwser, String danwser, boolean moreAvailable, int number) {
        this.exam = exam;
        this.question = question;
        this.aanwser = aanwser;
        this.banwser = banwser;
        this.canwser = canwser;
        this.danwser = danwser;
        this.moreAvailable = moreAvailable;
        this.number = number;
    }
    public QuizTask(int id, int exam, String question, String aanwser, String banwser, boolean moreAvailable, int number) {
        this.id = id;
        this.exam = exam;
        this.question = question;
        this.aanwser = aanwser;
        this.banwser = banwser;
        this.moreAvailable = moreAvailable;
        this.number = number;
    }
    public QuizTask(int id, int exam, String question, String aanwser, String banwser, String canwser, boolean moreAvailable, int number) {
        this.id = id;
        this.exam = exam;
        this.question = question;
        this.aanwser = aanwser;
        this.banwser = banwser;
        this.canwser = canwser;
        this.moreAvailable = moreAvailable;
        this.number = number;
    }
    public QuizTask(int id, int exam, String question, String aanwser, String banwser, String canwser, String danwser, boolean moreAvailable, int number) {
        this.id = id;
        this.exam = exam;
        this.question = question;
        this.aanwser = aanwser;
        this.banwser = banwser;
        this.canwser = canwser;
        this.danwser = danwser;
        this.moreAvailable = moreAvailable;
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

    public String getAanwser() {
        return aanwser;
    }

    public void setAanwser(String aanwser) {
        this.aanwser = aanwser;
    }

    public String getBanwser() {
        return banwser;
    }

    public void setBanwser(String banwser) {
        this.banwser = banwser;
    }

    public String getCanwser() {
        return canwser;
    }

    public void setCanwser(String canwser) {
        this.canwser = canwser;
    }

    public String getDanwser() {
        return danwser;
    }

    public void setDanwser(String danwser) {
        this.danwser = danwser;
    }

    public boolean isMoreAvailable() {
        return moreAvailable;
    }

    public void setMoreAvailable(boolean moreAvailable) {
        this.moreAvailable = moreAvailable;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
