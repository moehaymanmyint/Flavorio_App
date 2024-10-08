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

public class SignUp extends AppCompatActivity {

    EditText username, email, password, confirmPass;
    Button signUpBtn;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPass = findViewById(R.id.confirmPass);
        signUpBtn = findViewById(R.id.signUpBtn);

        databaseHelper = new DatabaseHelper(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String eml = email.getText().toString();
                String passConfirm = confirmPass.getText().toString();

                if (user.equals("") || pass.equals("") || eml.equals("") || passConfirm.equals(""))
                    Toast.makeText(SignUp.this, "Please enter all fields.", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(passConfirm)){
                        Boolean checkuser = databaseHelper.checkUsername(user);
                        if (checkuser == false) {
                            Boolean insert = databaseHelper.insertData(user, pass, eml);
                            if (insert == true) {
                                Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                                // Save the username in SharedPreferences
                                SharedPreferences sharedPref = getSharedPreferences("user_details", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString("username", user);
                                editor.apply();

                                // Get the username after registration
                                String user_name = username.getText().toString();

                                // Start the Profile activity with the intent and pass the username
                                Intent intent = new Intent(getApplicationContext(), Profile.class);
                                intent.putExtra("USERNAME", user_name);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUp.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUp.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}