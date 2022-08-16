package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        EditText validationCode=findViewById(R.id.editTextTextPersonName);
        Button proceedBtn=findViewById(R.id.button);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validationCodeText=validationCode.getText().toString();
                if (validationCodeText.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill in the field", Toast.LENGTH_SHORT).show();
                } else if (!validationCodeText.contains("KS")) {
                    Toast.makeText(getApplicationContext(),"Code is not in valid format", Toast.LENGTH_SHORT).show();
                } else if (validationCodeText.length()<7){
                    Toast.makeText(getApplicationContext(), "Your code must have 7 characters", Toast.LENGTH_SHORT).show();
                } else{
                    Intent proceed_intent=new Intent(RegisterActivity.this, RegisterSecondActivity.class);
                    proceed_intent.putExtra("validationCode", validationCodeText);
                    startActivity(proceed_intent);
                    overridePendingTransition(0,0);
                }
            }
        });
    }
}