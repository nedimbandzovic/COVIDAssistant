package com.example.covidhelper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button editProfile, deleteAcc, logout;
        String username=getIntent().getStringExtra("username");
        getSupportActionBar().hide();
        logout=findViewById(R.id.button8);
        editProfile=findViewById(R.id.button7);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent change_pwd_intent=new Intent(SettingsActivity.this, ChangeActivity.class);
                change_pwd_intent.putExtra("username", username);
                startActivity(change_pwd_intent);
                overridePendingTransition(0,0);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);

                builder.setTitle("Confirm before proceeding");
                builder.setMessage("Are you sure you want to log out?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent log_out_intent=new Intent (SettingsActivity.this, MenuActivity.class);
                        log_out_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(log_out_intent);
                        overridePendingTransition(0,0);
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
    }
}