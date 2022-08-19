package com.example.covidhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class Map extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    private String hos_name;
    private LatLng ns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
        UserDao userDao=userDatabase.userDao();
        String username=getIntent().getStringExtra("username");
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(Map.this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                hos_name=userDao.get_doctor_hospital_by_username(username);
            }
        }).start();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        map=googleMap;
        if (hos_name.equals("Hospital name: Dom zdravlja Stari Grad")){
            ns=new LatLng(43.857811310838606,     18.431670997803696);
            map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Stari Grad"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        } else if (hos_name.equals("Hospital name: Dom zdravlja Trnovo")){
            ns=new LatLng(43.67109818599901,     18.44918522663254);
            map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Trnovo"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        } else if (hos_name.equals("Hospital name: Dom zdravlja Ilidža")){
            ns=new LatLng( 43.83022949312506,     18.310482782462454);
            map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Ilidža"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        } else if (hos_name.equals("Hospital name: Dom zdravlja Ilijaš")){
            ns=new LatLng( 43.95682546847525,      18.26705654013683);
            map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Ilijaš"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        } else if (hos_name.equals("Hospital name: Dom zdravlja Omer Maslić")){
            ns=new LatLng( 43.85085907208033,18.377306453627963);
            map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Novo Sarajevo"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        } else if (hos_name.equals("Hospital name: Dom zdravlja Novi Grad")){
            ns=new LatLng( 43.849484645379775,18.36454872472018);
            map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Novi Grad"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        } else if (hos_name.equals("Hospital name: KCUS")){
            ns=new LatLng( 43.86945479325538,18.415732849809768);
            map.addMarker(new MarkerOptions().position(ns).title("KCUS"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        }else if (hos_name.equals("Hospital name: Opća bolnica Prim Dr. Abdulah Nakaš")){
            ns=new LatLng( 43.858381978434146,18.408310595887635);
            map.addMarker(new MarkerOptions().position(ns).title("Opća bolnica Prim Dr. Abdulah Nakaš"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        }else if (hos_name.equals("Hospital name: Dom zdravlja Vogošća")){
            ns=new LatLng( 43.90248586487118,18.34400251314563);
            map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Vogošća"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        } else if (hos_name.equals("Hospital name: Dom zdravlja Hadžići")){
            ns=new LatLng( 43.822747393280515,18.200799882462164);
            map.addMarker(new MarkerOptions().position(ns).title("Dom zdravlja Hadžići"));
            map.moveCamera(CameraUpdateFactory.newLatLng(ns));
        }



    }
}