package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChangeActivity extends AppCompatActivity {
    private int abcd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        getSupportActionBar().hide();
        Random rand=new Random();
        abcd = rand.nextInt(9999-1000)+1000;
        String username=getIntent().getStringExtra("username");
        EditText fourcode;
        fourcode=findViewById(R.id.editTextTextPersonName5);
        Button resend, submit;
        ImageView back;
        submit=findViewById(R.id.button9);
        resend=findViewById(R.id.button10);
        back=findViewById(R.id.backbutton);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String mEmail = "nedim.bandzovic2001@gmail.com";
                String mSubject = "Change of your password on COVID Helper";
                String mMessage ="The code for resetting the password is: " + abcd;
                JavaMailAPI javaMailAPI = new JavaMailAPI(ChangeActivity.this, mEmail, mSubject, mMessage);
                javaMailAPI.execute();
            }
        }).start();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_code=fourcode.getText().toString();
                int input_to_int=Integer.valueOf(input_code);
                if (input_to_int==abcd){
                    Intent proceed_intent=new Intent(ChangeActivity.this, ChangePwdFinal.class);
                    proceed_intent.putExtra("username", username);
                    startActivity(proceed_intent);
                    overridePendingTransition(0,0);
                } else{
                    Toast.makeText(getApplicationContext(), "Code not correct", Toast.LENGTH_SHORT).show();
                }
            }
        });
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restart_intent=new Intent(ChangeActivity.this, ChangeActivity.class);
                restart_intent.putExtra("username", username);
                startActivity(restart_intent);
                overridePendingTransition(0,0);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_intent=new Intent(ChangeActivity.this, SettingsActivity.class);
                back_intent.putExtra("username", username);
                startActivity(back_intent);
                overridePendingTransition(0,0);
            }
        });
        TextView timer;
        timer=findViewById(R.id.textView19);
        new CountDownTimer(300000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                timer.setText(""+String.format("%d"+":"+"%d",
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                timer.setText("0:00");
                submit.setEnabled(false);
            }
        }.start();
    }
}