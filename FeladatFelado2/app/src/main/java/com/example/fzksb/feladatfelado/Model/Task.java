package com.example.fzksb.feladatfelado.Model;

import java.util.ArrayList;

public abstract class Task {
    protected int exam;
    protected int score;
    protected int maxscore;
    public int getMaxScore(){
        return maxscore;
    }
    public abstract int CheckAnswer();
}

class ChoseOne extends Task{

    ArrayList<String> answers;
    int rightAnswer;
    public int answer;

    public ChoseOne(int exam, ArrayList<String> answers, int rightAnswer){
        this.exam = exam;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    @Override
    public int CheckAnswer() {

        int point = (answer == rightAnswer)?1:0;
        return point;
    }
}

class ChoseMore extends Task{
    ArrayList<String> answers;



    ArrayList<Integer> rightAnswers;

    public ArrayList<Integer> givenAnswers;

    public ChoseMore(int exam, ArrayList<String> answers, ArrayList<Integer> rightAnswers){
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
        CheckAnswer();
    }

    private ArrayList<String> keywords;

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public ShortAnswer(int exam, ArrayList<String> keywords){
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
