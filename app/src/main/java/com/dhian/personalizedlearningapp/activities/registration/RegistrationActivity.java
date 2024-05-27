package com.dhian.personalizedlearningapp.activities.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.dhian.personalizedlearningapp.activities.interest.InterestsActivity;
import com.dhian.personalizedlearningapp.R;

public class RegistrationActivity extends AppCompatActivity{
    Button buttonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        buttonCreateAccount = findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, InterestsActivity.class);
                startActivity(intent);
            }
        });
    }
}
