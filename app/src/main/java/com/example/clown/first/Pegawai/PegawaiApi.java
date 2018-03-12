package com.example.clown.first.Pegawai;

import java.util.List;

/**
 * Created by cLown on 3/7/2018.
 */

public class PegawaiApi {

    private List<Data> data;
    public List<Data> getData() {return data;};
    public class Data{
        private String ID;
        private String Nama;
        private String Jenis_Kelamin;
        private String Tgl_Lahir;
        private String ID_Jabatan;
        private String Salary;
        private String Profile_Picture;

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
}
