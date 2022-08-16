package com.example.covidhelper;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser(User user);




    @Query("SELECT * from users where username=(:username) and password=(:password)")
    User login(String username, String password);


    @Query("SELECT * FROM users WHERE username =:username")
    User getUsername(String username);

    @Query("SELECT * FROM users WHERE validationCode =:code")
    User getvalidationCode(String code);
}