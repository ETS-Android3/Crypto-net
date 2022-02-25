package com.moringaschool.cryptonet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.login) Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == login){
            Intent i = new Intent(MainActivity.this,DetailActivity.class);
            startActivity(i);
        }
    }
}