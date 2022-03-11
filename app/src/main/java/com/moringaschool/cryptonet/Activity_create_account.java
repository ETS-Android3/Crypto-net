package com.moringaschool.cryptonet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.cryptonet.ui.DetailActivity;
import com.moringaschool.cryptonet.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_create_account extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = Activity_create_account.class.getSimpleName();
    @BindView(R.id.takeMeToLogin) TextView takeMeToLogin;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.createUserButton) Button mCreateUserButton;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        takeMeToLogin.setOnClickListener(this);
        mCreateUserButton.setOnClickListener(this);

        createAuthStateListener();


    }

    @Override
    public void onClick(View view) {
        if(view == takeMeToLogin){
            Log.e(TAG, "onClick: success to Log in" );
            Intent intent = new Intent(Activity_create_account.this, Activity_login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish(); // to destroy when moving
        }
        if(view == mCreateUserButton){
            createNewUser();
        }
    }

    private void createNewUser(){
        final String name = mNameEditText.getText().toString().trim();
        final String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
//                        Log.d(TAG, "Authentication successful");
                        Toast.makeText(Activity_create_account.this,"log in successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Activity_create_account.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void createAuthStateListener(){
        mAuthStateListener = new FirebaseAuth.AuthStateListener() { // we want to inform the app for success authentication
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(Activity_create_account.this, Activity_login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };


    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
}