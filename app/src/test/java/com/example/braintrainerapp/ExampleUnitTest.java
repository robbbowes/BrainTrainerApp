package com.example.braintrainerapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends MainActivity{
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void answerInt_additionIsCorrect() {
        int operatorIndex = 0; // +
        AnswerObjectClass answerObject = generateRandomAnswer(17, 32, operatorIndex);
        assertEquals(49, answerObject.getAnswerInt());
    }

    @Test
    public void answerInt_subtractionIsCorrect() {
        int operatorIndex = 1; // -
        AnswerObjectClass answerObject = generateRandomAnswer(27, 50, operatorIndex);
        assertEquals(-23, answerObject.getAnswerInt());
    }

    @Test
    public void answerString_additionIsCorrect() {
        int operatorIndex = 0; // +
        AnswerObjectClass answerObject = generateRandomAnswer(13, 38, operatorIndex);
        assertEquals("13 + 38 ?", answerObject.getAnswerString());
    }

    @Test
    public void answerString_subtractionIsCorrect() {
        int operatorIndex = 1; // 0

        AnswerObjectClass answerObject = generateRandomAnswer(43, 20, operatorIndex);
        assertEquals("43 - 20 ?", answerObject.getAnswerString());
    }
}