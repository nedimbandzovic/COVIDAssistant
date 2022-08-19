package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePwdFinal extends AppCompatActivity {

    private String oldPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler=new Handler();
        setContentView(R.layout.activity_change_pwd_final);
        getSupportActionBar().hide();
        EditText pwd1,pwd2;
        Button confirm;
        String username=getIntent().getStringExtra("username");
        pwd1=findViewById(R.id.editTextTextPersonName6);
        pwd2=findViewById(R.id.editTextTextPersonName86);
        confirm=findViewById(R.id.button11);
        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao = userDatabase.userDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                oldPwd=userDao.get_password_by_username(username);
            }
        }).start();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password1=pwd1.getText().toString();
                String password2=pwd2.getText().toString();

                if (!password1.equals(password2)){
                    Toast.makeText(getApplicationContext(), "Entered passwords do not match", Toast.LENGTH_SHORT).show();
                } else if (password1.equals(oldPwd)){
                    Toast.makeText(getApplicationContext(), "Entered passwords are same as the old one. Please change it", Toast.LENGTH_SHORT).show();
                } else if (password1.length()<8){
                    Toast.makeText(getApplicationContext(), "Password must have 8 characters minimally", Toast.LENGTH_SHORT).show();
                } else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.set_password_by_username(password1, username);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Password successfully changed, log in again", Toast.LENGTH_SHORT).show();
                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            Intent redirect_intent=new Intent (ChangePwdFinal.this, MenuActivity.class);
                                            redirect_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(redirect_intent);
                                            overridePendingTransition(0,0);
                                        }
                                    }, 3000);
                                }
                            });

                        }
                    }).start();

                }
            }
        });

    }
}