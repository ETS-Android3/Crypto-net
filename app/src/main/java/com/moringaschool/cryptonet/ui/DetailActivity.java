package com.moringaschool.cryptonet.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.cryptonet.Constant;
import com.moringaschool.cryptonet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = DetailActivity.class.getSimpleName();
//    @BindView(R.id.cryptoTypeButton) Button cryptoTypeButton;
    @BindView(R.id.convertButton) Button convertButton;
    @BindView(R.id.numberOfCrypto) EditText numberOfCrypto; //edit text

    private DatabaseReference mGettingNumber;
    private ValueEventListener mGettingNumberEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mGettingNumber = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constant.FIREBASE_CHILD_GET_VARIABLE);

        mGettingNumberEventListener = mGettingNumber.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot numbersSnapshot : snapshot.getChildren()) {
                    String numbers = numbersSnapshot.getValue().toString();
                    Log.d("Locations updated", "numbersSnapshot: " + numbers); //log
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: failed");
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        convertButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(convertButton == view){
            //EDIT-TEXT
            String editValue = numberOfCrypto.getText().toString();
            //Sending to another Activity
            Intent i = new Intent(DetailActivity.this, ShowdetailActivity.class);
            i.putExtra("editValue", editValue);
            startActivity(i);

            saveNumberToFirebase(editValue);
        }
    }

    public void saveNumberToFirebase(String editValue){
        mGettingNumber.push().setValue(editValue);
    }

    //to kill the ValueEventListner if the user is not using the app

    @Override
    protected void onDestroy() {
        mGettingNumber.removeEventListener(mGettingNumberEventListener);
        super.onDestroy();
    }
}


