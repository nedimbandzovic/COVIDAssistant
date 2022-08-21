package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class VaccineActivity4 extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    private LatLng ns;
    private String hos_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine4);
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(VaccineActivity4.this);
        Spinner mySpinner;
        String firstname, lastname, email, phone, jmbg;
        firstname=getIntent().getStringExtra("firstname");
        lastname=getIntent().getStringExtra("lastname");
        email=getIntent().getStringExtra("email");
        phone=getIntent().getStringExtra("phone");
        jmbg=getIntent().getStringExtra("jmbg");
        Button prodBtn;
        prodBtn=findViewById(R.id.button16);
        mySpinner=findViewById(R.id.spinner2);
        ImageView check;
        String[] items = new String[]{"Dom zdravlja Centar", "Dom zdravlja Stari Grad", "Dom zdravlja Novi Grad", "Dom zdravlja Novo Sarajevo", "Dom zdravlja Ilidža", "Dom zdravlja Vogošća", "Dom zdravlja Ilijaš", "Dom zdravlja Hadžići", "Dom zdravlja Trnovo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mySpinner.setAdapter(adapter);
        check=findViewById(R.id.imageView16);
        hos_name="Baščaršija";
        prodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed_intent=new Intent(VaccineActivity4.this, VaccineActivity5.class);
                proceed_intent.putExtra("firstname",firstname);
                proceed_intent.putExtra("lastname", lastname);
                proceed_intent.putExtra("email", email);
                proceed_intent.putExtra("phone", phone);
                proceed_intent.putExtra("jmbg", jmbg);
                proceed_intent.putExtra("location", hos_name);
                startActivity(proceed_intent);
                overridePendingTransition(0,0);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hos_name=mySpinner.getSelectedItem().toString();
                if (hos_name.equals("Dom zdravlja Stari Grad")){
                    ns=new LatLng(43.857811310838606,     18.431670997803696);
                    map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Stari Grad"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                } else if (hos_name.equals("Dom zdravlja Centar")){
                    ns=new LatLng(43.85707061414461,     18.411339797803702);
                    map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Centar"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                }
                else if (hos_name.equals("Dom zdravlja Trnovo")){
                    ns=new LatLng(43.67109818599901,     18.44918522663254);
                    map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Trnovo"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                } else if (hos_name.equals("Dom zdravlja Ilidža")){
                    ns=new LatLng( 43.83022949312506,     18.310482782462454);
                    map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Ilidža"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                } else if (hos_name.equals("Dom zdravlja Ilijaš")){
                    ns=new LatLng( 43.95682546847525,      18.26705654013683);
                    map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Ilijaš"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                } else if (hos_name.equals("Dom zdravlja Novo Sarajevo")){
                    ns=new LatLng( 43.85085907208033,18.377306453627963);
                    map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Novo Sarajevo"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                } else if (hos_name.equals("Dom zdravlja Novi Grad")) {
                    ns = new LatLng(43.849484645379775, 18.36454872472018);
                    map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Novi Grad"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                }
                else if (hos_name.equals("Dom zdravlja Vogošća")){
                    ns=new LatLng( 43.90248586487118,18.34400251314563);
                    map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Vogošća"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                } else if (hos_name.equals("Dom zdravlja Hadžići")){
                    ns=new LatLng( 43.822747393280515,18.200799882462164);
                    map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Hadžići"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                } else if (hos_name.equals("Baščaršija")){
                    ns=new LatLng( 43.861781036656545,18.43004855672874);
                    map.addMarker(new MarkerOptions().position(ns).title("Sarajevo"));
                    map.moveCamera(CameraUpdateFactory.newLatLng(ns));
                }
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
    }
}