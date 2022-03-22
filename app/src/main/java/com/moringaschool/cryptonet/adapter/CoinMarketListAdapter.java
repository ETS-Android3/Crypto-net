package com.moringaschool.cryptonet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.cryptonet.Constant;
import com.moringaschool.cryptonet.R;
import com.moringaschool.cryptonet.models.Datum;
import com.moringaschool.cryptonet.models.Quote;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class CoinMarketListAdapter extends RecyclerView.Adapter<CoinMarketListAdapter.CoinMarketViewHolder> {
    /******************************MEMBER VARIABLES****************************************/
    private static DecimalFormat df2 = new DecimalFormat("#.##");


    private List<Datum> data;
    private Context mContext;
    private ItemClickListener mItemClickListener;


    public CoinMarketListAdapter(List<Datum> data,  Context mContext, ItemClickListener itemClickListener) {
        this.data = data;
        this.mContext = mContext;
        this.mItemClickListener = itemClickListener;
    }

    @Override
    public CoinMarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //a rep of what user is going to see! we are creating a View inside this method!
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_design, parent, false);
        // instantiating our viewHolder class.
        CoinMarketViewHolder coinMarketViewHolder = new CoinMarketViewHolder(view);
        return coinMarketViewHolder;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(CoinMarketListAdapter.CoinMarketViewHolder holder, int position) {
//        holder.bindData(data.get(position));
        Datum datum = data.get(position);
        holder.numbering.setText(String.valueOf(datum.getCmcRank())); //tv.setText(String.valueOf(integer));
        holder.coinLongName.setText(datum.getName());
        holder.coinShortName.setText(datum.getSymbol());
        holder.valueInKes.setText("$" + df2.format(datum.getQuote().getUsd().getPrice()));
//        holder.cmc_rank.setText(datum.getCmcRank());
        if(Double.parseDouble(df2.format(datum.getQuote().getUsd().getPercentChange1h())) > 0){
            holder.marketPercentage.setText(df2.format(datum.getQuote().getUsd().getPercentChange1h())+"%"); // +
        }
        else if(Double.parseDouble(df2.format(datum.getQuote().getUsd().getPercentChange1h())) < 0){
            holder.marketPercentage2.setText(df2.format(datum.getQuote().getUsd().getPercentChange1h())+"%"); //-

        }
        else{
            return;
        }
        //ItemClickListener
        holder.itemView.setOnClickListener(view -> {
            mItemClickListener.onItemClickListener(datum); //this will get the position of our item in recycler view
        });

        holder.bookmarkIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                DatabaseReference mDatabase = FirebaseDatabase.getInstance()
                        .getReference(Constant.FIREBASE_CHILD_BOOKMARK)
                        .child(uid);
                DatabaseReference databaseReference = mDatabase.push();

                String getKey = databaseReference.getKey();
                Map<String, Object> hashmap = new HashMap<>();
                hashmap.put("CoinShorName", datum.getSymbol());
                hashmap.put("LongShorName", datum.getName());
                hashmap.put("money", datum.getQuote().getUsd().getPrice());

                hashmap.put("id", getKey);
                mDatabase.push().setValue(hashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(mContext, "Saved Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }


    public interface ItemClickListener{
        void onItemClickListener(Datum myData);
    }
    /**************************INNER CLASS WHICH IS A VIEWHOLDER****************************************/
    public class CoinMarketViewHolder extends RecyclerView.ViewHolder{

        private TextView coinShortName,coinLongName,valueInKes,numbering,marketPercentage,marketPercentage2;
        private ImageButton bookmarkIcon;
        private Context mContext;


        /******************************VIEWHOLDER'S CONSTRUCTOR****************************************/
        // mediator between my Adapter and the Activity!
        public CoinMarketViewHolder(View itemView) {
            super(itemView);
            coinShortName = itemView.findViewById(R.id.coinShortName);
            coinLongName = itemView.findViewById(R.id.coinLongName);
            valueInKes = itemView.findViewById(R.id.valueInKes);
            numbering = itemView.findViewById(R.id.numbering);
            marketPercentage = itemView.findViewById(R.id.marketPercentage);
            marketPercentage2 = itemView.findViewById(R.id.marketPercentage2);
            bookmarkIcon = itemView.findViewById(R.id.bookmarkIcon);
            mContext = itemView.getContext();

        }



    }

}
