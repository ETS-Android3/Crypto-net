package com.moringaschool.cryptonet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.cryptonet.ui.DetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_login extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = Activity_login.class.getSimpleName();

    @BindView(R.id.takeMeToSignUp) TextView takeMeToSignUp;
    @BindView(R.id.loginUserButton) TextView loginUserButton;

    @BindView(R.id.emailEditText) EditText emailAddress;
    @BindView(R.id.passwordEditText) TextView userPassword;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        firebaseAuth = FirebaseAuth.getInstance();
        takeMeToSignUp.setOnClickListener(this);
        loginUserButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view)  {
        if (view == loginUserButton){
            Intent login = new Intent(Activity_login.this, DetailActivity.class);
            startActivity(login);
            finish(); // to destroy when moving
        }
        if(view == takeMeToSignUp){
            Log.d(TAG, "onClick: success for return back to sign up");
           Intent login = new Intent(Activity_login.this, Activity_create_account.class);
           startActivity(login);
           finish(); // to destroy when moving
        }

    }


}