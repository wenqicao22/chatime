package edu.neu.madcourse.cs5520_chatime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.neu.madcourse.cs5520_chatime.Fragments.HomeFragment;

public class ProfileActivity extends AppCompatActivity {
    TextView username, email;
    ImageView userImage;
    Button logOutBtn, editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = findViewById(R.id.user_name);
        email = findViewById(R.id.user_email);
        userImage = findViewById(R.id.user_image);
        logOutBtn = findViewById(R.id.logout_btn);
        editBtn = findViewById(R.id.user_edit_btn);

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Handle Logout Activity
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Handle User Profile Edit Activity
            }
        });

    }
}