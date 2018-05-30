package com.example.fzksb.feladatfelado.Model;

public class Grade {
    int id;
    int grade;
    int studentId;

    public Grade() {
    }
    public Grade(int grade, int studentId) {
        this.id = id;
        this.grade = grade;
        this.studentId = studentId;
    }
    public Grade(int id, int grade, int studentId) {
        this.id = id;
        this.grade = grade;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
