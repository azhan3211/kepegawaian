package com.example.clown.first.Jabatan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class DetailJabatan extends AppCompatActivity implements View.OnClickListener {

    private EditText id,nama;
    private Button edit,hapus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_jabatan);
        initialVariable();
        edit.setOnClickListener(this);
        hapus.setOnClickListener(this);
    }

    private void initialVariable() {
        id = (EditText) findViewById(R.id.id_jabatan_detail);
        nama = (EditText) findViewById(R.id.nama_jabatan_detail);
        edit = (Button) findViewById(R.id.edit_jabatanBtn);
        hapus = (Button) findViewById(R.id.hapus_jabatanBtn);
        id.setText(getIntent().getStringExtra("idJabatan"));
        nama.setText(getIntent().getStringExtra("namaJabatan"));
    }

    private void editData(){
        RetrofitService builder = new RetrofitService();
        Retrofit retrofit = builder.getService();
        InterfaceKepegawaian interfaceKepegawaian = retrofit.create(InterfaceKepegawaian.class);
        Call<JabatanApi> call = interfaceKepegawaian.editJabatan(id.getText().toString(), nama.getText().toString());
        call.enqueue(new Callback<JabatanApi>() {
            @Override
            public void onResponse(Call<JabatanApi> call, Response<JabatanApi> response) {

            }

            @Override
            public void onFailure(Call<JabatanApi> call, Throwable t) {

            }
        });
    }

    private void hapusData(){
        RetrofitService builder = new RetrofitService();
        Retrofit retrofit = builder.getService();
        InterfaceKepegawaian interfaceKepegawaian = retrofit.create(InterfaceKepegawaian.class);
        Call<ResponseBody> call = interfaceKepegawaian.deleteJabatan("100");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.edit_jabatanBtn:
                editData();
                intent = new Intent(DetailJabatan.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.hapus_jabatanBtn:
                hapusData();
                intent = new Intent(DetailJabatan.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
