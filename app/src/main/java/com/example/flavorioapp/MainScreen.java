package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {


    //Variables
    ImageView logoImg;
    TextView appName, tagline;
    Button exploreBtn;

    //Animation
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        
        exploreBtn = findViewById(R.id.exploreBtn);

        //Hooks
        logoImg = findViewById(R.id.logoImg);
        appName = findViewById(R.id.appName);
        tagline = findViewById(R.id.tagline);

        //Animations
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set Animations on elements
        logoImg.setAnimation(sideAnim);
        appName.setAnimation(sideAnim);
        exploreBtn.setAnimation(bottomAnim);
        tagline.setAnimation(bottomAnim);

        exploreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, SignIn.class);
                startActivity(intent);
            }
        });
    }
}