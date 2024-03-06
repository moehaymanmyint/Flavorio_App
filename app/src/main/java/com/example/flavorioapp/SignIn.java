package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText username, password;
    Button signUpNow, signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signUpNow = (Button) findViewById(R.id.singUpNowBtn);
        signIn = (Button) findViewById(R.id.singInBtn);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        signUpNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(SignIn.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else if ((user.equals("ShamShiDah") && pass.equals("admin1")) || (user.equals("Razia") && pass.equals("admin2"))) {
                    Toast.makeText(SignIn.this, "Sign In with Admin Account", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignIn.this, AdminDashboard.class);
                    startActivity(intent); //For Admin
                } else {
                    Boolean checkUserPass = databaseHelper.checkUsernamePassword(user, pass);
                    if (checkUserPass == true) {
                        Toast.makeText(SignIn.this, "Sign In Successfully", Toast.LENGTH_SHORT).show();
                        // Save the username in SharedPreferences
                        SharedPreferences sharedPref = getSharedPreferences("user_details", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("username", user);
                        editor.apply();

                        Intent intent = new Intent(SignIn.this, Profile.class);
                        intent.putExtra("USERNAME", user);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignIn.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}