package com.example.clown.first.DokumenP;

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

public class FragmentDokumen extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Dokumen dokumen;
    List<Dokumen> dokumens;
    FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dokumen, container, false);
        initialVariable(view);
        getDataDokumen();
        return view;
    }

    private void getDataDokumen() {
        RetrofitService builder = new RetrofitService();
        Retrofit retrofit = builder.getService();
        InterfaceKepegawaian interfaceKepegawaian = retrofit.create(InterfaceKepegawaian.class);
        Call<DokumenApi> call = interfaceKepegawaian.getDokumenApi();
        call.enqueue(new Callback<DokumenApi>() {
            @Override
            public void onResponse(Call<DokumenApi> call, Response<DokumenApi> response) {
                if(response.isSuccessful()){
                    DokumenApi result = response.body();
                    for(int i = 0; i < result.getData().size() ; i++){
                        dokumen = new Dokumen(
                                result.getData().get(i).getID_Klp_Dok(),
                                result.getData().get(i).getNama_Klp_Dok()
                        );
                        dokumens.add(dokumen);
                    }
                    adapter = new DokumenAdapter(dokumens, getActivity().getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<DokumenApi> call, Throwable t) {

            }
        });
    }

    private void initialVariable(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.dokumenRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        fab = (FloatingActionButton) view.findViewById(R.id.dokumenTambahFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), TambahDokumen.class);
                startActivity(intent);
            }
        });
        dokumens = new ArrayList<>();
    }
}
