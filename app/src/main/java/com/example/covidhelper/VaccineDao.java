package com.example.covidhelper;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface VaccineDao {
    @Insert
    void registerVaccineUser(VaccineUser user);

    @Query("SELECT * from vaccineusers where jmbg=(:jmbg)")
    VaccineUser check(String jmbg);


}
