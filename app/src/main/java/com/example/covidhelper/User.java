package com.example.covidhelper;

import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "username")
    String username;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "firstname")
    String firstname;

    @ColumnInfo(name = "lastname")
    String lastname;
    @ColumnInfo(name = "Email")
    String Email;
    @ColumnInfo(name = "TempStatus")
    String tempstatus;
    @ColumnInfo(name = "TasteStatus")
    String tasteStatus;
    @ColumnInfo(name = "SmellStatus")
    String smellStatus;
    @ColumnInfo(name = "validationCode")
    String validationCode;
    @ColumnInfo(name = "Municipality")
    String municipality;
    @ColumnInfo(name = "Hospital")
    String hospital;
    @ColumnInfo(name = "Doctor")
    String doctor;
    @ColumnInfo(name = "DoctorPhone")
    String doctorPhone;
    @ColumnInfo(name = "DoctorEmail")
    String doctorEmail;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }
    public String getDoctor(){
        return doctor;
    }
    public void setDoctor(String doctor){
        this.doctor=doctor;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getTempStatus(){
        return tempstatus;
    }
    public void setTempStatus(String tempstatus){
        this.tempstatus=tempstatus;
    }

    public void setValidationCode(String validationCode){
        this.validationCode=validationCode;
    }
    public String getValidationCode(){
        return validationCode;
    }
    public String getTasteStatus(){
        return tasteStatus;
    }
    public void setTasteStatus(String tasteStatus){
        this.tasteStatus=tasteStatus;
    }
    public String getSmellStatus(){
        return this.smellStatus;
    }
    public void setSmellStatus(String smellStatus){
        this.smellStatus=smellStatus;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String newFirstName) {
        firstname = newFirstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String newLastName) {
        this.lastname = newLastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}