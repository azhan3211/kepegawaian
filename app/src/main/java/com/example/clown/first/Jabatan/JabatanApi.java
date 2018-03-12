package com.example.clown.first.Jabatan;

import java.util.List;

/**
 * Created by cLown on 3/7/2018.
 */

public class JabatanApi {
    private List<Data> data;
    public List<Data> getData() {return data;};
    public class Data{
        private String ID;
        private String Nama_Jabatan;

        public String getID(){
            return ID;
        }

        public String getNama_Jabatan(){
            return Nama_Jabatan;
        }
    }
}
