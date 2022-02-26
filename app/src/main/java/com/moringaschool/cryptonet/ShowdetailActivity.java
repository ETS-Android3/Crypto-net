package com.moringaschool.cryptonet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShowdetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}