package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ButtonsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons_view);
        handleButtonClick();
    }

    private void handleButtonClick() {
        Button buttonTop = findViewById(R.id.buttonTop);
        Button buttonCenter = findViewById(R.id.buttonCenter);
        Button buttonBottom = findViewById(R.id.buttonBottom);

        View viewL1 = findViewById(R.id.viewL1);
        View viewR1 = findViewById(R.id.viewR1);
        View viewL2 = findViewById(R.id.viewL2);
        View viewR2 = findViewById(R.id.viewR2);

        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewL2.setVisibility(View.GONE);
                viewR2.setVisibility(View.GONE);
            }
        });

        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewL1.setVisibility(View.GONE);
                viewR1.setVisibility(View.GONE);
            }
        });

        buttonCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewL1.setVisibility(View.VISIBLE);
                viewR1.setVisibility(View.VISIBLE);
                viewL2.setVisibility(View.VISIBLE);
                viewR2.setVisibility(View.VISIBLE);
            }
        });
    }
}