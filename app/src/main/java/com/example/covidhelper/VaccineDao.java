package com.example.covidhelper;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface VaccineDao {
    @Insert
    void registerVaccineUser(VaccineUser user);
}
