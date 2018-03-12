package com.example.clown.first.Jabatan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clown.first.MainActivity;
import com.example.clown.first.Pegawai.Pegawai;
import com.example.clown.first.R;
import com.example.clown.first.Service.InterfaceKepegawaian;
import com.example.clown.first.Service.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by cLown on 3/7/2018.
 */

public class TambahJabatan extends AppCompatActivity {
    Button tambahBtn;
    EditText id, nama;
    Jabatan jabatan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_jabatan);
        initialVariable();
        tambahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!id.getText().equals("") && id.getText() != null){
                    jabatan = new Jabatan(id.getText().toString(), nama.getText().toString());
                    postData(jabatan);
                }
            }
        });
    }

    private void postData(Jabatan jabatan) {
        RetrofitService builder = new RetrofitService();
        Retrofit retrofit = builder.getService();
        InterfaceKepegawaian interfaceKepegawaian = retrofit.create(InterfaceKepegawaian.class);
        Call<Jabatan> call = interfaceKepegawaian.setJabatan(jabatan);
        call.enqueue(new Callback<Jabatan>() {
            @Override
            public void onResponse(Call<Jabatan> call, Response<Jabatan> response) {
                Log.d("success","data telah disimpan");
                Toast.makeText(TambahJabatan.this, "Jabatan telah ditambah", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TambahJabatan.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Jabatan> call, Throwable t) {

            }
        });
    }

    private void initialVariable() {
        id = (EditText) findViewById(R.id.id_jabatan_tambah);
        nama = (EditText) findViewById(R.id.nama_jabatan_tambah);
        tambahBtn = (Button) findViewById(R.id.tambah_jabatanBtn);
    }
}
