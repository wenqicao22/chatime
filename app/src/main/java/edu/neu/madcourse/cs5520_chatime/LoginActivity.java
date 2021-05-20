package edu.neu.madcourse.cs5520_chatime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button mLoginBtn;
    TextView mSignUpBtn;
    EditText mEmailEDT;
    EditText mPasswordEDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mLoginBtn = findViewById(R.id.login_btn);
        mSignUpBtn = findViewById(R.id.login_signup_btn);
        mEmailEDT = findViewById(R.id.login_email);
        mPasswordEDT = findViewById(R.id.login_password);


        //login button
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = mEmailEDT.getText().toString();
                String passwordString = mPasswordEDT.getText().toString();
                System.out.println("email:"+ emailString + " password:" + passwordString);

                //check if either is empty and process auth in firebase
            }
        });


        //sign up button
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(it);
                //add animation
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }
}
