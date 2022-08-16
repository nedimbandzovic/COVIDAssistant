package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        Button vaccine_button=(Button)findViewById(R.id.vaccine);
        Button news=(Button)findViewById(R.id.news);
        Button assistant=(Button)findViewById(R.id.assistant);
        vaccine_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vaccine_intent=new Intent (MenuActivity.this, VaccinationActivity.class);
                startActivity(vaccine_intent);
                overridePendingTransition(0, 0);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent news_intent=new Intent (MenuActivity.this, NewsActivity.class);
                startActivity(news_intent);
                overridePendingTransition(0,0);
            }
        });
        assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent assistant_intent=new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(assistant_intent);
                overridePendingTransition(0,0);
            }
        });

    }
}