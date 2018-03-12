package com.example.clown.first.DokumenP;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clown.first.Jabatan.Jabatan;
import com.example.clown.first.Jabatan.TambahJabatan;
import com.example.clown.first.MainActivity;
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

public class TambahDokumen extends AppCompatActivity {

    Button tambahBtn;
    EditText id, nama;
    Dokumen dokumen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_dokumen);
        initialVariable();
        tambahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!id.getText().equals("") && id.getText() != null){
                    dokumen = new Dokumen(id.getText().toString(), nama.getText().toString());
                    postData(dokumen);
                }
            }
        });
    }

    private void postData(Dokumen dokumen) {
        RetrofitService builder = new RetrofitService();
        Retrofit retrofit = builder.getService();
        InterfaceKepegawaian interfaceKepegawaian = retrofit.create(InterfaceKepegawaian.class);
        Call<Dokumen> call = interfaceKepegawaian.setDokumen(dokumen);
        call.enqueue(new Callback<Dokumen>() {
            @Override
            public void onResponse(Call<Dokumen> call, Response<Dokumen> response) {
                Log.d("success","data telah disimpan");
                Toast.makeText(TambahDokumen.this, "Dokumen telah ditambah", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TambahDokumen.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Dokumen> call, Throwable t) {

            }
        });

    }

    private void initialVariable() {
        id = (EditText) findViewById(R.id.id_dokumen_tambah);
        nama = (EditText) findViewById(R.id.nama_dokumen_tambah);
        tambahBtn = (Button) findViewById(R.id.tambah_dokumenBtn);
    }


}
