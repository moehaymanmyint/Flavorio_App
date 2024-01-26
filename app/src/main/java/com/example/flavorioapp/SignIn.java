package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText username, password;
    Button signUpNow, signIn;
    DatabaseHelper databaseHelper;

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

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(SignIn.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkUserPass = databaseHelper.checkUsernamePassword(user, pass);
                        if (checkUserPass == true){
                            Toast.makeText(SignIn.this, "Sign In Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), RecipeList.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignIn.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        });
    }
}