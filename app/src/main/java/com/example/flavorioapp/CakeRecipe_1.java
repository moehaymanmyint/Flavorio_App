package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class CakeRecipe_1 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_recipe1);

        webView = findViewById(R.id.webview_chocolate);
        webView.loadUrl("file:///android_asset/chocolate_ingredients.html");
    }
}