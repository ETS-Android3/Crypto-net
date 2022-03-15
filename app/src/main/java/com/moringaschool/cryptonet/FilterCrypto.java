package com.moringaschool.cryptonet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.cryptonet.adapter.InfoListAdapter;
import com.moringaschool.cryptonet.model2.Data;
import com.moringaschool.cryptonet.model2.InfoClass;
import com.moringaschool.cryptonet.model2.SearchResponse;
import com.moringaschool.cryptonet.network.InfoMarketCapApi;
import com.moringaschool.cryptonet.network.LogoCoinMarketClient;
import com.moringaschool.cryptonet.ui.ShowdetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilterCrypto extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = FilterCrypto.class.getSimpleName();

    //    @BindView(R.id.searchViewFilter)SearchView searchViewFilter;
    //    @BindView(R.id.infoRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.noData)
    TextView noData;

    private InfoListAdapter mAdapter;
    private InfoClass infoClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_crypto);
        ButterKnife.bind(this);
        noData.setOnClickListener(this);
//
//        InfoMarketCapApi client = LogoCoinMarketClient.getClient2();
//        Call<SearchResponse> call= client.getInfoData("bitcoin"); // value of searchView "bitcoin"
//        call.enqueue(new Callback<SearchResponse>() {
//            @Override
//            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
//                if(response.isSuccessful()){
//                    infoClass = response.body().getData().getInfoClass();
//                    mAdapter = new InfoListAdapter(infoClass,FilterCrypto.this);
//
//                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FilterCrypto.this);
//                    mRecyclerView.setLayoutManager(layoutManager);
//                    mRecyclerView.setAdapter(mAdapter);
//                }
//                else{
//                    return;
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SearchResponse> call, Throwable t) {
//                Log.e(TAG, "onFailure: " + t );
//
//            }
//        });

    }

    @Override
    public void onClick(View view) {
        if(view == noData){
            Intent i = new Intent(FilterCrypto.this, ShowdetailActivity.class);
            startActivity(i);
            finish();
        }
    }
}