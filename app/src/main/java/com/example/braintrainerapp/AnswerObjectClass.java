package com.example.braintrainerapp;

public class AnswerObjectClass {

    private int answerInt;
    private String answerString;

    public AnswerObjectClass(int answerInt, String answerString) {
        this.answerInt = answerInt;
        this.answerString = answerString;
    }

    public int getAnswerInt() {
        return answerInt;
    }

    public String getAnswerString() {
        return answerString;
    }
}
