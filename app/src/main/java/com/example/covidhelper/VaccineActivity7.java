package com.example.covidhelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class VaccineActivity7 extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks {
    private String datex;
    private String newDate;
    private String vacName="";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine7);
        getSupportActionBar().hide();
        Random rand=new Random();
        Button finalize;
        finalize=findViewById(R.id.button19);
        String firstname, lastname, jmbg, phone, email, location, vac1,vac2,vac3,vac4,vac5, blood_status, movement, specific_medical;
        firstname=getIntent().getStringExtra("firstname");
        lastname=getIntent().getStringExtra("lastname");
        jmbg=getIntent().getStringExtra("jmbg");
        phone=getIntent().getStringExtra("phone");
        email=getIntent().getStringExtra("email");
        location=getIntent().getStringExtra("location");
        vac1=getIntent().getStringExtra("vac1");
        vac2=getIntent().getStringExtra("vac2");
        vac3=getIntent().getStringExtra("vac3");
        vac4=getIntent().getStringExtra("vac4");
        vac5=getIntent().getStringExtra("vac5");
        Handler handler=new Handler();
        blood_status=getIntent().getStringExtra("blood_status");
        movement=getIntent().getStringExtra("movement");
        specific_medical=getIntent().getStringExtra("specific_medical");
        TextView dateText;
        EditText date;
        CheckBox checkBox_final;
        checkBox_final=findViewById(R.id.checkBox9);
        VaccineDatabase vaccineDatabase=VaccineDatabase.getVaccineDatabaseDatabase(getApplicationContext());
        VaccineDao vaccineDao=vaccineDatabase.vaccineDaoDao();
        finalize.setEnabled(false);
        String SiteKey="6LcE75YhAAAAAD_8OGERIIKfZp25cWLcoDCY-MZ1";
        date=findViewById(R.id.editTextTextPersonName9);
        DatePickerDialog.OnDateSetListener setListener;
        Calendar calendar= Calendar.getInstance();
         int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        CheckBox robot;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if (vac1.equals("Not selected")){
            vacName=vacName+"";
        } else {
            vacName=vacName+"Pfizer-BioNTech";
        }
        if (vac2.equals("Not selected")){
            vacName=vacName+"";
        } else{
            vacName=vacName+"/Sinopharm BBIBP-CorV";
        } if (vac3.equals("Not selected")){
            vacName=vacName+"";
        } else {
            vacName=vacName+"/Moderna COVID-19 vaccine";
        } if (vac4.equals("Not selected")){
            vacName=vacName+"";
        } else{
            vacName=vacName+"/Sputnik V";
        } if (vac5.equals("Not selected")){
            vacName=vacName+"";
        } else{
            vacName=vacName+"AstraZeneca vaccine";
        }

        checkBox_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalize.setEnabled(true);
            }
        });

        finalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkBox_final.isChecked()){
                    Toast.makeText(getApplicationContext(), "You have to agree with Terms and Conditions", Toast.LENGTH_SHORT).show();
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            VaccineUser vaccineUser=new VaccineUser();
                            vaccineUser.setVac_name(firstname);
                            vaccineUser.setVac_surname(lastname);
                            vaccineUser.setJmbg(jmbg);
                            vaccineUser.setVac_email(email);
                            vaccineUser.setVac_phone(phone);
                            vaccineUser.setVac_location(location);
                            vaccineUser.setVac_ds_status(specific_medical);
                            vaccineUser.setMovement_status(movement);
                            vaccineUser.setBlood_status(blood_status);
                            vaccineUser.setVac1(vac1);
                            vaccineUser.setVac2(vac2);
                            vaccineUser.setVac3(vac3);
                            vaccineUser.setVac4(vac4);
                            vaccineUser.setVac5(vac5);
                            vaccineUser.setVacDate(newDate);
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    vaccineDao.registerVaccineUser(vaccineUser);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(), "Vaccination registered successfully, expect fast response", Toast.LENGTH_SHORT).show();
                                            handler.postDelayed(new Runnable() {
                                                public void run() {
                                                    String mEmail = "nedim.bandzovic2001@gmail.com";
                                                    String mSubject = "Response for your COVID-19 vaccination registration";
                                                    String mMessage = "Hello there," +firstname + " " + lastname  + "\n" + "Here is information for your vaccination:" + "\n" +
                                                            "Location of your vaccination: " + location + "\n"  + "Vaccines that you had chosen:" + vacName + "\n" + "Date of your vaccination:" + newDate.toString() + "";
                                                    message=mMessage;
                                                    JavaMailAPI javaMailAPI = new JavaMailAPI(VaccineActivity7.this, mEmail, mSubject, mMessage);
                                                    javaMailAPI.execute();

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
                                                        writer.write("phone_number=38761648664&message="+"Hello there," +firstname + " " + lastname  + "\n" + "Here is information for your vaccination:" + "\n" +
                                                        "Location of your vaccination: " + location + "\n"  + "Vaccines that you had chosen:" + vacName + "\n" + "Date of your vaccination:" + newDate.toString()+"&message_type=ARN");
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
                                                    Intent return_to_menu=new Intent (VaccineActivity7.this, MenuActivity.class);
                                                    return_to_menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(return_to_menu);
                                                    overridePendingTransition(0,0);


                                                }
                                            }, 6000);   //5 seconds
                                        }
                                    });
                                }
                            }).start();


                        }
                    }).start();
                }


            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(VaccineActivity7.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        datex=day+"/"+month+"/"+year;
                        int newDay; int newMonth; int newYear;
                        newDay=rand.nextInt(30 - day) +day;
                        newMonth=rand.nextInt(12 - month) + month;
                        newDate=newDay+"/"+newMonth+"/"+year;
                        date.setText(datex);
                    }
                }, year, month,day );
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}