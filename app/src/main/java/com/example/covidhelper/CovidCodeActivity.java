package com.example.covidhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.text.DecimalFormat;

public class CovidCodeActivity extends AppCompatActivity {

    private double progr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_code);
        getSupportActionBar().hide();
        String username=getIntent().getStringExtra("username");
        TextView nameandsurname, email, telephone, progress;
        ImageView coatOfArms, man;
        Button incr, decr, setter, radioBtn;
        nameandsurname=findViewById(R.id.textView15);
        email=findViewById(R.id.textView145);
        coatOfArms=findViewById(R.id.imageView8);
        telephone=findViewById(R.id.textView1445);
        incr=findViewById(R.id.button_incr);
        decr=findViewById(R.id.button_decr);
        setter=findViewById(R.id.button4);
        man=findViewById(R.id.imageView9);
        progress=findViewById(R.id.text_view_progress);
        ProgressBar progress_bar=findViewById(R.id.progress_bar);
        UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao=userDatabase.userDao();
        RadioButton smell, taste;
        smell=findViewById(R.id.radioButton2);
        taste=findViewById(R.id.radioButton3);
        radioBtn=findViewById(R.id.button34);
        radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (smell.isChecked() && taste.isChecked()){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.set_smell("Yes", username);
                            userDao.set_taste("Yes", username);
                            smell.setChecked(false);
                            taste.setChecked(false);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                } else if (smell.isChecked() && !taste.isChecked()){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.set_smell("Yes", username);
                            userDao.set_taste("No", username);
                            smell.setChecked(false);
                            taste.setChecked(false);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                } else if (!smell.isChecked()&&taste.isChecked()){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.set_smell("No", username);
                            userDao.set_taste("Yes", username);
                            smell.setChecked(false);
                            taste.setChecked(false);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();

                } else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.set_smell("No", username);
                            userDao.set_taste("No", username);
                            smell.setChecked(false);
                            taste.setChecked(false);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                String user_temp=userDao.get_temp_by_username(username);
                double d=Double.valueOf(user_temp);
                DecimalFormat df = new DecimalFormat("##.#");
                df.format(d);
                progr=d;
                progress.setText(df.format(d)+"°C");
                progress_bar.setProgress((int)progr);
                if (d>37.5){
                    progress.setTextColor(Color.RED);
                    man.setImageResource(R.drawable.redman);
                } else{
                    progress.setTextColor(Color.GREEN);
                    man.setImageResource(R.drawable.greenman);

                }
            }
        }).start();
        setter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
                UserDao userDao=userDatabase.userDao();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String doublemy=Double.toString(progr);
                        userDao.set_temperature(doublemy,username);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(getApplicationContext(),"Temperature successfully updated", Toast.LENGTH_SHORT).show();
                                if (progr>37.5){
                                progress.setTextColor(Color.RED);
                                man.setImageResource(R.drawable.redman);
                            } else{
                                progress.setTextColor(Color.GREEN);
                                    man.setImageResource(R.drawable.greenman);

                                }
                            }
                        });

                    }
                }).start();
            }
        });

        incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progr <= 41) {
                    progr = progr + 0.1;
                    if (progr>37.5){
                        progress.setTextColor(Color.RED);
                    } else{
                        progress.setTextColor(Color.GREEN);
                    }
                    progress_bar.setProgress((int)progr);
                    DecimalFormat df = new DecimalFormat("##.#");
                    progress.setText(df.format(progr)+"°C");
                }
            }
        });
        decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progr >= 35) {
                    progr -= 0.1;
                    if (progr<37.5){
                        progress.setTextColor(Color.GREEN);
                    } else{
                        progress.setTextColor(Color.RED);
                    }
                    progress_bar.setProgress((int)progr);
                    DecimalFormat df = new DecimalFormat("##.#");
                    progress.setText(df.format(progr)+"°C");
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                String userFirstName=userDao.get_firstname_by_username(username);
                String userSecondName=userDao.get_secondname_by_username(username);
                String municipality=userDao.get_municipality_by_username(username);
                String emailDB=userDao.get_email_by_username(username);
                String final_name_and_surname=userFirstName + " " + userSecondName;
                nameandsurname.setText(final_name_and_surname.toUpperCase());
                email.setText("E-mail:" + emailDB);
                telephone.setText("Municipality of residence:" + municipality.toUpperCase());
                if (municipality.equals("Stari Grad")) {
                    coatOfArms.setImageResource(R.drawable.starig);
                } else if (municipality.equals("Ilidža")){
                    coatOfArms.setImageResource(R.drawable.ilidza);
                } else if (municipality.equals("Novo Sarajevo")){
                    coatOfArms.setImageResource(R.drawable.ns);
                } else if (municipality.equals("Novi Grad")){
                    coatOfArms.setImageResource(R.drawable.ng);
                } else if (municipality.equals("Centar")){
                    coatOfArms.setImageResource(R.drawable.centar);
                } else if (municipality.equals("Vogošća")){
                    coatOfArms.setImageResource(R.drawable.vogosca);
                } else if (municipality.equals("Hadžići")){
                    coatOfArms.setImageResource(R.drawable.hadzici);
                } else if (municipality.equals("Trnovo")){
                    coatOfArms.setImageResource(R.drawable.trnovo);
                } else if (municipality.equals("Ilijaš")){
                    coatOfArms.setImageResource(R.drawable.ilijas);
                }

            }
        }).start();
        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.dashboard);
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                    case R.id.doctor:
                        Intent doctor_inten44t=new Intent (CovidCodeActivity.this, DoctorActivity.class);
                        doctor_inten44t.putExtra("username", username);
                        startActivity(doctor_inten44t);
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.settings:
                        Intent settings_inten55t=new Intent (CovidCodeActivity.this, SettingsActivity.class);
                        settings_inten55t.putExtra("username", username);
                        startActivity(settings_inten55t);
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.symptoms:
                        Intent sym22ptoms_intent=new Intent(CovidCodeActivity.this, SymptomsActivity.class);
                        sym22ptoms_intent.putExtra("username",username);
                        startActivity(sym22ptoms_intent);
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });

    }
}