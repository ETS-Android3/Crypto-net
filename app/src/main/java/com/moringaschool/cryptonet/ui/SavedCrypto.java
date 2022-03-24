package com.moringaschool.cryptonet.ui;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
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
    Save save;
    private FirebaseUser user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        ButterKnife.bind(this);

        recyclerView = findViewById(R.id.rvsaved);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SavedCrypto.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(saveCryptoAdapter);


        user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference()
                .child(Constant.FIREBASE_CHILD_BOOKMARK)
                .child(uid);



        FirebaseRecyclerOptions<Save> options = new FirebaseRecyclerOptions.Builder<Save>()
                .setQuery(databaseReference,Save.class)
                .build();

        saveCryptoAdapter = new SaveCryptoAdapter(options,this);

       //connecting the recyclerView with the adapter
        recyclerView.setAdapter(saveCryptoAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Save saved = dataSnapshot.getValue(Save.class);
                }
                saveCryptoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: " + error);
            }
        });




    }

    //function to tell the app to start getting the data from the database
    @Override
    public void onStart() {
        super.onStart();
        saveCryptoAdapter.startListening();
    }

    //function to tell the app to stop fetching the data from the database
    @Override
    public void onStop() {
        super.onStop();
        saveCryptoAdapter.stopListening();
    }
}