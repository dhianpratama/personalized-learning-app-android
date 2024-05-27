package com.dhian.personalizedlearningapp.activities.generatetask;
import java.util.List;

public class QuestionApiResponse {

        private List<Question> results;

        public List<Question> getResults()
        {
            return results;
        }

        public void setResults(List<Question> results)
        {
            this.results = results;
        }

}
