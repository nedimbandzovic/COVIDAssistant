package com.example.covidhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class SymptomsActivity extends AppCompatActivity {
    private String f_name;
    private String l_name;
    private String coughing_status, nausea_status, nose_status, sore_status, d_status, hdche_status, fatigue_status;
    private String severe_breathing, pale_skin, un_to_wake, confusion_s,pressure_s;
    private String final_message;
    private String alert_needed;
    public void askForPermission(){
        ActivityCompat.requestPermissions(SymptomsActivity.this, new String[]{


                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        getSupportActionBar().hide();
        Random rand=new Random();
        int rand_int=rand.nextInt(100000 - 100) + 100;
        String username=getIntent().getStringExtra("username");
        RadioButton coughingYes, coughingNo, nauseaYes, nauseaNo, runnynoseYes, runnynoseNo, soreYes,soreNo, dijarejaYes,dijarejaNo, headacheYes, headacheNo, fatigueYes, fatigueNo;
        RadioButton severebreathing, paleskin, unabletowake, confusion, pressure;
        Button submit;
        UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao=userDatabase.userDao();
        coughingYes=findViewById(R.id.radioButton23);
        coughingNo=findViewById(R.id.radioButton41);
        nauseaYes=findViewById(R.id.radioButton);
        nauseaNo=findViewById(R.id.radioButton4);
        runnynoseYes=findViewById(R.id.radioButton654);
        runnynoseNo=findViewById(R.id.radioButton54);
        soreYes=findViewById(R.id.radioButto41414);
        soreNo=findViewById(R.id.radioButton3334);
        dijarejaYes=findViewById(R.id.radioButton433434);
        dijarejaNo=findViewById(R.id.radioButton4343344);
        headacheYes=findViewById(R.id.radioButton54554541);
        headacheNo=findViewById(R.id.radioButton445544554);
        fatigueYes=findViewById(R.id.radioButto33n);
        fatigueNo=findViewById(R.id.radioButton411112);
        severebreathing=findViewById(R.id.radioButton5);
        paleskin=findViewById(R.id.radioButton91);
        unabletowake=findViewById(R.id.radioButton8);
        confusion=findViewById(R.id.radioButton7);
        pressure=findViewById(R.id.radioButton6);
        submit=findViewById(R.id.button14);
        ProgressDialog dialogt=new ProgressDialog(SymptomsActivity.this);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        new Thread(new Runnable() {
            @Override
            public void run() {
                l_name=userDao.get_firstname_by_username(username);
                f_name=userDao.get_secondname_by_username(username);

            }
        }).start();
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SymptomsActivity.this);

                builder.setTitle("Confirm before submitting");
                builder.setMessage("If your report contains severe symptoms, it will trigger the alert system");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        if (coughingYes.isChecked()){
                            coughing_status="Yes";
                            coughingNo.setClickable(false);
                        } else{
                            coughing_status="No";
                            coughingYes.setClickable(false);
                        }
                        if (soreYes.isChecked()){
                            sore_status="Yes";
                            soreNo.setClickable(false);
                        } else{
                            sore_status="No";
                            soreYes.setClickable(true);
                        }
                        if (nauseaYes.isChecked()){
                            nausea_status="Yes";
                            nauseaNo.setClickable(false);
                        } else{
                            nausea_status="No";
                            nauseaYes.setClickable(true);
                        }
                        if (dijarejaYes.isChecked()){
                            d_status="Yes";
                            dijarejaNo.setClickable(false);
                        } else{
                            d_status="No";
                            dijarejaYes.setClickable(true);
                        }
                        if (fatigueYes.isChecked()){
                            fatigue_status="Yes";
                            fatigueNo.setClickable(false);
                        } else{
                            fatigue_status="No";
                            fatigueNo.setClickable(true);
                        }
                        if (runnynoseYes.isChecked()){
                            nose_status="Yes";
                            runnynoseNo.setClickable(false);
                        } else{
                            nose_status="No";
                            runnynoseYes.setClickable(false);
                        }
                        if (headacheYes.isChecked()){
                            hdche_status="Yes";
                            headacheNo.setClickable(false);
                        } else{
                            hdche_status="No";
                            headacheYes.setClickable(false);
                        }
                        final_message="";
                        if (severebreathing.isChecked()){
                            severe_breathing="Yes";
                            alert_needed="Yes";
                            final_message="Severe breathing reported.";

                        } else{
                            severe_breathing="No";

                        }
                        if (unabletowake.isChecked()){
                            un_to_wake="Yes";
                            alert_needed="Yes";

                            final_message=final_message+".Unable to wake and stay awake.";
                        } else {
                            un_to_wake="No";

                        }
                        if (confusion.isChecked()){
                            confusion_s="Yes";

                            final_message=final_message+".Confusion reported.";
                        } else {
                            confusion_s="No";

                        }
                        if (pressure.isChecked()){
                            pressure_s="Yes";
                            alert_needed="Yes";

                            final_message=final_message+".Pressure on chest reported";
                        } else{
                            alert_needed="No";

                        }
                        if (paleskin.isChecked()){
                            pale_skin="Yes";
                            alert_needed="Yes";

                            final_message=final_message+". Pale skin reported";
                        } else{
                            alert_needed="No";
                        }
                        askForPermission();
                        PdfDocument myPdfDocument = new PdfDocument();
                        Paint myPaint = new Paint();
                        Paint titlePaint = new Paint();
                        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                        PdfDocument.Page myPage1 = myPdfDocument.startPage(myPageInfo1);
                        Canvas canvas = myPage1.getCanvas();
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Bosnia and Herzegovina", 600, 100, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Federation of Bosnia and Herzegovina", 600, 150, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Sarajevo Canton", 600, 200, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("COVID-19 Symptoms Report for: " + f_name + " " + l_name, 600, 350, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Coughing:" + coughing_status, 600, 500, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Sore throat:" + sore_status, 600, 550, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Nausea:" + nausea_status, 600, 600, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Diarrhea:" + d_status, 600, 650, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Fatigue:" + fatigue_status, 600, 700, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Runny nose:" + nose_status, 600, 750, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Headache:" + hdche_status, 600, 800, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Severe symptoms:" + final_message, 600, 850, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("ALERT NEEDED:" + alert_needed, 600, 950, titlePaint);
                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);


                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(32);
                        canvas.drawText("Certificate ID:" + rand_int, 600, 1850, titlePaint);


                        titlePaint.setTextAlign(Paint.Align.CENTER);
                        titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                        titlePaint.setTextSize(12);
                        canvas.drawText("© 2022 COVID Helper, KS, BiH", 600, 1900, titlePaint);


                        myPdfDocument.finishPage(myPage1);

                        File file = new File(Environment.getExternalStorageDirectory(), "/Download/COVIDHelperSymptomsReport.pdf");


                        try {
                            myPdfDocument.writeTo(new FileOutputStream(file));


                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        myPdfDocument.close();
                        new CountDownTimer(7000, 1000) {

                            public void onTick(long millisUntilFinished) {
                                dialogt.setMessage("Finalizing your report...");
                                dialogt.show();                        //here you can have your logic to set text to edittext
                            }

                            public void onFinish() {

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Report generated successfully", Toast.LENGTH_SHORT).show();

                                    }
                                });

                                if (final_message==null){
                                    dialogt.dismiss();
                                }
                                else if (final_message.length()>0){
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
                                        writer.write("phone_number=38761648664&message="+l_name.toUpperCase() +" " + f_name.toUpperCase() + " REQUIRES YOUR IMMEDIATE REACTION, BECAUSE HE / SHE REPORTED:" +final_message + "&message_type=ARN");
                                        writer.flush();
                                        writer.close();
                                        httpConn.getOutputStream().close();

                                        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                                                ? httpConn.getInputStream()
                                                : httpConn.getErrorStream();
                                        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
                                        String response = s.hasNext() ? s.next() : "";
                                        System.out.println(response);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(getApplicationContext(), "Alerted", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    } catch (IOException ioex) {
                                        ioex.printStackTrace();
                                    } finally {
                                        dialogt.dismiss();

                                    }

                                }



                            }

                        }.start();

                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });
        BottomNavigationView bottomNavigationView=findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.symptoms);
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        Intent xxnt=new Intent(SymptomsActivity.this, CovidCodeActivity.class);
                        xxnt.putExtra("username",username);
                        startActivity(xxnt);
                        finish();
                        overridePendingTransition(0,0);
                        return;
                        case R.id.settings:
                        Intent settingssss_intent=new Intent(SymptomsActivity.this, SettingsActivity.class);
                        settingssss_intent.putExtra("username", username);
                        startActivity(settingssss_intent);
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.doctor:
                        Intent symptomsaa_intent=new Intent(SymptomsActivity.this, DoctorActivity.class);
                        symptomsaa_intent.putExtra("username",username);
                        startActivity(symptomsaa_intent);
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.symptoms:
                }
            }
        });

    }
}