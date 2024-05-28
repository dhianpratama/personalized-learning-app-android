package com.dhian.personalizedlearningapp.activities.interest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.dhian.personalizedlearningapp.R;
import com.dhian.personalizedlearningapp.activities.home.HomeActivity;
import com.dhian.personalizedlearningapp.activities.main.MainActivity;

import java.util.ArrayList;

public class InterestsActivity extends AppCompatActivity {
    private String selectedInterest;

    private ArrayList<String> selectedInterests;
    private InterestDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);
        this.selectedInterests = new ArrayList<String>();
        dataSource = new InterestDataSource(this);
        dataSource.open();
    }

    public void onButtonClick(View view) {
        String selectedText = ((AppCompatButton) view).getText().toString();
        boolean isExistInList = this.selectedInterests.contains(selectedText);
        if (isExistInList) {
            this.selectedInterests.remove(selectedText);
            view.setBackgroundColor(R.drawable.button_border);
        } else {
            this.selectedInterests.add(selectedText);
            view.setBackgroundColor(Color.BLUE);
        }
    }

    public void onNextButtonClick(View view) {
        if (selectedInterest != null) {
            String allInterests = String.join(", ", this.selectedInterests);
            long result = dataSource.addInterest(allInterests);

            if (result != -1) {
                Toast.makeText(this, "Interests successfully added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InterestsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
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
