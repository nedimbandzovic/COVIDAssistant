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

    @Query("SELECT * FROM users WHERE Email =:email")
    User getEmail(String email);

    @Query("SELECT Email FROM users WHERE username =:username")
    String get_email_by_username(String username);

    @Query("SELECT firstname FROM users WHERE username =:username")
    String get_firstname_by_username(String username);

    @Query("SELECT TempStatus FROM users WHERE username =:username")
    String get_temp_by_username (String username);

    @Query("SELECT lastname FROM users WHERE username =:username")
    String get_secondname_by_username(String username);

    @Query("SELECT Municipality FROM users WHERE username =:username")
    String get_municipality_by_username(String username);

    @Query("UPDATE users SET TempStatus= :temperature WHERE username=:username")
    void set_temperature(String temperature,String username);

    @Query("UPDATE users SET SmellStatus= :smell WHERE username=:username")
    void set_smell(String smell,String username);

    @Query("UPDATE users SET TasteStatus= :taste WHERE username=:username")
    void set_taste(String taste,String username);


}