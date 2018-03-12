package com.example.clown.first.Jabatan;

/**
 * Created by cLown on 3/7/2018.
 */

public class Jabatan {
    private String ID;
    private String Nama_Jabatan;

    public Jabatan(String ID, String nama_Jabatan) {
        this.ID = ID;
        this.Nama_Jabatan = nama_Jabatan;
    }

    public String getID(){
        return ID;
    }

    public String getNama_Jabatan(){
        return Nama_Jabatan;
    }
}
