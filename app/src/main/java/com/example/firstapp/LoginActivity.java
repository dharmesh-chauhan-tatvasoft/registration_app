package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText urlEditText, passwordEditText, emailEditText, credentialsEditText, tokenEditText, secretKeyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setInputData();
    }

    private void setInputData() {
        urlEditText = findViewById(R.id.urlEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        emailEditText = findViewById(R.id.emailEditText);
        credentialsEditText = findViewById(R.id.credentialsEditText);
        tokenEditText = findViewById(R.id.tokenEditText);
        secretKeyEditText = findViewById(R.id.secretKeyEditText);
    }

    public void onAuthorize(View view) {
        String url = urlEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String credential = credentialsEditText.getText().toString().trim();
        String token = tokenEditText.getText().toString().trim();
        String secretKey = secretKeyEditText.getText().toString().trim();

        if (url.isEmpty()) {
            showToast(getString((R.string.url_validation_message)));
            return;
        }

        if (password.isEmpty()) {
            showToast(getString((R.string.url_password_validation_message)));
            return;
        }

        if (email.isEmpty()) {
            showToast(getString((R.string.email_validation_message)));
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast(getString((R.string.email_validation_message_invalid)));
            return;
        }

        if (credential.isEmpty()) {
            showToast(getString((R.string.password_validation_message)));
            return;
        }

        if (token.isEmpty()) {
            showToast(getString((R.string.token_validation_message)));
            return;
        }

        if (secretKey.isEmpty()) {
            showToast(getString((R.string.secret_key_validation_message)));
            return;
        }

        Intent buttonsViewIntent = new Intent(this, ButtonsView.class);
        startActivity(buttonsViewIntent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}