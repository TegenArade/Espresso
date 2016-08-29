package com.ategan.sampleespresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button guestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        userNameEditText = (EditText) findViewById(R.id.user_name_field);
        passwordEditText = (EditText) findViewById(R.id.password_field);
        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogin();
            }
        });
        guestButton = (Button) findViewById(R.id.guest_button);
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGuest();
            }
        });
    }

    private void onLogin() {
        if (ActivityUtil.hasValidValue(userNameEditText) && ActivityUtil.hasValidValue(passwordEditText)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra(Library.USER_NAME, userNameEditText.getText().toString());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.login_failed_message, Toast.LENGTH_LONG).show();
        }
    }

    private void onGuest() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
