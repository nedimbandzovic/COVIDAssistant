package com.example.covidhelper;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class VaccineActivity6 extends AppCompatActivity {

    private String specificMedi, unableMove, bloodDonorStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine6);
        getSupportActionBar().hide();
        CheckBox specMed, unableMov, bloodDonor, specMedNo1, unableMovNo2, bloodDonorNo3;
        Button proceedBtn;
        proceedBtn=findViewById(R.id.button18);
        specMed=findViewById(R.id.checkBox7);
        specMedNo1=findViewById(R.id.checkBox8);
        unableMov=findViewById(R.id.checkBox17);
        unableMovNo2=findViewById(R.id.checkBox18);
        bloodDonor=findViewById(R.id.checkBox217);
        bloodDonorNo3=findViewById(R.id.checkBox218);
        String condition, movement, bd;
        String firstname, lastname, jmbg, location, phone, email, vac1,vac2,vac3,vac4,vac5;
        firstname=getIntent().getStringExtra("firstname");
        lastname=getIntent().getStringExtra("lastname");
        jmbg=getIntent().getStringExtra("jmbg");
        location=getIntent().getStringExtra("location");
        phone=getIntent().getStringExtra("phone");
        email=getIntent().getStringExtra("email");
        vac1=getIntent().getStringExtra("vac1");
        vac2=getIntent().getStringExtra("vac2");
        vac3=getIntent().getStringExtra("vac3");
        vac4=getIntent().getStringExtra("vac4");
        vac5=getIntent().getStringExtra("vac5");
        specMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", specMed.isSelected(), System.identityHashCode(specMed)));

            }
        });
        specMedNo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", specMedNo1.isSelected(), System.identityHashCode(specMedNo1)));

            }
        });
        unableMov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", unableMov.isSelected(), System.identityHashCode(unableMov)));

            }
        });
        unableMovNo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", unableMovNo2.isSelected(), System.identityHashCode(unableMovNo2)));

            }
        });
        bloodDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", bloodDonor.isSelected(), System.identityHashCode(bloodDonor)));

            }
        });
        bloodDonorNo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", bloodDonorNo3.isSelected(), System.identityHashCode(bloodDonorNo3)));

            }
        });
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (specMed.isChecked()){
                    specificMedi="Yes";
                }
                if (specMedNo1.isChecked()){
                    specificMedi="No";
                }
                if (bloodDonor.isChecked()){
                    bloodDonorStat="Yes";
                }
                if (bloodDonorNo3.isChecked()){
                    bloodDonorStat="No";
                }
                if (unableMov.isChecked()){
                    unableMove="Yes";
                }
                if (unableMovNo2.isChecked()){
                    unableMove="No";
                }
                Intent proceed_intent=new Intent(VaccineActivity6.this, VaccineActivity7.class);
                proceed_intent.putExtra("firstname", firstname);
                proceed_intent.putExtra("lastname", lastname);
                proceed_intent.putExtra("phone", phone);
                proceed_intent.putExtra("email", email);
                proceed_intent.putExtra("location", location);
                proceed_intent.putExtra("jmbg", jmbg);
                proceed_intent.putExtra("vac1", vac1);
                proceed_intent.putExtra("vac2", vac2);
                proceed_intent.putExtra("vac3", vac3);
                proceed_intent.putExtra("vac4", vac4);
                proceed_intent.putExtra("vac5", vac5);
                proceed_intent.putExtra("blood_status", bloodDonorStat);
                proceed_intent.putExtra("movement", unableMove);
                proceed_intent.putExtra("specific_medical", specificMedi);
                startActivity(proceed_intent);
                overridePendingTransition(0,0);
            }
        });

    }
}