package com.example.umore;

public class quizItem {
    String time;
    int score;

    quizItem(String Time, int Score){
        time = Time;
        score = Score;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore(){
        return score;
    }
}
