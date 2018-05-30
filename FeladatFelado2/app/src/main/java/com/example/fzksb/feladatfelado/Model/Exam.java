package com.example.fzksb.feladatfelado.Model;

public class Exam {
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
}
