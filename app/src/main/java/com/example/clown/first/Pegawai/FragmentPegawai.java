package com.example.clown.first.Pegawai;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clown.first.Service.InterfaceKepegawaian;
import com.example.clown.first.R;
import com.example.clown.first.Service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by cLown on 3/7/2018.
 */

public class FragmentPegawai extends Fragment{

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Pegawai pegawai;
    List<Pegawai> pegawais;
    FloatingActionButton fab;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pegawai, container, false);
        initialVariable(view);
        getDataPegawai();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), TambahPegawai.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void getDataPegawai() {
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
                        pegawai = new Pegawai(
                                result.getData().get(i).getID(),
                                result.getData().get(i).getNama(),
                                result.getData().get(i).getJenis_Kelamin(),
                                result.getData().get(i).getTgl_Lahir(),
                                result.getData().get(i).getID_Jabatan(),
                                result.getData().get(i).getSalary(),
                                result.getData().get(i).getProfile_Picture()
                        );
                        pegawais.add(pegawai);
                    }
                    adapter = new PegawaiAdapter(pegawais, getActivity().getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<PegawaiApi> call, Throwable t) {

            }
        });
    }

    private void initialVariable(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.pegawaiRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        fab = (FloatingActionButton) view.findViewById(R.id.pegawaiTambahFAB);
        pegawais = new ArrayList<>();
    }
}
