package com.moringaschool.cryptonet.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.cryptonet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.login) Button login;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference(); //we now have permissions to read and write to Firebas


    /**
     * .getInstance() used o access variable database and then write it into local Object of type FirebaseDatabase.
     * .getReferenec()
     * (in Java A reference is an address that indicates where an object's variables and methods are stored.)
     * ref.child("<childNodeName>").setValue("<someValue>");
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        login.setOnClickListener(this);

        FirebaseDatabase.getInstance();
    }

    @Override
    public void onClick(View v) {
        if(v == login){
            Intent i = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(i);
        }
    }
}