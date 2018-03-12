package com.example.clown.first.Pegawai;

/**
 * Created by cLown on 3/7/2018.
 */

public class Pegawai {

    private String ID;
    private String Nama;
    private String Jenis_Kelamin;
    private String Tgl_Lahir;
    private String ID_Jabatan;
    private String Salary;
    private String Profile_Picture;

    public Pegawai(String ID, String nama, String jenis_Kelamin, String tgl_Lahir, String ID_Jabatan, String salary, String profile_Picture) {
        this.ID = ID;
        Nama = nama;
        Jenis_Kelamin = jenis_Kelamin;
        Tgl_Lahir = tgl_Lahir;
        this.ID_Jabatan = ID_Jabatan;
        Salary = salary;
        Profile_Picture = profile_Picture;
    }

    public String getID() {
        return ID;
    }

    public String getNama() {
        return Nama;
    }

    public String getJenis_Kelamin() {
        return Jenis_Kelamin;
    }

    public String getTgl_Lahir() {
        return Tgl_Lahir;
    }

    public String getID_Jabatan() {
        return ID_Jabatan;
    }

    public String getSalary() {
        return Salary;
    }

    public String getProfile_Picture() {
        return Profile_Picture;
    }

}
