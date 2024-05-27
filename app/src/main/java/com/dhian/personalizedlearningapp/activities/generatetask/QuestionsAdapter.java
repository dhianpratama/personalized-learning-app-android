package com.dhian.personalizedlearningapp.activities.generatetask;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dhian.personalizedlearningapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder> {

    private List<Question> questions;


    public QuestionsAdapter(List<Question> questions)
    {
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.textViewQuestionNumber.setText("Question " + (position + 1));
        holder.textViewQuestion.setText(question.getQuestion());
        holder.radioGroupAnswers.removeAllViews();
        List<String> answers = question.getIncorrectAnswers();
        answers.add(question.getCorrectAnswer());
        Collections.shuffle(answers);

        for (int i = 0; i < answers.size(); i++) {
            RadioButton radioButton = new RadioButton(holder.itemView.getContext());
            radioButton.setText(answers.get(i));
            radioButton.setTextSize(16);
            radioButton.setTextColor(Color.WHITE);
            radioButton.setOnClickListener(GenerateTaskActivity::onAnswerClicked);
            holder.radioGroupAnswers.addView(radioButton);
        }

    }

    public List<String> getCorrectAnswers() {
        List<String> correctAnswers = new ArrayList<>();
        for (Question question : questions) {
            correctAnswers.add(question.getCorrectAnswer());
        }
        return correctAnswers;
    }

    public List<String> getQuestionNumbers() {
        List<String> questionNumbers = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            questionNumbers.add("Question " + (i + 1));
        }
        return questionNumbers;
    }


    @Override
    public int getItemCount() {
        return (questions.size());
    }


    static class QuestionsViewHolder extends RecyclerView.ViewHolder{
        RadioGroup radioGroupAnswers;
        CardView cardViewQuestion;
        TextView textViewQuestionNumber;
        TextView textViewQuestion;
        RadioButton radioButtonAnswer1;


        QuestionsViewHolder(@NonNull View itemView){
            super(itemView);
            radioGroupAnswers = itemView.findViewById(R.id.radioGroupAnswers);
            cardViewQuestion = itemView.findViewById(R.id.cardViewQuestion);
            textViewQuestionNumber = itemView.findViewById(R.id.textViewQuestionNumber);
            textViewQuestion = itemView.findViewById(R.id.textViewQuestion);
            radioButtonAnswer1 = itemView.findViewById(R.id.radioButtonAnswer1);

        }
    }
}
