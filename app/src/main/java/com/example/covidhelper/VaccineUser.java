package com.example.covidhelper;
import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
@Entity(tableName = "vaccineusers")
public class VaccineUser {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "vac_name")
    String vac_name;
    @ColumnInfo(name = "vac_surname")
    String vac_surname;
    @ColumnInfo(name = "jmbg")
    String jmbg;
    @ColumnInfo(name = "vac_email")
    String vac_email;
    @ColumnInfo(name="vac_phone")
    String vac_phone;
    @ColumnInfo(name="vac_location")
    String vac_location;
    @ColumnInfo(name="vac_ds_status")
    String vac_ds_status;
    @ColumnInfo(name="movement_status")
    String movement_status;
    @ColumnInfo(name="blood_status")
    String blood_status;
    @ColumnInfo(name="vac1")
    String vac1;
    @ColumnInfo(name="vac2")
    String vac2;
    @ColumnInfo(name="vac3")
    String vac3;
    @ColumnInfo(name="vac4")
    String vac4;
    @ColumnInfo(name="vac5")
    String vac5;
    @ColumnInfo(name="vacDate")
    String vacDate;

    public String getVac1() {
        return vac1;
    }

    public String getVac2() {
        return vac2;
    }

    public String getVac3() {
        return vac3;
    }

    public String getVac4() {
        return vac4;
    }

    public String getVac5() {
        return vac5;
    }

    public void setVac1(String vac1) {
        this.vac1 = vac1;
    }

    public void setVac2(String vac2) {
        this.vac2 = vac2;
    }

    public void setVac3(String vac3) {
        this.vac3 = vac3;
    }

    public void setVac4(String vac4) {
        this.vac4 = vac4;
    }

    public void setVac5(String vac5) {
        this.vac5 = vac5;
    }

    public Integer getId() {
        return id;
    }

    public String getBlood_status() {
        return blood_status;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getMovement_status() {
        return movement_status;
    }

    public String getVac_ds_status() {
        return vac_ds_status;
    }

    public String getVac_email() {
        return vac_email;
    }

    public String getVac_location() {
        return vac_location;
    }

    public String getVac_name() {
        return vac_name;
    }

    public String getVac_phone() {
        return vac_phone;
    }

    public String getVac_surname() {
        return vac_surname;
    }

    public String getVacDate() {
        return vacDate;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBlood_status(String blood_status) {
        this.blood_status = blood_status;
    }

    public void setMovement_status(String movement_status) {
        this.movement_status = movement_status;
    }

    public void setVac_ds_status(String vac_ds_status) {
        this.vac_ds_status = vac_ds_status;
    }

    public void setVac_email(String vac_email) {
        this.vac_email = vac_email;
    }

    public void setVac_location(String vac_location) {
        this.vac_location = vac_location;
    }

    public void setVac_name(String vac_name) {
        this.vac_name = vac_name;
    }

    public void setVac_phone(String vac_phone) {
        this.vac_phone = vac_phone;
    }

    public void setVac_surname(String vac_surname) {
        this.vac_surname = vac_surname;
    }

    public void setVacDate(String vacDate) {
        this.vacDate = vacDate;
    }
}
