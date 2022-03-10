package com.moringaschool.cryptonet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.cryptonet.ui.DetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_create_account extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = Activity_create_account.class.getSimpleName();
    @BindView(R.id.takeMeToLogin)
    TextView takeMeToLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Create an Account");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        takeMeToLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == takeMeToLogin){
            Log.e(TAG, "onClick: success to Log in" );
            Intent in = new Intent(Activity_create_account.this, Activity_login.class);
            startActivity(in);
            finish(); // to destroy when moving
        }
    }
}