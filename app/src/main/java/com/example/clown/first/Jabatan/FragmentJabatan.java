package com.example.clown.first.Jabatan;


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

public class FragmentJabatan extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Jabatan jabatan;
    List<Jabatan> jabatans;
    FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jabatan, container, false);
        initialVariable(view);
        getDataJabatan();
        return view;
    }

    private void getDataJabatan() {
        RetrofitService builder = new RetrofitService();
        Retrofit retrofit = builder.getService();
        InterfaceKepegawaian interfaceKepegawaian = retrofit.create(InterfaceKepegawaian.class);
        Call<JabatanApi> call = interfaceKepegawaian.getJabatanApi();
        call.enqueue(new Callback<JabatanApi>() {
            @Override
            public void onResponse(Call<JabatanApi> call, Response<JabatanApi> response) {
                if(response.isSuccessful()){
                    JabatanApi result = response.body();
                    for(int i = 0; i < result.getData().size() ; i++){
                        jabatan = new Jabatan(
                                result.getData().get(i).getID(),
                                result.getData().get(i).getNama_Jabatan()
                        );
                        jabatans.add(jabatan);
                    }
                    adapter = new JabatanAdapter(jabatans, getActivity().getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<JabatanApi> call, Throwable t) {

            }
        });
    }

    private void initialVariable(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.jabatanRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        fab = (FloatingActionButton) view.findViewById(R.id.jabatanTambahFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), TambahJabatan.class);
                startActivity(intent);
            }
        });
        jabatans = new ArrayList<>();
    }
}
