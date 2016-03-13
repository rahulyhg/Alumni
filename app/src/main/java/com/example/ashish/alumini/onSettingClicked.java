package com.example.ashish.alumini;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by ashish on 9/3/16.
 */
public class onSettingClicked extends AppCompatActivity{
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_setting_click);
        Button button_viewprofile = (Button) findViewById(R.id.textView_myprofile);
        ImageButton imageButton = (ImageButton) findViewById(R.id.button_setting);
        imageButton.setBackgroundColor(Color.parseColor("#f5f5f5"));
        button_viewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onSettingClicked.this, profile.class);
                startActivity(intent);
            }
        });
        ImageButton filter = (ImageButton) findViewById(R.id.button_filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(onSettingClicked.this, onFilterClick.class);
                startActivity(intent);
                finish();
            }
        });
        Button button_fbpage = (Button) findViewById(R.id.button_fbPage);
        button_fbpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        Button button_aboutapp = (Button) findViewById(R.id.button_about_cllege);
        button_aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        Button button_aboutclg = (Button) findViewById(R.id.button_about_app);
        button_aboutclg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onSettingClicked.this,About_app.class);
                startActivity(intent);
            }
        });
        Button button_contact_us = (Button) findViewById(R.id.button_contact_us);
        button_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(onSettingClicked.this,Contact_us.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setContentView(R.layout.on_setting_click);
    }
}