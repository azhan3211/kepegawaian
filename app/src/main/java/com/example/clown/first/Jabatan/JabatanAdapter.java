package com.example.clown.first.Jabatan;

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

public class JabatanAdapter extends RecyclerView.Adapter<JabatanAdapter.ViewHolder> {

    List<Jabatan> jabatans;
    Context context;

    public JabatanAdapter(List<Jabatan> jabatans, Context context) {
        this.jabatans = jabatans;
        this.context = context;
    }

    @Override
    public JabatanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jabatan_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(JabatanAdapter.ViewHolder holder, int position) {
        final Jabatan jabatan = jabatans.get(position);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailJabatan.class);
                intent.putExtra("idJabatan", jabatan.getID());
                intent.putExtra("namaJabatan", jabatan.getNama_Jabatan());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.id.setText(jabatan.getID());
        holder.namaJabatan.setText(jabatan.getNama_Jabatan());
    }

    @Override
    public int getItemCount() {
        return jabatans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView id;
        public TextView namaJabatan;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id_jabatan);
            namaJabatan = (TextView) itemView.findViewById(R.id.nama_jabatan);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.jabatanContainer);
        }
    }
}
