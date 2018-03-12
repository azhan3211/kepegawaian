package com.example.clown.first.Pegawai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clown.first.Jabatan.Jabatan;
import com.example.clown.first.R;
import com.example.clown.first.Service.InterfaceKepegawaian;
import com.example.clown.first.Service.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;

/**
 * Created by cLown on 3/7/2018.
 */

public class TambahPegawai extends AppCompatActivity {
    Button tambahBtn;
    EditText id, nama, jk, tglLahir, idJabatan, salary;
    Pegawai pegawai;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_pegawai);
        initialVariable();
        tambahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!id.getText().equals("") && id.getText() != null){
                    pegawai = new Pegawai(
                            id.getText().toString(),
                            nama.getText().toString(),
                            jk.getText().toString(),
                            tglLahir.getText().toString(),
                            idJabatan.getText().toString(),
                            salary.getText().toString(),
                            null);
                    postData(pegawai);
                }
            }
        });
    }

    private void postData(Pegawai pegawai) {
        RetrofitService builder = new RetrofitService();
        Retrofit retrofit = builder.getService();
        InterfaceKepegawaian interfaceKepegawaian = retrofit.create(InterfaceKepegawaian.class);
        Call<Pegawai> call = interfaceKepegawaian.setPegawai(pegawai);
        call.enqueue(new Callback<Pegawai>() {
            @Override
            public void onResponse(Call<Pegawai> call, Response<Pegawai> response) {

            }

            @Override
            public void onFailure(Call<Pegawai> call, Throwable t) {

            }
        });
    }

    private void initialVariable() {
        id = (EditText) findViewById(R.id.id_jabatan_tambah);
        nama = (EditText) findViewById(R.id.nama_jabatan_tambah);
        jk = (EditText) findViewById(R.id.jenis_kelamin_pegawai_tambah);
        tglLahir = (EditText) findViewById(R.id.tgl_lahir_pegawai_tambah);
        idJabatan = (EditText) findViewById(R.id.id_jabatan_tambah);
        salary = (EditText) findViewById(R.id.salary_pegawai_tambah);
        tambahBtn = (Button) findViewById(R.id.tambah_pegawaiBtn);
    }
}
