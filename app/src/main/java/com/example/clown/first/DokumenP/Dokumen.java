package com.example.clown.first.DokumenP;

/**
 * Created by cLown on 3/7/2018.
 */

public class Dokumen {
    private String ID_Klp_Dok;
    private String Nama_Klp_Dok;

    public Dokumen(String ID_Klp_Dok, String nama_Klp_Dok) {
        this.ID_Klp_Dok = ID_Klp_Dok;
        this.Nama_Klp_Dok = nama_Klp_Dok;
    }

    public String getID_Klp_Dok(){
        return ID_Klp_Dok;
    }

    public String getNama_Klp_Dok(){
        return Nama_Klp_Dok;
    }
}
