package com.example.covidhelper;

import static io.reactivex.internal.schedulers.SchedulerPoolFactory.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class VaccineGenerate extends AppCompatActivity {
    private String vacName="";
    private int rand_int;
    public void askForPermission(){
        ActivityCompat.requestPermissions(VaccineGenerate.this, new String[]{


                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_generate);
        getSupportActionBar().hide();
        VaccineDatabase vaccineDatabase=VaccineDatabase.getVaccineDatabaseDatabase(getApplicationContext());
        VaccineDao vaccineDao=vaccineDatabase.vaccineDaoDao();
        EditText jmbg;
        Button proceedBtn;
        jmbg=findViewById(R.id.editTextTextPersonName10);
        proceedBtn=findViewById(R.id.button21);
        Bitmap bmp,bmp2;
        Bitmap scaledbmp,scaledbmp2;
        bmp= BitmapFactory.decodeResource(getResources(), R.drawable.grbovi);
        scaledbmp=Bitmap.createScaledBitmap(bmp, 400, 200, false);
        Random rand = new Random();
        bmp2=BitmapFactory.decodeResource(getResources(), R.drawable.qrcode);
        scaledbmp2=Bitmap.createScaledBitmap(bmp2, 400, 400, false);
        rand_int=rand.nextInt((90000-10000))+10000;
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String jmbg_text=jmbg.getText().toString();
                        VaccineUser test_user=vaccineDao.check(jmbg_text.toString());
                        if (test_user==null){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "This user does not exist", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            String firstname=test_user.getVac_name();
                            String secondname=test_user.getVac_surname();
                            String jmbg=test_user.getJmbg();
                            String vac1=test_user.getVac1();
                            String vac2=test_user.getVac2();
                            String vac3=test_user.getVac3();
                            String vac4=test_user.getVac4();
                            String vac5=test_user.getVac5();
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
                            String location=test_user.getVac_location();
                            String date=test_user.getVacDate();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Report generated, you can find in the internal memory of your phone", Toast.LENGTH_SHORT).show();
                                }
                            });
                            askForPermission();
                            PdfDocument myPdfDocument = new PdfDocument();
                            Paint myPaint=new Paint();
                            Paint titlePaint=new Paint();
                            PdfDocument.PageInfo myPageInfo1=new PdfDocument.PageInfo.Builder(1200, 2010, 1).create();
                            PdfDocument.Page myPage1=myPdfDocument.startPage(myPageInfo1);

                            Canvas canvas=myPage1.getCanvas();
                            canvas.drawBitmap(scaledbmp, 40, 50, myPaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(32);
                            canvas.drawText("BOSNIA AND HERZEGOVINA", 800, 100, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(32);
                            canvas.drawText("FEDERATION OF BOSNIA AND HERZEGOVINA", 800, 150, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(32);
                            canvas.drawText("SARAJEVO CANTON", 800, 200, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(32);
                            canvas.drawText("CONFIRMATION ABOUT SCHEDULED VACCINATION", 600, 350, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(25);
                            canvas.drawText("Name and surname", 600, 500, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                            titlePaint.setTextSize(25);
                            canvas.drawText(firstname +" " + secondname, 600, 550, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(25);
                            canvas.drawText("Unique Master Citizen Number", 600, 600, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                            titlePaint.setTextSize(25);
                            canvas.drawText(jmbg.toString(), 600, 650, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(25);
                            canvas.drawText("Vakcina / Selected vaccine", 600, 700, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                            titlePaint.setTextSize(25);
                            canvas.drawText(vacName, 600, 750, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(25);
                            canvas.drawText("Vaccination place", 600, 800, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                            titlePaint.setTextSize(25);
                            canvas.drawText(location, 600, 850, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(25);
                            canvas.drawText("Vaccination date", 600, 900, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                            titlePaint.setTextSize(25);
                            canvas.drawText(date, 600, 950, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(25);
                            canvas.drawBitmap(scaledbmp2, 400, 1000, myPaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
                            titlePaint.setTextSize(21);
                            canvas.drawText("You can use the QR code to identify yourself on chosen vaccination place", 600, 1450, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(25);
                            canvas.drawText("Certificate ID:" + rand_int, 600, 1850, titlePaint);
                            titlePaint.setTextAlign(Paint.Align.CENTER);
                            titlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                            titlePaint.setTextSize(12);
                            canvas.drawText("© 2022 COVID Helper, KS, BiH",600, 1900, titlePaint);

                            myPdfDocument.finishPage(myPage1);
                            File file;
                            file = new File (Environment.getExternalStorageDirectory(),"/Download/COVID-19VaccineConfirmation.pdf");
                            try{
                                myPdfDocument.writeTo(new FileOutputStream(file));

                            }catch (IOException e){
                                e.printStackTrace();
                            }
                            myPdfDocument.close();

                        }
                        }

                }).start();
            }
        });
    }
};