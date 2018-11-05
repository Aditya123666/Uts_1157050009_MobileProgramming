package com.aditya.lenovo.uts_1157050009;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MatchViewHolder> {

    //deklarasi global variabel
    private Context context;
    private final ArrayList<Model> listMatch;

    //konstruktor untuk menerima data adapter
    public Adapter(Context context, ArrayList<Model> listMatch) {
        this.context = context;
        this.listMatch = listMatch;
    }

    //view holder berfungsi untuk setting list item yang digunakan
    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pertandingan, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new MatchViewHolder(mItemView, this);
    }

    //bind view holder berfungsi untuk set data ke view yang ditampilkan pada list item
    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        final Model mCurrent = listMatch.get(position);
        holder.nameHome.setText(mCurrent.getNameHome());
        holder.nameAway.setText(mCurrent.getNameAway());
        holder.imageHome.setImageResource(mCurrent.getLogoHome());
        holder.imageAway.setImageResource(mCurrent.getLogoAway());
    }

    //untuk menghitung jumlah data yang ada pada list
    @Override
    public int getItemCount() {
        return listMatch.size();
    }

    public class MatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameHome, nameAway;
        private ImageView imageHome,imageAway;
        private CardView cdView;

        final Adapter mAdapter;

        //untuk casting view yang digunakan pada list item
        public MatchViewHolder(View itemView, Adapter adapter) {
            super(itemView);
            cdView = itemView.findViewById(R.id.cd_match);
            nameHome = itemView.findViewById(R.id.tv_name_home);
            nameAway = itemView.findViewById(R.id.tv_name_away);
            imageHome = itemView.findViewById(R.id.iv_home);
            imageAway = itemView.findViewById(R.id.iv_away);

            this.mAdapter = adapter;
            cdView.setOnClickListener(this);
        }

        //untuk menambah action click pada list item
        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            Model element = listMatch.get(mPosition);

            //intent ke main activity dengan passing data
            Intent i = new Intent(context, DetailPertandingan.class);
            i.putExtra("namehome", element.getNameHome());
            i.putExtra("nameaway", element.getNameAway());
            i.putExtra("imagehome", element.getLogoHome());
            i.putExtra("imageaway", element.getLogoAway());
            i.putExtra("scoreaway", element.getScoreAway());
            i.putExtra("scorehome", element.getScoreHom());
            i.putExtra("description", element.getDescrription());
            i.putExtra("news", element.getNews());
            context.startActivity(i);
            mAdapter.notifyDataSetChanged();
        }
    }

}
