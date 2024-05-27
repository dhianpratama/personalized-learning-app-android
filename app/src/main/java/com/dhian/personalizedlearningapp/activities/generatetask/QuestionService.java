package com.dhian.personalizedlearningapp.activities.generatetask;

import retrofit2.Call;
import retrofit2.http.GET;

// Define a Retrofit interface for the API
public interface QuestionService {
    @GET("api.php?amount=10")
    Call<QuestionApiResponse> getQuestions();
}
