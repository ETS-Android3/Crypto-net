package com.moringaschool.cryptonet.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import static com.moringaschool.cryptonet.Constant.CMC_PRO_API_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.cryptonet.R;
import com.moringaschool.cryptonet.adapter.CoinMarketListAdapter;
import com.moringaschool.cryptonet.models.CoinmarketcapListingsLatestResponse;
import com.moringaschool.cryptonet.models.Datum;
import com.moringaschool.cryptonet.models.Quote;
import com.moringaschool.cryptonet.models.Usd;
import com.moringaschool.cryptonet.network.CoinMarketCapApi;
import com.moringaschool.cryptonet.network.CoinmarketCapClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowdetailActivity extends AppCompatActivity  {
    public static final String TAG = ShowdetailActivity.class.getSimpleName();
    @BindView(R.id.cashConverted) TextView cashConverted;
    @BindView(R.id.coinSelected) TextView coinSelected;

    @BindView(R.id.mRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;


    private CoinMarketListAdapter mAdapter;
    public List<Datum> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetail);
        ButterKnife.bind(this);

        Intent i = getIntent();
        String vb = i.getStringExtra("editValue");
        cashConverted.setText("KSH "+ vb);

        CoinMarketCapApi client = CoinmarketCapClient.getClient();
        Call<CoinmarketcapListingsLatestResponse> call = client.getData(1, 5000);

        call.enqueue(new Callback<CoinmarketcapListingsLatestResponse>() {
            @Override
            public void onResponse(Call<CoinmarketcapListingsLatestResponse> call, Response<CoinmarketcapListingsLatestResponse> response) {
                Log.d(TAG, "onResponse: success Response" + response);
                hideProgressBar();
                if(response.isSuccessful()){
                    data = new ArrayList<>();
                    data = response.body().getData();
                    mAdapter = new CoinMarketListAdapter(data ,ShowdetailActivity.this);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShowdetailActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setHasFixedSize(true);
                    Log.d(TAG, "onResponse: success mAdapter" + mAdapter);
                    showData();
                    }
                else {
                    showUnsuccessfulMessage();
                }

                }

            @Override
            public void onFailure(Call<CoinmarketcapListingsLatestResponse> call, Throwable t) {
                System.out.println(t);
                hideProgressBar();
                showFailureMessage();
            }
        });

    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showData(){
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }
}