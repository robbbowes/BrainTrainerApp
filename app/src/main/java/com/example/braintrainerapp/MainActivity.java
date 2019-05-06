package com.example.braintrainerapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    private int correctAnswerIndex;
    private int correctAnswers = 0;
    private int totalAnswered = 0;
    private boolean timeUp = false;
    private CountDownTimer countdownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newGame();
    }

    private void newGame() {
        Button newGameButton = findViewById(R.id.newGameButton);
        newGameButton.setVisibility(View.INVISIBLE);
        TextView feedbackTextView = findViewById(R.id.feedbackTextView);
        feedbackTextView.clearComposingText();
        timeUp = false;
        correctAnswers = 0;
        totalAnswered = 0;
        updateScore();
        createNewTimer();
        createAndDisplayQuestions();
    }

    private void updateScore() {
        TextView scoreTextView = findViewById(R.id.score);
        String scoreString = correctAnswers + "/" + totalAnswered;
        scoreTextView.setText(scoreString);
    }

    public void restart(View view) {
        newGame();
    }

    public void createNewTimer() {
        countdownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TextView timerTextView = findViewById(R.id.timeRemaining);
                String timeString = (millisUntilFinished / 1000) + "s";
                timerTextView.setText(timeString);
            }

            @Override
            public void onFinish() {
                timeUp = true;
                TextView feedbackTextView = findViewById(R.id.feedbackTextView);
                String timeUp = "Time's up!";
                feedbackTextView.setText(timeUp);
                TextView timerTextView = findViewById(R.id.timeRemaining);
                timerTextView.clearComposingText();
                Button newGameButton = findViewById(R.id.newGameButton);
                newGameButton.setVisibility(View.VISIBLE);
            }
        };
        countdownTimer.start();
    }

    public void checkAnswer(View view) {
        if (!timeUp) {
            String feedbackString;
            totalAnswered++;
            int tag = Integer.parseInt(view.getTag().toString());
            if (tag == correctAnswerIndex) {
                correctAnswers++;
                feedbackString = "Correct!";
            } else {
                feedbackString = "Wrong!";
            }
            TextView feedbackTextView = findViewById(R.id.feedbackTextView);
            feedbackTextView.setText(feedbackString);

            updateScore();
            createAndDisplayQuestions();
        }
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

    public void createAndDisplayQuestions() {
        int number1 = generateRandomNumber(50) + 1;
        int number2 = generateRandomNumber(50) + 1;
        int operator = generateRandomNumber(2);

        AnswerObjectClass answerObject = generateRandomAnswer(number1, number2, operator);
        TextView questionTextView = findViewById(R.id.question);
        questionTextView.setText(answerObject.getAnswerString());

        displayQuestions(answerObject);
    }

    // Renders all questions and sets the class variable as the index of the correct one
    private void displayQuestions(AnswerObjectClass correctAnswer) {
        List<TextView> answerTextViews = new ArrayList<>(asList(
                (TextView) findViewById(R.id.answer1),
                (TextView) findViewById(R.id.answer2),
                (TextView) findViewById(R.id.answer3),
                (TextView) findViewById(R.id.answer4)
        ));
        correctAnswerIndex = generateRandomNumber(answerTextViews.size());
        TextView correctAnswerTextView = answerTextViews.get(correctAnswerIndex);
        answerTextViews.remove(correctAnswerTextView);
        correctAnswerTextView.setText(String.valueOf(correctAnswer.getAnswerInt()));
        for (TextView answerTextView : answerTextViews) {
            answerTextView.setText(String.valueOf(generateRandomNumber(50) + 1));
        }
    }

}
