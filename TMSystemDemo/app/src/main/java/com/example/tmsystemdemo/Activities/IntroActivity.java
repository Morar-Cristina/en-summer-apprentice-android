package com.example.tmsystemdemo.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.tmsystemdemo.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ConstraintLayout introButton = findViewById(R.id.introBtn);
        introButton.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this, MainActivity.class)));
    }
}
