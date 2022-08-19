package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().hide();
        String username=getIntent().getStringExtra("username");
        EditText deleteField;
        Button deleteBtn;
        deleteField=findViewById(R.id.editTextTextPersonName5);
        deleteBtn=findViewById(R.id.button9);
        UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao=userDatabase.userDao();
        Handler handler=new Handler();
        ImageView backBtn;
        backBtn=findViewById(R.id.backbutton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rikverc_intent=new Intent(DeleteActivity.this, SettingsActivity.class);
                rikverc_intent.putExtra("username", username);
                startActivity(rikverc_intent);
                overridePendingTransition(0,0);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=deleteField.getText().toString();
                if (user.equals("covidhelper/"+username.toString())){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.delete_by_username(username);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Your account has been deleted", Toast.LENGTH_SHORT).show();
                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            Intent redirect_intent=new Intent (DeleteActivity.this, MainActivity.class);
                                            redirect_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(redirect_intent);
                                            overridePendingTransition(0,0);
                                        }
                                    }, 3000);
                                }
                            });
                        }
                    }).start();
                } else{
                    Toast.makeText(getApplicationContext(), "Invalid text", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}