package com.example.covidhelper;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={VaccineUser.class},version=2)
public abstract class VaccineDatabase extends RoomDatabase {

    private static final String dbName="vaccineusers";
    private static VaccineDatabase vaccineDatabase;

    public static synchronized VaccineDatabase getVaccineDatabaseDatabase (Context context){

        if(vaccineDatabase==null){
            vaccineDatabase= Room.databaseBuilder(context, VaccineDatabase.class, dbName).fallbackToDestructiveMigration().
                    build();
        }

        return vaccineDatabase;

    }

    public abstract VaccineDao vaccineDaoDao();

}