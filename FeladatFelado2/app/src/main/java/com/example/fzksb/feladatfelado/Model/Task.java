package com.example.fzksb.feladatfelado.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Task {
    protected int exam;
    public int getExam(int exam){
        return exam;
    }

    public void setExam(int exam){
        this.exam = exam;
    }

    protected int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    protected int maxscore;
    public int getMaxScore(){
        return maxscore;
    }

    public void setMaxscore(int maxscore) {
        this.maxscore = maxscore;
    }

    public abstract int CheckAnswer();
}

class ChoseOne extends Task{

    List<String> answers;

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    int rightAnswer;

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public int givenanswer;

    public int getGivenAnswer() {
        return givenanswer;
    }

    public void setGivenAnswer(int givenanswer) {
        this.givenanswer = givenanswer;
    }

    public ChoseOne(int exam, List<String> answers, int rightAnswer){
        this.exam = exam;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    @Override
    public int CheckAnswer() {

        int point = (givenanswer == rightAnswer)?1:0;
        return point;
    }
}

class ChoseMore extends Task{
    List<String> answers;

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers){
        this.answers = answers;
    }

    List<Integer> rightAnswers;

    public List<Integer> getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(List<Integer> rightAnswers){
        this.rightAnswers = rightAnswers;
    }

    List<Integer> givenAnswers;

    public List<Integer> getGivenAnswers() {
        return givenAnswers;
    }

    public void setGivenAnswers(List<Integer> givenAnswers){
        this.givenAnswers = givenAnswers;
    }

    public ChoseMore(int exam, List<String> answers, List<Integer> rightAnswers){
        this.exam = exam;
        this.answers = answers;
        this.rightAnswers = rightAnswers;
    }

    @Override
    public int CheckAnswer() {
        int point = 0;
        for(int i = 0; i < answers.size(); i++){
            if(rightAnswers.contains(answers.get(i)))
                point++;
        }
        return point;
    }
}

class ShortAnswer extends Task{
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private List<String> keywords;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public ShortAnswer(int exam, List<String> keywords){
        this.exam = exam;
        this.keywords = keywords;
    }



    @Override
    public int CheckAnswer() {
        int point = 0;

        for(int i = 0; i < keywords.size(); i++){
            if(answer.contains(keywords.get(i)))
                point++;
        }
        return point;
    }
}
