package com.moringaschool.cryptonet.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.cryptonet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_login extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = Activity_login.class.getSimpleName();

    @BindView(R.id.takeMeToSignUp) TextView takeMeToSignUp;
    @BindView(R.id.loginUserButton) TextView loginUserButton;

    @BindView(R.id.emailEditText) EditText emailAddress;
    @BindView(R.id.passwordEditText) TextView userPassword;

    @BindView(R.id.mErrorText) TextView mErrorText;

    @BindView(R.id.firebaseProgressBar)
    ProgressBar firebaseProgressBar;
    @BindView(R.id.loadingTextView) TextView loadingTextView;

    @BindView(R.id.title) TextView title;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        YoYo.with(Techniques.FadeIn)
                .duration(700)
                .repeat(1)
                .playOn(title);



        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            FirebaseUser user = mAuth.getCurrentUser();// check user in FirebaseBD
            @Override
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null){
                    Intent intent = new Intent(Activity_login.this, DetailActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };

        mAuth = FirebaseAuth.getInstance();
        takeMeToSignUp.setOnClickListener(this);
        loginUserButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)  {
        if (view == loginUserButton){
            loginWithPassword();
            showProgressBar();

        }
        if(view == takeMeToSignUp){
            Log.d(TAG, "onClick: success for return back to sign up");
           Intent login = new Intent(Activity_login.this, Activity_create_account.class);
           startActivity(login);
           finish(); // to destroy when moving
        }

    }



    private void loginWithPassword() {
        String email = emailAddress.getText().toString().trim();
        String pass = userPassword.getText().toString().trim();

        if(email.equals("")){
            emailAddress.setError("Enter your Email!");
            return;
        }
        if(pass.equals("")){
            userPassword.setError("Enter your Password! ");
            return;
        }
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        Log.d(TAG, "onComplete: log in" + task.isSuccessful());
                        hideProgressBar();
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail", task.getException());
                            showErrorMessage();
                        }
                    }
                });
    }

    private void showErrorMessage(){
        mErrorText.setText("Oops! we could not find a matching credentials");
        mErrorText.setVisibility(View.VISIBLE);
    }
    private void hideErrorMessage(){
        mErrorText.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void showProgressBar() {
        firebaseProgressBar.setVisibility(View.VISIBLE);
        loadingTextView.setVisibility(View.VISIBLE);
        loadingTextView.setText("Logging you in");
    }

    private void hideProgressBar() {
        firebaseProgressBar.setVisibility(View.GONE);
        loadingTextView.setVisibility(View.GONE);
    }

}