package com.moringaschool.cryptonet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.moringaschool.cryptonet.R;
import com.moringaschool.cryptonet.models.Datum;
import com.moringaschool.cryptonet.models.Save;
import com.moringaschool.cryptonet.ui.SavedCrypto;

import java.util.List;

public class SaveCryptoAdapter extends FirebaseRecyclerAdapter<Save,SaveCryptoAdapter.SaveInnerClass> {

    private Context context;
    List<Save> mySave;

    public SaveCryptoAdapter(@NonNull FirebaseRecyclerOptions<Save> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull SaveInnerClass holder, int position, @NonNull Save model) {
        holder.short_txt.setText(model.getCoinShorName());
        holder.name_txt.setText(model.getCoinLongName());
        holder.price_txt.setText(model.getMoney());
    }

    @Override
    public SaveInnerClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_saved_design, parent, false);
        return new SaveInnerClass(view);
    }

    public class SaveInnerClass  extends RecyclerView.ViewHolder{

        private TextView short_txt,price_txt,name_txt;

        public SaveInnerClass(@NonNull View itemView) {
            super(itemView);
            short_txt=itemView.findViewById(R.id.short_txt);
            name_txt=itemView.findViewById(R.id.name_txt);
            price_txt=itemView.findViewById(R.id.price_txt);

        }

    }






}
