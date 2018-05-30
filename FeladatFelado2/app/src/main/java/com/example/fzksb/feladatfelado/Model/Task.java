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
        return 0;
    }
}

class ChoseMore extends Task{
    ArrayList<String> answers;
    ArrayList<Integer> rightAnswers;

    public ArrayList<Integer> givenAnswers;

    @Override
    public int CheckAnswer() {
        return 0;
    }
}

class ShortAnswer extends Task{
    public String Answer;
    ArrayList<String> keywords;

    @Override
    public int CheckAnswer() {
        return 0;
    }
}
