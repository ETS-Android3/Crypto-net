package com.moringaschool.cryptonet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = DetailActivity.class.getSimpleName();
    @BindView(R.id.cryptoTypeButton) Button cryptoTypeButton;
    @BindView(R.id.convertButton) Button convertButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        cryptoTypeButton.setOnClickListener(this);

        // to capture the editText that holds the amount to be converted!
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText numberOfCrypto = (EditText) findViewById(R.id.numberOfCrypto);
                String text = numberOfCrypto.getText().toString();
                Log.d("cryto to be converted: ", text);

                Intent i = new Intent(DetailActivity.this,ShowdetailActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view == cryptoTypeButton){
            FragmentManager fm = getSupportFragmentManager();
            TypeOfCryptoDialog cryptoDialog = new TypeOfCryptoDialog();
            cryptoDialog.show(fm ,"simple code");
            //TOAST
            Toast.makeText(DetailActivity.this,"choose cryptocurrency", Toast.LENGTH_LONG).show();
        }


    }
}