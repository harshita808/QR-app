package com.androidqr.qr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        //for back arrow
        ImageView back = (ImageView) findViewById(R.id.back_arrow);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent backIntent = new Intent(SignUpActivity.this, dashboardSignedOut.class);

                // Start the new activity
                startActivity(backIntent);
            }
        });

        Button signup = (Button) findViewById(R.id.sign_up);

        // Set a click listener on that View
        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent signupIntent = new Intent(SignUpActivity.this, dashboardSignedIn.class);

                // Start the new activity
                startActivity(signupIntent);
            }
        });
        TextView login = (TextView) findViewById(R.id.login);

        // Set a click listener on that View
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent loginIntent = new Intent(SignUpActivity.this, SignInActivity.class);

                // Start the new activity
                startActivity(loginIntent);
            }
        });
    }
}