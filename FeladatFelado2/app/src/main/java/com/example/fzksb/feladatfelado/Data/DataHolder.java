package com.example.fzksb.feladatfelado.Data;

import com.example.fzksb.feladatfelado.Helper.DatabaseHelper;
import com.example.fzksb.feladatfelado.Model.Exam;
import com.example.fzksb.feladatfelado.Model.Grade;
import com.example.fzksb.feladatfelado.Model.QuizTask;
import com.example.fzksb.feladatfelado.Model.Task;
import com.example.fzksb.feladatfelado.Model.User;

import java.util.List;

public class DataHolder {

    private static DatabaseHelper dataSource;

    public void setDataSource(DatabaseHelper dataSource) {
        DataHolder.dataSource = dataSource;
    }

    private static User user;

    public boolean CheckUser(User user){
        List<User> tmpUsr = dataSource.getAllUser();
        for(int i = 0; i < tmpUsr.size(); i++){
            if(tmpUsr.get(i).getUsername() == user.getUsername()){
                if(tmpUsr.get(i).getPassword() == user.getPassword()){
                    this.user = user;
                    return true;
                }else
                    return false;
            }
        }
        return false;
    }

    public User getUser(){
        return user;
    }

    private static List<QuizTask> tasks;

    private void setTasks(){
        this.tasks = dataSource.getAllQuizTask();
    }

    private static List<Exam> exams;

    private void setExams(){
        this.exams = dataSource.getAllExams();
    }

    public List<Exam> getExams(){
        return exams;
    }

    public void addExam(List<QuizTask> tasks, Exam exam){
        for (int i = 0; i < tasks.size(); i++){
            this.tasks.add(tasks.get(i));
            dataSource.deleteQuizTask(tasks.get(i));
        }
        exams.add(exam);
        dataSource.createExam(exam);
    }

    private static List<Grade> grades;

}
