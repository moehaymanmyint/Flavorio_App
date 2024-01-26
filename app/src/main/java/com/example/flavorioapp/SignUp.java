package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText username, email, password, confirmPass;
    Button signUpBtn;
    DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPass = (EditText) findViewById(R.id.confirmPass);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);

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
                                Intent intent = new Intent(getApplicationContext(), RecipeList.class);
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