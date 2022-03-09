package com.moringaschool.cryptonet.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.cryptonet.R;
import com.moringaschool.cryptonet.models.Datum;
import com.moringaschool.cryptonet.models.Quote;
import com.moringaschool.cryptonet.models.Usd;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoinMarketListAdapter extends RecyclerView.Adapter<CoinMarketListAdapter.CoinMarketViewHolder>  {
    /******************************MEMBER VARIABLES****************************************/
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private List<Datum> data;
    private List<Quote> quotes;
    private Context mContext;

    public CoinMarketListAdapter(List<Datum> data,  Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public CoinMarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_list_design, parent, false);
        CoinMarketViewHolder coinMarketViewHolder = new CoinMarketViewHolder(view);
        return coinMarketViewHolder;
    }

    @Override
    public void onBindViewHolder(CoinMarketListAdapter.CoinMarketViewHolder holder, int position) {
//        holder.bindData(data.get(position));
        Datum datum = data.get(position);
        holder.numbering.setText(String.valueOf(datum.getCmcRank())); //tv.setText(String.valueOf(integer));
        holder.coinLongName.setText(datum.getName());
        holder.coinShortName.setText(datum.getSymbol());
        holder.valueInKes.setText("$" + df2.format(datum.getQuote().getUsd().getPrice()));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    /**************************INNER CLASS WHICH IS A VIEWHOLDER****************************************/
    public class CoinMarketViewHolder extends RecyclerView.ViewHolder{
//        @BindView(R.id.coinShortName) TextView coinShortName;
////        @BindView(R.id.valueInKes) TextView valueInKes;
//        @BindView(R.id.coinLongName) TextView coinLongName;
        private TextView coinShortName,coinLongName,valueInKes,numbering;
        private Context mContext;


        /******************************VIEWHOLDER'S CONSTRUCTOR****************************************/
        public CoinMarketViewHolder(View itemView) {
            super(itemView);
            coinShortName = itemView.findViewById(R.id.coinShortName);
            coinLongName = itemView.findViewById(R.id.coinLongName);
            valueInKes = itemView.findViewById(R.id.valueInKes);
            numbering = itemView.findViewById(R.id.numbering);

//            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

        }

//        public void bindData(Datum mdata) {
//            numbering.setText(mdata.getId());
//            coinLongName.setText(mdata.getName());
//            coinShortName.setText(mdata.getSymbol());
//        }

    }

}
