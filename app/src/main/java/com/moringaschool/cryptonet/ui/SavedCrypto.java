package com.moringaschool.cryptonet.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.cryptonet.Constant;
import com.moringaschool.cryptonet.R;
import com.moringaschool.cryptonet.adapter.SaveCryptoAdapter;
import com.moringaschool.cryptonet.models.Datum;
import com.moringaschool.cryptonet.models.Save;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedCrypto extends AppCompatActivity {
    public static final String TAG = SavedCrypto.class.getSimpleName();

//    private ValueEventListener valueEventListener;
//    private DatabaseReference databaseReference;

    private RecyclerView recyclerView;
    private SaveCryptoAdapter saveCryptoAdapter;
    private DatabaseReference databaseReference;
    private FirebaseUser user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        ButterKnife.bind(this);

        recyclerView = findViewById(R.id.rvsaved);
        user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(Constant.FIREBASE_CHILD_BOOKMARK)
                .child(uid);

        FirebaseRecyclerOptions<Save> options = new FirebaseRecyclerOptions.Builder<Save>()
                .setQuery(databaseReference,Save.class)
                .build();

        saveCryptoAdapter = new SaveCryptoAdapter(options,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SavedCrypto.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(saveCryptoAdapter);

        Log.d(TAG, "onCreate: error " + options );



    }
}