package com.dhian.personalizedlearningapp.activities.result;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhian.personalizedlearningapp.R;

import java.util.List;

// ResultsAdapter.java
public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder> {
    private List<String> selectedAnswers;
    private List<Result> results;

    public ResultsAdapter(List<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new ResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsViewHolder holder, int position) {
        Result result = results.get(position);
        holder.textViewQuestionNumber.setText("Question " + (position + 1));
        holder.textViewYourAnswer.setText(result.getSelectedAnswer());
        holder.textViewCorrectAnswer.setText(result.getCorrectAnswer());
        holder.textViewResult.setText(result.isCorrect() ? "Correct" : "Wrong");
        holder.textViewResult.setTextColor(result.isCorrect() ? Color.GREEN : Color.RED);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class ResultsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewQuestionNumber;
        TextView textViewYourAnswer;
        TextView textViewCorrectAnswer;
        TextView textViewResult;

        ResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewQuestionNumber = itemView.findViewById(R.id.textViewQuestionNumber);
            textViewYourAnswer = itemView.findViewById(R.id.textViewYourAnswer);
            textViewCorrectAnswer = itemView.findViewById(R.id.textViewCorrectAnswer);
            textViewResult = itemView.findViewById(R.id.textViewResult);
        }
    }
}

