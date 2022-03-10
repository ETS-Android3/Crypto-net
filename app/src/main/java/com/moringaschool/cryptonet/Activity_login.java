package com.moringaschool.cryptonet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_login extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = Activity_login.class.getSimpleName();

    @BindView(R.id.takeMeToSignUp)
    TextView takeMeToSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        takeMeToSignUp.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if(view == takeMeToSignUp){
            Log.e(TAG, "onClick: success for return back to sign up" );
           Intent login = new Intent(Activity_login.this, Activity_create_account.class);
           startActivity(login);
           finish(); // to destroy when moving
        }
    }
}