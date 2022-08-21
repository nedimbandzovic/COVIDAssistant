package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VaccinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);
        getSupportActionBar().hide();
        Button proceed, report;
        proceed=findViewById(R.id.button12);
        report=findViewById(R.id.button20);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vaccine1_activity=new Intent(VaccinationActivity.this, VaccineActivity1.class);
                startActivity(vaccine1_activity);
                overridePendingTransition(0,0);
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vaccine2_activity=new Intent (VaccinationActivity.this, VaccineGenerate.class);
                startActivity(vaccine2_activity);
                overridePendingTransition(0,0);
            }
        });
    }
}