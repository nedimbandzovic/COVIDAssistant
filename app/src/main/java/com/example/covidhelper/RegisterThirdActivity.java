package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_third);
        getSupportActionBar().hide();
        String first_name= getIntent().getStringExtra("firstname");
        String second_name=getIntent().getStringExtra("secondname");
        String email_adress=getIntent().getStringExtra("email");
        String municipality=getIntent().getStringExtra("municipality");
        String validation_code=getIntent().getStringExtra("validationCode");
        EditText username, password;
        Button proceedBtn;
        username=findViewById(R.id.editTextTextPersonName);
        password=findViewById(R.id.editTextTextPersonName2);
        proceedBtn=findViewById(R.id.button);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_text=username.getText().toString();
                String password_text=password.getText().toString();
                if (username_text.isEmpty()||password_text.isEmpty()){
                    Toast.makeText(getApplicationContext(), "You need to fill in both fields",Toast.LENGTH_SHORT).show();
                } else if (password_text.length()<8){
                    Toast.makeText(getApplicationContext(), "Your password must have 8 characters", Toast.LENGTH_SHORT).show();
                } else{
                    Intent register_final_intent=new Intent(RegisterThirdActivity.this, RegisterFinalActivity.class);
                    register_final_intent.putExtra("firstname",first_name);
                    register_final_intent.putExtra("secondname",second_name);
                    register_final_intent.putExtra("email",email_adress);
                    register_final_intent.putExtra("municipality",municipality);
                    register_final_intent.putExtra("validationcode",validation_code);
                    register_final_intent.putExtra("username",username_text);
                    register_final_intent.putExtra("password",password_text);
                    startActivity(register_final_intent);
                    overridePendingTransition(0,0);
                }
            }
        });

    }
}