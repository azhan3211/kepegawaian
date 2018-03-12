package com.example.clown.first.DokumenP;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.clown.first.Jabatan.DetailJabatan;
import com.example.clown.first.MainActivity;
import com.example.clown.first.R;
import com.example.clown.first.Service.InterfaceKepegawaian;
import com.example.clown.first.Service.RetrofitService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by cLown on 3/7/2018.
 */

public class DetailDokumen extends AppCompatActivity implements View.OnClickListener {

    private EditText id,nama;
    private Button edit,hapus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_dokumen);
        initialVariable();
        hapus.setOnClickListener(this);
        edit.setOnClickListener(this);
    }

    private void hapusData(){
        RetrofitService builder = new RetrofitService();
        Retrofit retrofit = builder.getService();
        InterfaceKepegawaian interfaceKepegawaian = retrofit.create(InterfaceKepegawaian.class);
        Call<ResponseBody> call = interfaceKepegawaian.deleteDokumen(id.getText().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void initialVariable() {
        id = (EditText) findViewById(R.id.id_dokumen_detail);
        nama = (EditText) findViewById(R.id.nama_dokumen_detail);
        edit = (Button) findViewById(R.id.edit_dokumenBtn);
        hapus = (Button) findViewById(R.id.hapus_dokumenBtn);
        id.setText(getIntent().getStringExtra("idDokumen"));
        nama.setText(getIntent().getStringExtra("namaDokumen"));
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.edit_dokumenBtn:
                intent = new Intent(DetailDokumen.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.hapus_dokumenBtn:
                hapusData();
                intent = new Intent(DetailDokumen.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
