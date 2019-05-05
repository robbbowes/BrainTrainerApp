package com.example.braintrainerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int number1 = generateRandomNumber(50) + 1;
        int number2 = generateRandomNumber(50) + 1;
        int operator = generateRandomNumber(2);

        AnswerObjectClass answerObject = generateRandomAnswer(number1, number2, operator);

        TextView questionTextView = findViewById(R.id.question);
        questionTextView.setText(answerObject.getAnswerString());
    }

    //returns random number from 0 to max
    private int generateRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    protected AnswerObjectClass generateRandomAnswer(int number1, int number2, int operator) {
        int answerInt;
        String answerString;
        if (operator == 0) {
            answerInt = number1 + number2;
            answerString = number1 + " + " + number2 + " ?";
        } else {
            answerInt = number1 - number2;
            answerString = number1 + " - " + number2 + " ?";
        }
        return new AnswerObjectClass(answerInt, answerString);
    }

    public void reload(View view) {
        int number1 = generateRandomNumber(50) + 1;
        int number2 = generateRandomNumber(50) + 1;
        int operator = generateRandomNumber(2);

        AnswerObjectClass answerObject = generateRandomAnswer(number1, number2, operator);

        TextView questionTextView = findViewById(R.id.question);
        questionTextView.setText(answerObject.getAnswerString());
    }

    public void createAndDisplayQuestion() {
        int number1 = generateRandomNumber(50) + 1;
        int number2 = generateRandomNumber(50) + 1;
        int operator = generateRandomNumber(2);

        AnswerObjectClass answerObject = generateRandomAnswer(number1, number2, operator);

        TextView questionTextView = findViewById(R.id.question);
        questionTextView.setText(answerObject.getAnswerString());

        List<TextView> answerTextViews = new ArrayList<>(asList(
                (TextView) findViewById(R.id.answer1),
                (TextView) findViewById(R.id.answer2),
                (TextView) findViewById(R.id.answer3),
                (TextView) findViewById(R.id.answer4)
        ));
    }

}
