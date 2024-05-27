package com.dhian.personalizedlearningapp.activities.result;

public class Result {
    private String questionNumber;
    private String selectedAnswer;
    private String correctAnswer;
    private boolean isCorrect;

    public Result(String questionNumber, String selectedAnswer, String correctAnswer, boolean isCorrect) {
        this.questionNumber = questionNumber;
        this.selectedAnswer = selectedAnswer;
        this.correctAnswer = correctAnswer;
        this.isCorrect = isCorrect;
    }

    public String getQuestionNumber()
    {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber)
    {
        this.questionNumber = questionNumber;
    }

    public String getSelectedAnswer()
    {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer)
    {
        this.selectedAnswer = selectedAnswer;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect()
    {
        return isCorrect;
    }

    public void setCorrect(boolean correct)
    {
        isCorrect = correct;
    }
}

