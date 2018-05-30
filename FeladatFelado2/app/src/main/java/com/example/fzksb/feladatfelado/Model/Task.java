package com.example.fzksb.feladatfelado.Model;

import java.util.ArrayList;

public abstract class Task {
    public int score;
    int maxscore;
    public int getMaxScore(){
        return maxscore;
    }
    public abstract int CheckAnswer();
}

class ChoseOne extends Task{
    ArrayList<String> answers;
    int rightAnswer;
    public int answer;

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
    public String Answer;
    ArrayList<String> keywords;

    @Override
    public int CheckAnswer() {
        int point = 0;
        for(int i = 0; i < keywords.size(); i++){
            if(Answer.contains(keywords.get(i)))
                point++;
        }
        return point;
    }
}
