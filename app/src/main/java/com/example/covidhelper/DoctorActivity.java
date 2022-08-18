package com.example.covidhelper;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


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
        Button alert;
        alert=findViewById(R.id.button6);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    URL url = new URL("https://rest-api.telesign.com/v1/messaging");
                    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                    httpConn.setRequestMethod("POST");
                    httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    byte[] message = ("11F5FB0E-F4C2-40D1-8D1C-09566A77BB25:Wh3iFvX/0Uh8jCE6YO2YkZFI6emEO1j9H6IOW6MmZ/5SLxu7XEoHOlDqgy3rcHHBNX5jE6Tfph6Rw0CZuCd1sA==").getBytes("UTF-8");
                    String basicAuth = android.util.Base64.encodeToString(message, Base64.NO_WRAP);

                    httpConn.setRequestProperty("Authorization", "Basic " + basicAuth);

                    httpConn.setDoOutput(true);
                    OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
                    writer.write("phone_number=38761648664&message=You have a dentist appointment at 2:15pm&message_type=ARN");
                    writer.flush();
                    writer.close();
                    httpConn.getOutputStream().close();

                    InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                            ? httpConn.getInputStream()
                            : httpConn.getErrorStream();
                    Scanner s = new Scanner(responseStream).useDelimiter("\\A");
                    String response = s.hasNext() ? s.next() : "";
                    System.out.println(response);
                } catch (IOException ioex) {
                    ioex.printStackTrace();
                } finally {

                }
            };
        });
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