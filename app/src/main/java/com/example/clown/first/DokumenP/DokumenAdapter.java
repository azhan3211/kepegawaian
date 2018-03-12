package com.example.clown.first.DokumenP;

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

public class DokumenAdapter extends RecyclerView.Adapter<DokumenAdapter.ViewHolder> {

    List<Dokumen> dokumens;
    Context context;

    public DokumenAdapter(List<Dokumen> dokumens, Context context) {
        this.dokumens = dokumens;
        this.context = context;
    }

    @Override
    public DokumenAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dokumen_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DokumenAdapter.ViewHolder holder, int position) {
        final Dokumen dokumen = dokumens.get(position);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailDokumen.class);
                intent.putExtra("idDokumen", dokumen.getID_Klp_Dok());
                intent.putExtra("namaDokumen", dokumen.getNama_Klp_Dok());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.id.setText(dokumen.getID_Klp_Dok());
        holder.nama.setText(dokumen.getNama_Klp_Dok());
    }

    @Override
    public int getItemCount() {
        return dokumens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView id;
        public TextView nama;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id_klp_dok);
            nama = (TextView) itemView.findViewById(R.id.nama_klp_dok);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.dokumenContainer);
        }
    }
}
