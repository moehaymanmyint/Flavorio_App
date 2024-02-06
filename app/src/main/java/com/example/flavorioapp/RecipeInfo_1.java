package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class RecipeInfo_1 extends AppCompatActivity {
    WebView webView;
    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info1);

        webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/recipeinfo1.html");

        webView1 = findViewById(R.id.webView1);
        webView1.loadUrl("file:///android_asset/coconut_recipe.html");
    }
}