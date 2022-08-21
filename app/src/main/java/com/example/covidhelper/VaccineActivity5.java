package com.example.covidhelper;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class VaccineActivity5 extends AppCompatActivity {
    private String vac1,vac2,vac3,vac4,vac5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine5);
        getSupportActionBar().hide();
        ImageView astraZeneca, pfizer, sinopharm, moderna, sputnik;
        astraZeneca=findViewById(R.id.imageView17);
        pfizer=findViewById(R.id.imageView127);
        sinopharm=findViewById(R.id.imageView117);
        moderna=findViewById(R.id.imageView1127);
        sputnik=findViewById(R.id.imageView11247);
        CheckBox sinoYes, pfiYes, modYes, sputYes, aZYes, allYes;
        aZYes=findViewById(R.id.checkBox);
        pfiYes=findViewById(R.id.checkBox2);
        sinoYes=findViewById(R.id.checkBox5);
        modYes=findViewById(R.id.checkBox4);
        sputYes=findViewById(R.id.checkBox3);
        allYes=findViewById(R.id.checkBox6);
        Button proceedBtn=findViewById(R.id.button17);

        String firstname=getIntent().getStringExtra("firstname");
        String lastname=getIntent().getStringExtra("lastname");
        String phone=getIntent().getStringExtra("phone");
        String email=getIntent().getStringExtra("email");
        String jmbg=getIntent().getStringExtra("jmbg");
        String location=getIntent().getStringExtra("location");
        astraZeneca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(VaccineActivity5.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bottom_sheet, (LinearLayout) findViewById(R.id.bottomSheetContainer));
                ImageView vacPic=bottomSheetView.findViewById(R.id.vaccinePic);
                vacPic.setImageResource(R.drawable.astrazeneca);
                TextView vacName=bottomSheetView.findViewById(R.id.vaccineName);
                vacName.setText("Oxford-AstraZeneca Vaccine");
                TextView vacManufacture=bottomSheetView.findViewById(R.id.vaccineManInfo);
                vacManufacture.setText("Manufactured by: Oxford University / AstraZeneca");
                TextView vacDoses=bottomSheetView.findViewById(R.id.vaccineInfo);
                vacDoses.setText("Number of doses: 2");
                TextView vacInfo=bottomSheetView.findViewById(R.id.detailsVac);
                vacInfo.setText("Vaxzevria is a vaccine for preventing coronavirus disease 2019 (COVID-19) in people aged 18 years and older.\n" +
                        "\n" +
                        "Vaxzevria is made up of another virus (of the adenovirus family) that has been modified to contain the gene for making a protein from SARS-CoV-2, the virus that causes COVID-19.\n" +
                        "\n" +
                        "Vaxzevria does not contain the virus itself and cannot cause COVID-19. Vaxzevria is given as two injections, usually into the muscle of the upper arm. The second dose should be given between 4 and 12 weeks after the first dose. A booster dose may be given at least 3 months after the second dose.\n" +
                        "\n");
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });
        pfizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(VaccineActivity5.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bottom_sheet, (LinearLayout) findViewById(R.id.bottomSheetContainer));
                ImageView vacPic=bottomSheetView.findViewById(R.id.vaccinePic);
                vacPic.setImageResource(R.drawable.pfizer);
                TextView vacName=bottomSheetView.findViewById(R.id.vaccineName);
                vacName.setText("Pfizer-BioNTech Vaccine");
                TextView vacManufacture=bottomSheetView.findViewById(R.id.vaccineManInfo);
                vacManufacture.setText("Manufactured by: BioNTech/Fosun Pharma/Pfizer");
                TextView vacDoses=bottomSheetView.findViewById(R.id.vaccineInfo);
                vacDoses.setText("Number of doses: 2");
                TextView vacInfo=bottomSheetView.findViewById(R.id.detailsVac);
                vacInfo.setText("Comirnaty is a vaccine for preventing coronavirus disease 2019 (COVID-19) in people aged 5 years and older.\n" +
                        "\n" +
                        "Comirnaty contains tozinameran, a messenger RNA (mRNA) molecule with instructions for producing a protein from SARS-CoV-2, the virus that causes COVID-19. Comirnaty does not contain the virus itself and cannot cause COVID-19. Comirnaty is given as two injections, usually into the muscle of the upper arm, 3 weeks apart. Adults and adolescents from the age of 12 are given 30 micrograms per dose; children aged 5 to 11 years are given 10 micrograms per dose.\n" +
                        "\n" +
                        "An additional dose may be given to people aged 5 years and older with a severely weakened immune system, at least 28 days after their second dose." );
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });
        sinopharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(VaccineActivity5.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bottom_sheet, (LinearLayout) findViewById(R.id.bottomSheetContainer));
                ImageView vacPic=bottomSheetView.findViewById(R.id.vaccinePic);
                vacPic.setImageResource(R.drawable.sinopharm);
                TextView vacName=bottomSheetView.findViewById(R.id.vaccineName);
                vacName.setText("Sinopharm BBIBP-CorV");
                TextView vacManufacture=bottomSheetView.findViewById(R.id.vaccineManInfo);
                vacManufacture.setText("Manufactured by: Sinopharm Beijing Institute of Biological Products");
                TextView vacDoses=bottomSheetView.findViewById(R.id.vaccineInfo);
                vacDoses.setText("Number of doses: 2");
                TextView vacInfo=bottomSheetView.findViewById(R.id.detailsVac);
                vacInfo.setText("The Sinopharm COVID-19 (BBIBP-CorV, COVILO) is an inactivated vaccine made of virus particles grown in culture and lacks the disease-producing capability. This vaccine was developed by China National Pharmaceutical Group Co., Ltd. (Sinopharm) and the Beijing Institute of Biological Products Co in 2020.\n" +
                        "\n" +
                        "The Sinopharm BBIBP-CorV vaccine teaches the immune system to make antibodies against the SARS-CoV-2 beta coronavirus. For several decades, inactivated virus vaccines, such as vaccines against hepatitis A, have been successfully applied. " );
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });
        moderna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(VaccineActivity5.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bottom_sheet, (LinearLayout) findViewById(R.id.bottomSheetContainer));
                ImageView vacPic=bottomSheetView.findViewById(R.id.vaccinePic);
                vacPic.setImageResource(R.drawable.moderna);
                TextView vacName=bottomSheetView.findViewById(R.id.vaccineName);
                vacName.setText("Moderna COVID-19 vaccine");
                TextView vacManufacture=bottomSheetView.findViewById(R.id.vaccineManInfo);
                vacManufacture.setText("Manufactured by: USNIAID/BARDA");
                TextView vacDoses=bottomSheetView.findViewById(R.id.vaccineInfo);
                vacDoses.setText("Number of doses: 2");
                TextView vacInfo=bottomSheetView.findViewById(R.id.detailsVac);
                vacInfo.setText("Spikevax is a vaccine for preventing coronavirus disease 2019 (COVID-19) in people aged 6 years and older.\n" +
            "\n" +
            "Spikevax contains elasomeran, a messenger RNA (mRNA) molecule with instructions for producing a protein from SARS-CoV-2, the virus that causes COVID-19. Spikevax does not contain the virus itself and cannot cause COVID-19. Spikevax is given as two injections, usually into the muscle of the upper arm, 28 days apart. Adults and adolescents from the age of 12 are given 100 micrograms per dose; children aged 6 to 11 years are given 50 micrograms per dose.\n" +
            "\n" +
            "An additional dose may be given to people aged 6 years and older with a severely weakened immune system, at least 28 days after their second dose.");
                    bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });
        sputnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(VaccineActivity5.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bottom_sheet, (LinearLayout) findViewById(R.id.bottomSheetContainer));
                ImageView vacPic=bottomSheetView.findViewById(R.id.vaccinePic);
                vacPic.setImageResource(R.drawable.sputnik);
                TextView vacName=bottomSheetView.findViewById(R.id.vaccineName);
                vacName.setText("Sputnik V");
                TextView vacManufacture=bottomSheetView.findViewById(R.id.vaccineManInfo);
                vacManufacture.setText("Manufactured by: Gamaleya Research Institute of Epidemiology and Microbiology");
                TextView vacDoses=bottomSheetView.findViewById(R.id.vaccineInfo);
                vacDoses.setText("Number of doses: 2");
                TextView vacInfo=bottomSheetView.findViewById(R.id.detailsVac);
                vacInfo.setText("The COVID-19 vaccine Sputnik V (Gam-COVID-Vac) is an adenoviral-based, two-part vaccine against the SARS-CoV-2 coronavirus. Initially produced in Russia in 2020, Sputnik V uses a weakened virus to deliver small parts of a pathogen and stimulate an immune response. The Sputnik V (Gam-COVID-Vac) vaccine reduces the time taken for the actual development of immunity to SARS-CoV-2, the beta coronavirus behind the COVID-19 pandemic. Sputnik V is a two-component vaccine used by adenovirus serotypes 5 and 26. A fragment of tissue-type plasminogen activator is not used, and the antigen insert is an unmodified full-length S-protein. Sputnik V vaccine is produced with the HEK293 cell line.\n" +
                        "\n" +
                        " Sputnik V was the first coronavirus vaccine to use a heterogeneous boosting approach based on 2 different vectors for 2 vaccine shots. This approach generates a more sustainable immunity compared to vaccines that use the same delivery mechanism for both shots.");
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
        pfiYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", pfiYes.isSelected(), System.identityHashCode(pfiYes)));
            }
        });
        sinoYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", sinoYes.isSelected(), System.identityHashCode(sinoYes)));

            }
        });
        aZYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", aZYes.isSelected(), System.identityHashCode(aZYes)));

            }
        });
        sputYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", sputYes.isSelected(), System.identityHashCode(sputYes)));

            }
        });
        modYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", modYes.isSelected(), System.identityHashCode(modYes)));

            }
        });
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pfiYes.isChecked()){
                    vac1="Pfizer-BioNTech vaccine";
                } else{
                    vac1="Not selected";
                } if (sinoYes.isChecked()){
                    vac2="Sinopharm BBIBP-CorV";
                } else{
                    vac2="Not selected";
                } if (modYes.isChecked()){
                    vac3="Moderna COVID-19 vaccine";
                } else {
                    vac3="Not selected";
                } if (sputYes.isChecked()){
                    vac4="Sputnik V";
                } else {
                    vac4="Not selected";
                } if (aZYes.isChecked()){
                    vac5="AstraZeneca vaccine";
                } else {
                    vac5="Not selected";
                } if (allYes.isChecked()){
                    vac1="Pfizer-BioNTech vaccine";
                    vac2="Sinopharm BBIBP-CorV";
                    vac3="Moderna COVID-19 vaccine";
                    vac4="Sputnik V";
                    vac5="AstraZeneca vaccine";
                }
                Intent proceed_intent=new Intent(VaccineActivity5.this, VaccineActivity6.class);
                proceed_intent.putExtra("firstname", firstname);
                proceed_intent.putExtra("lastname", lastname);
                proceed_intent.putExtra("jmbg", jmbg);
                proceed_intent.putExtra("email", email);
                proceed_intent.putExtra("phone", phone);
                proceed_intent.putExtra("location", location);
                proceed_intent.putExtra("vac1",vac1);
                proceed_intent.putExtra("vac2", vac2);
                proceed_intent.putExtra("vac3", vac3);
                proceed_intent.putExtra("vac4", vac4);
                proceed_intent.putExtra("vac5", vac5);
                startActivity(proceed_intent);
                overridePendingTransition(0,0);

            }
        });
    }
}