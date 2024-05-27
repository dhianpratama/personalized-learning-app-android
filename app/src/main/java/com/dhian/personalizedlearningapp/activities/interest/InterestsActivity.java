package com.dhian.personalizedlearningapp.activities.interest;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.dhian.personalizedlearningapp.R;

public class InterestsActivity extends AppCompatActivity {
    private String selectedInterest;
    private InterestDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);
        dataSource = new InterestDataSource(this);
        dataSource.open();
    }

    public void onButtonClick(View view) {
        selectedInterest = ((AppCompatButton) view).getText().toString();
    }

    public void onNextButtonClick(View view) {
        if (selectedInterest != null) {
            long result = dataSource.addInterest(selectedInterest);

            if (result != -1) {
                Toast.makeText(this, "Interests successfully added", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please select an interest", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }

}
