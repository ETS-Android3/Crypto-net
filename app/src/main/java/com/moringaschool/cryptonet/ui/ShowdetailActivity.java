package com.moringaschool.cryptonet.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import static com.moringaschool.cryptonet.Constant.CMC_PRO_API_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.cryptonet.Constant;
import com.moringaschool.cryptonet.R;
import com.moringaschool.cryptonet.adapter.CoinMarketListAdapter;
import com.moringaschool.cryptonet.models.CoinmarketcapListingsLatestResponse;
import com.moringaschool.cryptonet.models.Datum;
import com.moringaschool.cryptonet.network.CoinMarketCapApi;
import com.moringaschool.cryptonet.network.CoinmarketCapClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowdetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = ShowdetailActivity.class.getSimpleName();
    @BindView(R.id.cashConverted) TextView cashConverted;
    @BindView(R.id.coinSelected) TextView coinSelected;
    @BindView(R.id.mRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    //ICON
//    @BindView(R.id.bookmarkIcon) ImageButton bookmarkIcon;
    @BindView(R.id.rightArrow) TextView mRightArrow;


    private CoinMarketListAdapter mAdapter;
    public List<Datum> data;


    private DatabaseReference mDatabase;
//    private FirebaseAuth firebaseAuth;
    private ValueEventListener mValueEventListener;

    public ShowdetailActivity(){
        // Required empty public constructor
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetail);
        ButterKnife.bind(this);
        mRightArrow.setOnClickListener(this);


        Intent i = getIntent();
        String vb = i.getStringExtra("editValue");
        cashConverted.setText("KSH "+ vb);

        CoinMarketCapApi client = CoinmarketCapClient.getClient();
        Call<CoinmarketcapListingsLatestResponse> call = client.getData ( 5000);

        call.enqueue(new Callback<CoinmarketcapListingsLatestResponse>() {
            @Override
            public void onResponse(Call<CoinmarketcapListingsLatestResponse> call, Response<CoinmarketcapListingsLatestResponse> response) {
                Log.d(TAG, "onResponse: success Response" + response);
                hideProgressBar();

                if(response.isSuccessful()){
                    data = response.body().getData();
                    mAdapter = new CoinMarketListAdapter(data, ShowdetailActivity.this, new CoinMarketListAdapter.ItemClickListener() {
                        // when you click the market items
                        @Override
                        public void onItemClickListener(Datum myData) {
                            Toast.makeText(ShowdetailActivity.this, "saved!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShowdetailActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setAdapter(mAdapter);

                    //creating a divider
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(ShowdetailActivity.this, DividerItemDecoration.VERTICAL);
                    mRecyclerView.addItemDecoration(dividerItemDecoration);
                    mRecyclerView.setHasFixedSize(true);
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

    //inflating menu xml that holds the overflow menu(logout) basically the kebab menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_logout){
            logOut();
            return true;
        }
        else if (id == R.id.action_save){
            save();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void save() {
        Intent intent = new Intent(ShowdetailActivity.this, SavedCrypto.class);
        startActivity(intent);
    }

    private void logOut(){
        FirebaseAuth.getInstance().signOut(); //calling in built method signOut() inside FirebaseAuth obj
        Intent intent = new Intent(ShowdetailActivity.this, Activity_login.class); // out of session to login page
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // creating new task and clearing task in stack.
        startActivity(intent); //running
        finish(); // just formalities to end the current instance of MainActivity with the finish() method.
    }


    @Override
    public void onClick(View view) {
        if(view == mRightArrow){
            Intent intent = new Intent(ShowdetailActivity.this, SavedCrypto.class);
            startActivity(intent);
        }

    }


}
