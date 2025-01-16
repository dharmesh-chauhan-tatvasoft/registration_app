package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private NumberPicker agePicker;
    private EditText userNameEditText, userEmailEditText, userPasswordEditText, contactNumberEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeDataInForm();
    }

    private void initializeDataInForm() {
        agePicker = findViewById(R.id.ageNumberPicker);
        agePicker.setMaxValue(100);
        agePicker.setMinValue(18);
        agePicker.setValue(18);

        userNameEditText = findViewById(R.id.userName);
        userEmailEditText = findViewById(R.id.userEmail);
        userPasswordEditText = findViewById(R.id.userPassword);
        contactNumberEditText = findViewById(R.id.contactNumber);
        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUserInfo();
            }
        });

    }

    private void validateUserInfo() {
        String userName = userNameEditText.getText().toString().trim();
        String userEmail = userEmailEditText.getText().toString().trim();
        String userPassword = userPasswordEditText.getText().toString().trim();
        String contactNumber = contactNumberEditText.getText().toString().trim();
        int age = agePicker.getValue();

        if (userName.isEmpty()) {
            showToast(getString(R.string.username_validation_message));
            return;
        }

        if (userEmail.isEmpty()) {
            showToast(getString(R.string.email_validation_message));
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            showToast(getString(R.string.email_validation_message_invalid));
            return;
        }

        if (userPassword.isEmpty()) {
            showToast(getString(R.string.password_validation_message));
            return;
        }

        if (contactNumber.isEmpty()) {
            showToast(getString(R.string.phone_validation_message));
            return;
        }

        if (!contactNumber.matches("\\d{10}")) {
            showToast(getString(R.string.phone_validation_message_invalid));
            return;
        }

        if (age < 18 || age > 100) {
            showToast(getString(R.string.age_validation_message));
            return;
        }

        Intent loginScreen = new Intent(this, LoginActivity.class);
        startActivity(loginScreen);
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}