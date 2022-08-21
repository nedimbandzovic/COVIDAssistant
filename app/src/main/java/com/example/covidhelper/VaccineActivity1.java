package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class VaccineActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine1);
        getSupportActionBar().hide();
        Spinner citizenshipSpinner;
        citizenshipSpinner=findViewById(R.id.spinner);
        EditText jmbg;
        jmbg=findViewById(R.id.editTextTextPersonName7);
        Button proceedButton;
        proceedButton=findViewById(R.id.button13);
        String[] items = new String[]{"Citizen of Bosnia and Herzegovina and Sarajevo Canton", "Citizen of Bosnia and Herzegovina, not living in Sarajevo Canton"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        citizenshipSpinner.setAdapter(adapter);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jmbg_final=jmbg.getText().toString();
                if (jmbg_final.length()<13){
                    Toast.makeText(getApplicationContext(), "Entered JMBG is not valid, please try again", Toast.LENGTH_SHORT).show();

                } else if (jmbg_final.length()>13){
                    Toast.makeText(getApplicationContext(), "Entered JMBG is not valid, please try again", Toast.LENGTH_SHORT).show();
                }else{
                    Intent jmbg_intent=new Intent(VaccineActivity1.this, VaccineActivity3.class);
                    jmbg_intent.putExtra("jmbg", jmbg_final);
                    startActivity(jmbg_intent);
                    overridePendingTransition(0,0);
                }
            }
        });
    }
}