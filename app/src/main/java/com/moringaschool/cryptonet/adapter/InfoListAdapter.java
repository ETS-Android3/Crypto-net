package com.moringaschool.cryptonet.adapter;

import android.content.Context;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.cryptonet.R;
import com.moringaschool.cryptonet.model2.Data;
import com.moringaschool.cryptonet.model2.InfoClass;
import com.moringaschool.cryptonet.model2.Urls;

import java.util.List;

public class InfoListAdapter extends RecyclerView.Adapter<InfoListAdapter.InfoViewHolder> {

    private InfoClass info;
    Context context;

    public InfoListAdapter(InfoClass info, Context context) {
        this.info = info;
        this.context = context;
    }

    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_crypto_design, parent, false);
        InfoViewHolder infoViewHolder = new InfoViewHolder(view);
        return infoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        holder.name.setText(info.getName());
        holder.symbol.setText(info.getSymbol());
        holder.description.setText(info.getDescription());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder {
        private TextView name,symbol,description;
        private ImageView logo,website,reddit,github,twitter;
        private Context mContext;

        public InfoViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            symbol = itemView .findViewById(R.id.symbol);
            description  = itemView.findViewById(R.id.description);
            logo = itemView.findViewById(R.id.logo);
            website  = itemView.findViewById(R.id.website);
            reddit = itemView.findViewById(R.id.reddit);
            github  = itemView.findViewById(R.id.github);
            twitter = itemView.findViewById(R.id.twiiter);
            mContext = itemView.getContext();

        }
    }



}
