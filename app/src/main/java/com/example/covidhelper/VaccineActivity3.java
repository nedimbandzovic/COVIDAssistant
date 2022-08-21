package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VaccineActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine3);
        String jmbg=getIntent().getStringExtra("jmbg");
        getSupportActionBar().hide();
        EditText firstname, lastname, phone, email;
        Button procedBtn;
        firstname=findViewById(R.id.editTextTextPersonName18);
        lastname=findViewById(R.id.editTextTextPersonName811);
        phone=findViewById(R.id.editTextTextPersonName8);
        email=findViewById(R.id.editTextTextPersonName8123);
        procedBtn=findViewById(R.id.button15);
        procedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn_final=firstname.getText().toString();
                String ln_final=lastname.getText().toString();
                String pn_final=phone.getText().toString();
                String email_final=email.getText().toString();
                if (fn_final.isEmpty()||ln_final.isEmpty()||pn_final.isEmpty()||email_final.isEmpty()){
                    Toast.makeText(getApplicationContext(), "You need to fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!isEmailValid(email_final)){
                    Toast.makeText(getApplicationContext(), "Your e-mail is not in proper format", Toast.LENGTH_SHORT).show();
                } else if (!pn_final.contains("+387")){
                    Toast.makeText(getApplicationContext(), "Please check your entered phone number", Toast.LENGTH_SHORT).show();
                } else{
                    Intent new_intent=new Intent(VaccineActivity3.this, VaccineActivity4.class);
                    new_intent.putExtra("jmbg", jmbg);
                    new_intent.putExtra("firstname", fn_final);
                    new_intent.putExtra("lastname", ln_final);
                    new_intent.putExtra("phone", pn_final);
                    new_intent.putExtra("email", email_final);
                    startActivity(new_intent);
                    overridePendingTransition(0,0);
                }
            }
        });
    }

    boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}