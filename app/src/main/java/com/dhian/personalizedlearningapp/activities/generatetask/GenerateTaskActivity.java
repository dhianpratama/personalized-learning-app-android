package com.dhian.personalizedlearningapp.activities.generatetask;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dhian.personalizedlearningapp.R;
import com.dhian.personalizedlearningapp.activities.result.ResultsActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GenerateTaskActivity extends AppCompatActivity {
    AppCompatButton submitButton;
    TextView textViewQuestions;
    RecyclerView questionsRecyclerView;
    private QuestionsAdapter adapter;
    private LinearLayoutManager layoutManager;
    private QuestionService questionService;
    private Retrofit retrofit;
    private static List<String> selectedAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_task);

        selectedAnswers = new ArrayList<>();
        questionsRecyclerView = findViewById(R.id.questionsRecyclerView);
        submitButton = findViewById(R.id.submitButton);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        questionsRecyclerView.setLayoutManager(layoutManager);

        fetchQuestions();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Selected Answers Size", String.valueOf(selectedAnswers.size()));
                if (adapter != null) {
                    List<String> correctAnswers = adapter.getCorrectAnswers();
                    if (correctAnswers != null) {
                        Log.d("Correct Answers Size", String.valueOf(correctAnswers.size()));
                    } else {
                        Log.d("Correct Answers", "List is null");
                    }
                } else {
                    Log.d("Adapter", "Adapter is null");
                }

                Intent intent = new Intent(GenerateTaskActivity.this, ResultsActivity.class);
                intent.putStringArrayListExtra("selectedAnswers", (ArrayList<String>) selectedAnswers);
                intent.putStringArrayListExtra("correctAnswers", (ArrayList<String>) adapter.getCorrectAnswers());
                startActivity(intent);
            }
        });
    }

    public static void onAnswerClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.isChecked()) {
            String selectedAnswer = radioButton.getText().toString();
            selectedAnswers.add(selectedAnswer);
        }
    }

    public void fetchQuestions() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        questionService = retrofit.create(QuestionService.class);

        Call<QuestionApiResponse> call = questionService.getQuestions();
        call.enqueue(new Callback<QuestionApiResponse>() {
            @Override
            public void onResponse(Call<QuestionApiResponse> call, Response<QuestionApiResponse> response) {
                if (response.isSuccessful()) {
                    QuestionApiResponse questionApiResponse = response.body();
                    if (questionApiResponse != null) {
                        List<Question> questions = questionApiResponse.getResults();
                        adapter = new QuestionsAdapter(questions);
                        questionsRecyclerView.setAdapter(adapter);
                    } else {
                        textViewQuestions.setText("Response body is null.");
                    }
                } else {
                    textViewQuestions.setText("Failed to fetch questions. Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call< QuestionApiResponse> call, Throwable t) {
                textViewQuestions.setText("Failed to fetch questions. Error: " + t.getMessage());
            }
        });
    }
}

