package com.dhian.personalizedlearningapp.activities.result;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dhian.personalizedlearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    RecyclerView resultsRecyclerView;
    ResultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ArrayList<String> selectedAnswers = getIntent().getStringArrayListExtra("selectedAnswers");
        ArrayList<String> correctAnswers = getIntent().getStringArrayListExtra("correctAnswers");

        List<Result> results = new ArrayList<>();
        for (int i = 0; i < selectedAnswers.size(); i++) {
            String selectedAnswer = selectedAnswers.get(i);
            String correctAnswer = correctAnswers.get(i);
            boolean isCorrect = selectedAnswer.equals(correctAnswer);
            String questionNumber = "Question " + (i + 1);
            results.add(new Result(questionNumber, selectedAnswer, correctAnswer, isCorrect));
        }

        resultsRecyclerView = findViewById(R.id.resultsRecyclerView);
        adapter = new ResultsAdapter(results);
        resultsRecyclerView.setAdapter(adapter);
        resultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

