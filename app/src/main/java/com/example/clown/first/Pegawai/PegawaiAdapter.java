package com.example.clown.first.Pegawai;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.clown.first.R;

import java.util.List;

/**
 * Created by cLown on 3/7/2018.
 */

public class PegawaiAdapter extends RecyclerView.Adapter<PegawaiAdapter.ViewHolder> {

    List<Pegawai> pegawais;
    Context context;

    public PegawaiAdapter(List<Pegawai> pegawais, Context context) {
        this.pegawais = pegawais;
        this.context = context;
    }

    @Override
    public PegawaiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pegawai_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PegawaiAdapter.ViewHolder holder, int position) {
        final Pegawai pegawai = pegawais.get(position);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPegawai.class);
                intent.putExtra("idPegawai", pegawai.getID());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.id.setText(pegawai.getID());
        holder.nama.setText(pegawai.getNama());
    }

    @Override
    public int getItemCount() {
        return pegawais.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView id;
        public TextView nama;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.idContainer);
            id = (TextView) itemView.findViewById(R.id.id_pegawai);
            nama = (TextView) itemView.findViewById(R.id.nama_pegawai);
        }
    }
}
