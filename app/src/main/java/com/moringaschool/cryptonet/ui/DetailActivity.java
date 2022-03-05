package com.moringaschool.cryptonet.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moringaschool.cryptonet.R;
import com.moringaschool.cryptonet.ShowdetailActivity;
import com.moringaschool.cryptonet.TypeOfCryptoDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = DetailActivity.class.getSimpleName();
//    @BindView(R.id.cryptoTypeButton) Button cryptoTypeButton;
    @BindView(R.id.convertButton) Button convertButton;
    @BindView(R.id.numberOfCrypto) EditText numberOfCrypto; //edit text



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
//        cryptoTypeButton.setOnClickListener(this);


       convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EDIT-TEXT
                String editText_value_string = numberOfCrypto.getText().toString(); //saving what we wrote in editText widget
//                double editText_value_double = Double.parseDouble(editText_value_string);
                //Sending to another Activity
                Intent i = new Intent(DetailActivity.this, ShowdetailActivity.class);
                i.putExtra("editValue",editText_value_string);
                startActivity(i);

            }
        });
    }


    @Override
    public void onClick(View view) {
//        if(view == cryptoTypeButton){
//            FragmentManager fm = getSupportFragmentManager();
//            TypeOfCryptoDialog cryptoDialog = new TypeOfCryptoDialog();
//            cryptoDialog.show(fm ,"simple code");
//
//            //TOAST
//            Toast.makeText(DetailActivity.this,"choose cryptocurrency", Toast.LENGTH_LONG).show();
//
        }





    }


