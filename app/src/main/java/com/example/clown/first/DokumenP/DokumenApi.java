package com.example.clown.first.DokumenP;

import java.util.List;

/**
 * Created by cLown on 3/7/2018.
 */

public class DokumenApi {
    private List<Data> data;
    public List<Data> getData(){return data;} ;
    public class Data{
        private String ID_Klp_Dok;
        private String Nama_Klp_Dok;

        public String getID_Klp_Dok(){
            return ID_Klp_Dok;
        }

        public String getNama_Klp_Dok(){
            return Nama_Klp_Dok;
        }
    }
}
