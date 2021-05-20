package edu.neu.madcourse.cs5520_chatime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class SignUpActivity extends AppCompatActivity {
    Button mSignUpBtn;
    TextView mLoginBtn;
    EditText mUsernameET;
    EditText mEmailET;
    EditText mPasswordET;
    EditText mConfirmedPasswordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mSignUpBtn = findViewById(R.id.signup_btn);
        mLoginBtn = findViewById(R.id.signup_login_btn);
        mUsernameET = findViewById(R.id.signup_username);
        mEmailET = findViewById(R.id.signup_email);
        mPasswordET = findViewById(R.id.signup_password);
        mConfirmedPasswordET = findViewById(R.id.signup_password_confirmed);

        //sign up button
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = mUsernameET.getText().toString();
                String emailString = mEmailET.getText().toString();
                String passwordString = mPasswordET.getText().toString();
                String confirmedPasswordString = mConfirmedPasswordET.getText().toString();
                System.out.println("username:" + usernameString + " email:"+ emailString +
                        " password:" + passwordString + "confirmed: " + confirmedPasswordString);

                //check if either is empty and process auth
            }
        });

        //login button
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(it);
                //add animation for activity transition
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }


}
