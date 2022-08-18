package com.example.covidhelper;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Random;

public class DoctorActivity extends AppCompatActivity {
    private String final_subject="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        String username=getIntent().getStringExtra("username");
        getSupportActionBar().hide();
        Random rand=new Random();
        UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao=userDatabase.userDao();
        TextView doctor_name, doctor_email, doctor_hospital;
        doctor_name=findViewById(R.id.textView15);
        doctor_email=findViewById(R.id.textView145);
        doctor_hospital=findViewById(R.id.textView1445);
        ImageView onlineofflinespec;
        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.doctor);
        onlineofflinespec=findViewById(R.id.imageView8);
        int abcd = rand.nextInt(2);
        TextView subject, message;
        CheckBox checkBox;
        ImageView policija, hitnapomoc, vatrogasci;
        policija=findViewById(R.id.imageView81);
        hitnapomoc=findViewById(R.id.imageView82);
        vatrogasci=findViewById(R.id.imageView83);
        Button sender=findViewById(R.id.button5);
        subject=findViewById(R.id.editTextTextPersonName4);
        message=findViewById(R.id.editTextTextPersonName45);
        checkBox=findViewById(R.id.checkbox_meats);
        policija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:122"));
                startActivity(intent);

            }
        });
        hitnapomoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:124"));
                startActivity(intent);

            }
        });
        vatrogasci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:123"));
                startActivity(intent);

            }
        });
        sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message_final=message.getText().toString();
                if (checkBox.isChecked()){
                    final_subject="[IMPORTANT]"+subject.getText().toString();
                } else{
                    final_subject=subject.getText().toString();
                }
                String mEmail = "nedim.bandzovic2001@gmail.com";
                String mSubject = final_subject;
                String mMessage = message_final;
                JavaMailAPI javaMailAPI = new JavaMailAPI(DoctorActivity.this, mEmail, mSubject, mMessage);
                javaMailAPI.execute();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"Message successfully sent", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", checkBox.isSelected(), System.identityHashCode(checkBox)));
            }
        });
        if (abcd==1){
            onlineofflinespec.setImageResource(R.drawable.onlinedot);
        } else{
            onlineofflinespec.setImageResource(R.drawable.offlinedot);
        }
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(DoctorActivity.this, CovidCodeActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                    case R.id.settings:
                        startActivity(new Intent(DoctorActivity.this, SettingsActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.symptoms:
                        startActivity(new Intent(DoctorActivity.this, SymptomsActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                String doctor=userDao.get_doctor_by_username(username);
                String doctorE=userDao.get_doctor_email_by_username(username);
                String doctorH=userDao.get_doctor_hospital_by_username(username);
                doctor_name.setText(doctor.toUpperCase());
                doctor_email.setText("Email:" + doctorE);
                doctor_hospital.setText(doctorH);
            }
        }).start();


    }
}