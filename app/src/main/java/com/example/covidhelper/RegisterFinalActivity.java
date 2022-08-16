package com.example.covidhelper;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class RegisterFinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_final);
        getSupportActionBar().hide();
        Random rand = new Random();
        String first_name=getIntent().getStringExtra("firstname");
        String second_name=getIntent().getStringExtra("secondname");
        String email=getIntent().getStringExtra("email");
        String municipality=getIntent().getStringExtra("municipality");
        String validation_code=getIntent().getStringExtra("validationcode");
        String username=getIntent().getStringExtra("username");
        String password=getIntent().getStringExtra("password");
        TextView municipalityname, hospitalname, hospitallocation, doctorname, phonenumber, emailaddress;
        CheckBox checkBox;
        ImageView munCoatOfArms;
        munCoatOfArms=findViewById(R.id.imageView6);
        municipalityname=findViewById(R.id.textView11);
        hospitalname=findViewById(R.id.textView45);
        hospitallocation=findViewById(R.id.textView465);
        doctorname=findViewById(R.id.textView12);
        phonenumber=findViewById(R.id.textView132);
        emailaddress=findViewById(R.id.textView1342);
        Button registerBtn=findViewById(R.id.button3);
        registerBtn.setEnabled(false);
        if (municipality.toString().equals("Stari Grad")){
            munCoatOfArms.setImageResource(R.drawable.starig);
            municipalityname.setText("STARI GRAD");
            hospitalname.setText("Hospital name: Dom zdravlja Stari Grad");
            hospitallocation.setText("Hospital location: Alajbegovića 1");
        } else if (municipality.toString().equals("Trnovo")){
            munCoatOfArms.setImageResource(R.drawable.trnovo);
            hospitalname.setText("Hospital name: Dom zdravlja Trnovo");
            hospitallocation.setText("Hospital location:MCCX+9MF, Trnovo");
            municipalityname.setText("TRNOVO");
        } else if (municipality.toString().equals("Ilidža")){
            munCoatOfArms.setImageResource(R.drawable.ilidza);
            hospitalname.setText("Hospital name: Dom zdravlja Ilidža");
            hospitallocation.setText("Hospital location: Dr.Mustafe Pintola 1");
            municipalityname.setText("ILIDŽA");
        } else if (municipality.toString().equals("Ilijaš")){
            munCoatOfArms.setImageResource(R.drawable.ilijas);
            hospitalname.setText("Hospital name: Dom zdravlja Ilijaš");
            hospitallocation.setText("Hospital location: Bogumilska");
            municipalityname.setText("ILIJAŠ");
        }else if (municipality.toString().equals("Novo Sarajevo")){
            hospitalname.setText("Hospital name: Dom zdravlja Omer Maslić");
            hospitallocation.setText("Hospital location: Bihaćka 2");
            munCoatOfArms.setImageResource(R.drawable.ns);
            municipalityname.setText("NOVO SARAJEVO");
        }else if (municipality.toString().equals("Novi Grad")){
            munCoatOfArms.setImageResource(R.drawable.ng);
            hospitalname.setText("Hospital name: Dom zdravlja Novi Grad");
            hospitallocation.setText("Hospital location: Bulevar Meše Selimovića 2");
            municipalityname.setText("NOVI GRAD");
        }else if (municipality.toString().equals("Centar")){
            int abcd = rand.nextInt(2);
            if (abcd==0){
                hospitalname.setText("Hospital name: KCUS");
                hospitallocation.setText("Hospital location: Bolnička 25");
            } else{
                hospitalname.setText("Hospital name: Opća bolnica Prim Dr. Abdulah Nakaš");
                hospitallocation.setText("Hospital location: Kranjčevićeva 12");
            }
            munCoatOfArms.setImageResource(R.drawable.centar);
            municipalityname.setText("CENTAR");
        }else if (municipality.toString().equals("Vogošća")){
            hospitalname.setText("Hospital name: Dom zdravlja Vogošća");
            hospitallocation.setText("Hospital location: Igmanska 52");
            munCoatOfArms.setImageResource(R.drawable.vogosca);
            municipalityname.setText("VOGOŠĆA");
        }else if (municipality.toString().equals("Hadžići")){
            hospitalname.setText("Hospital name: Dom zdravlja Hadžići");
            hospitallocation.setText("Hospital location: Anđelka Lažetića 2");
            munCoatOfArms.setImageResource(R.drawable.hadzici);
            municipalityname.setText("HADŽIĆI");

        }
        String[] names = {"Bećir","Dino","Samed","Nedim","Naida","Mirza","Ajdin","Ismihana","Sedin","Amela","Mustafa","Edin","Adnan"};
        String[] surnames={"Isaković","Kečo","Jukić","Bandžović","Fatić","Krupić","Pašić","Međedović","Kazazović","Vatreš","Isić","Smajić","Ždero"};
        int rnd = new Random().nextInt(names.length);
        int rnd3 = new Random().nextInt(surnames.length);
        String doctorN=names[rnd];
        String doctorS=surnames[rnd3];
        String doctor_array=doctorN + " " + doctorS;
        doctorname.setText(doctor_array);
        String[]emails={"gmail","outlook","yahoo"};
        int rnd2 = new Random().nextInt(emails.length);
        String doctorE=emails[rnd2];
        String doctor_final_email=doctorN.toLowerCase()+"."+doctorS.toLowerCase()+"@"+doctorE+".com";
        emailaddress.setText(doctor_final_email.toString());
        int phonenumber_part1=rand.nextInt((62-61)+1)+61;
        int phonenumber_part2=rand.nextInt((999-100)+1)+100;
        int phonenumber_part3=rand.nextInt((999-100)+1)+100;
        String phpart1=String.valueOf(phonenumber_part1);
        String phpart2=String.valueOf(phonenumber_part2);
        String phpart3=String.valueOf(phonenumber_part3);
        String phone_final="+387"+phpart1+phpart2+phpart3;
        phonenumber.setText("Phone number:" + phone_final.toString());
        checkBox=findViewById(R.id.checkbox_meat);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, String.format("checkbox onClick, isSelected: %s, identityHashCode: %s", checkBox.isSelected(), System.identityHashCode(checkBox)));
                registerBtn.setEnabled(true);
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              User user=new User();
              user.setUsername(username.toString());
              user.setPassword(password.toString());
              user.setDoctor(doctor_array.toString());
              user.setDoctorEmail(doctor_final_email.toString());
              user.setFirstname(first_name.toString());
              user.setLastname(second_name.toString());
              user.setHospital(hospitalname.getText().toString());
              user.setDoctorPhone(phonenumber.getText().toString());
              user.setMunicipality(municipality.toString());
              user.setSmellStatus("0");
              user.setTasteStatus("0");
              user.setTempStatus("0");
              user.setValidationCode(validation_code.toString());
              user.setEmail(email.toString());
              UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
              UserDao userDao = userDatabase.userDao();
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      userDao.registerUser(user);
                      runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              Toast.makeText(getApplicationContext(),"You registered successfully",Toast.LENGTH_SHORT).show();
                          }
                      });
                  }
              }).start();
            }
        });










    }
    private Boolean validateCheckBox(CheckBox checkBox){
        if (checkBox.isChecked()){
            return true;
        }
        return false;
    }
}