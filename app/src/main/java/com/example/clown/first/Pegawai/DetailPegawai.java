package com.example.clown.first.Pegawai;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clown.first.Service.InterfaceKepegawaian;
import com.example.clown.first.R;
import com.example.clown.first.Service.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by cLown on 3/7/2018.
 */

public class DetailPegawai extends AppCompatActivity {

    TextView id, nama, jenisKelamin, tglLahir, idJabatan, salary;
    ImageView profilPicture;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pegawai);
        initialVariable();
        getDataPegawai();
    }

    private void initialVariable() {
        id = (TextView) findViewById(R.id.id_pegawai);
        nama = (TextView) findViewById(R.id.nama_pegawai);
        jenisKelamin = (TextView) findViewById(R.id.jenis_kelamin_pegawai);
        tglLahir = (TextView) findViewById(R.id.tgl_lahir_pegawai);
        idJabatan = (TextView) findViewById(R.id.id_jabatan_pegawai);
        salary = (TextView) findViewById(R.id.salary_pegawai);
        profilPicture = (ImageView) findViewById(R.id.profil_picture);
    }

    private void getDataPegawai(){
        String url = "";
        RetrofitService builder = new RetrofitService();
        Retrofit retrofit = builder.getService();
        InterfaceKepegawaian interfaceKepegawaian = retrofit.create(InterfaceKepegawaian.class);
        Call<PegawaiApi> call = interfaceKepegawaian.getPegawaiApi();
        call.enqueue(new Callback<PegawaiApi>() {
            @Override
            public void onResponse(Call<PegawaiApi> call, Response<PegawaiApi> response) {
                if(response.isSuccessful()){
                    PegawaiApi result = response.body();
                    for(int i = 0; i < result.getData().size(); i++){
                        if(getIntent().getStringExtra("idPegawai").equals(result.getData().get(i).getID())){
                            id.setText(result.getData().get(i).getID());
                            nama.setText(result.getData().get(i).getNama());
                            jenisKelamin.setText(result.getData().get(i).getJenis_Kelamin());
                            tglLahir.setText(result.getData().get(i).getTgl_Lahir());
                            idJabatan.setText(result.getData().get(i).getID_Jabatan());
                            salary.setText("Rp. "+result.getData().get(i).getSalary());
                            break;
//                            Picasso.with(DetailPegawai.this).load()result.getData().get(i).getProfile_Picture());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<PegawaiApi> call, Throwable t) {

            }
        });
    }
}
