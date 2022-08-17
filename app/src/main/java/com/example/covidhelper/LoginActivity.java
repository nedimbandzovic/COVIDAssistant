package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login2);
        EditText username=findViewById(R.id.editTextTextPersonName);
        EditText password=findViewById(R.id.editTextTextPassword);
        Button loginBtn=findViewById(R.id.button);
        Button registerBtn=findViewById(R.id.button2);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_text=username.getText().toString();
                String password_text=password.getText().toString();
                if (username_text.isEmpty()||password_text.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (password_text.length()<=8){
                    Toast.makeText(getApplicationContext(), "Your password is not valid", Toast.LENGTH_SHORT).show();
                } else{
                    UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao=userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user= userDao.login(username_text, password_text);
                            if (user==null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Entered credentials are not correct, try again", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                Intent successful_login_intent=new Intent(LoginActivity.this, CovidCodeActivity.class);
                                successful_login_intent.putExtra("username", username_text);
                                startActivity(successful_login_intent);
                                overridePendingTransition(0, 0);
                            }
                        }
                    }).start();
                }
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register_intent);
                overridePendingTransition(0, 0);
            }
        });


    }
}