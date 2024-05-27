package com.dhian.personalizedlearningapp.activities.generatetask;

import java.util.List;

public class Question {
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;

    public Question() {}

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getCorrectAnswer()
    {
        return correct_answer;
    }

    public void setCorrectAnswer(String correctAnswer)
    {
        this.correct_answer = correctAnswer;
    }

    public List<String> getIncorrectAnswers()
    {
        return incorrect_answers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers)
    {
        this.incorrect_answers = incorrect_answers;
    }
}
