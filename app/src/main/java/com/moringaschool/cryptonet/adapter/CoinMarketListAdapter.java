package com.moringaschool.cryptonet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.cryptonet.R;
import com.moringaschool.cryptonet.models.Datum;
import com.moringaschool.cryptonet.models.Kes;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoinMarketListAdapter extends RecyclerView.Adapter<CoinMarketListAdapter.CoinMarketViewHolder> {
    /******************************MEMBER VARIABLES****************************************/
    private List<Datum> mData;
    private List<Kes> kes;
    private Context mContext;


    @Override
    public CoinMarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.activity_showdetail, parent, false);
        CoinMarketViewHolder viewHolder = new CoinMarketViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CoinMarketViewHolder holder, int position) {
        holder.bindData(mData.get(position), kes.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**************************INNER CLASS WHICH IS A VIEWHOLDER****************************************/
    public class CoinMarketViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageSymbol) ImageView imageSymbol;
        @BindView(R.id.coinLongName) TextView coinLongName;
        @BindView(R.id.coinShortName) TextView coinShortName;
        @BindView(R.id.valueInKes) TextView valueInKes;
        private Context mContext;

    /******************************VIEWHOLDER'S CONSTRUCTOR****************************************/
        public CoinMarketViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

        }

        public void bindData(Datum data, Kes kes) {
            Picasso.get().load(data.getSymbol()).into(imageSymbol);
            coinLongName.setText(data.getName());
            coinShortName.setText(data.getSlug());
            valueInKes.setText("KES " + kes.getPrice());

        }

    }

}
