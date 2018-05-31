package com.example.fzksb.feladatfelado.Model;

public class Exam  {
    int id;
    int teacher;
    int subject;

    public Exam(){};
    public Exam(int teacher, int subject) {
        this.teacher = teacher;
        this.subject = subject;
    }
    public Exam(int id, int teacher, int subject) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }
}
