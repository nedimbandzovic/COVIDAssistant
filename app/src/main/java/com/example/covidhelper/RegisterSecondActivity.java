package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText firstname, secondname, email;
        TextView valCode;
        Spinner munSpinner;
        Button registerBtn;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_second);
        getSupportActionBar().hide();
        firstname=findViewById(R.id.editTextTextPersonName);
        secondname=findViewById(R.id.editTextTextPersonName2);
        email=findViewById(R.id.editTextTextPersonName3);
        registerBtn=findViewById(R.id.button);
        munSpinner=findViewById(R.id.spinner1);
        valCode=findViewById(R.id.textView8);
        String validationCode= getIntent().getStringExtra("validationCode");
        valCode.setText("Validation code:" + validationCode.toString());
        String[] items = new String[]{"Stari Grad", "Centar", "Novo Sarajevo", "Novi Grad", "Ilidža", "Hadžići", "Trnovo", "Vogošća", "Ilijaš"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        munSpinner.setAdapter(adapter);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn=firstname.getText().toString();
                String sn=secondname.getText().toString();
                String e=email.getText().toString();
                String muni = munSpinner.getSelectedItem().toString();
                String vC=validationCode;
                if (fn.isEmpty() || sn.isEmpty() || e.isEmpty() || muni.isEmpty() || vC.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "You will need to fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!isEmailValid(e)) {
                    Toast.makeText(getApplicationContext(), "You need to enter a proper email", Toast.LENGTH_SHORT).show();
                } else{
                    Intent proceed_intent=new Intent(RegisterSecondActivity.this, RegisterThirdActivity.class);
                    proceed_intent.putExtra("firstname", fn);
                    proceed_intent.putExtra("secondname", sn);
                    proceed_intent.putExtra("email", e);
                    proceed_intent.putExtra("municipality", muni);
                    proceed_intent.putExtra("validationCode", vC);
                    startActivity(proceed_intent);
                    overridePendingTransition(0,0);
                }
            }

            boolean isEmailValid(String email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
        });




    }
}