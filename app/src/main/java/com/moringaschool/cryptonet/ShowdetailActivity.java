package com.moringaschool.cryptonet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowdetailActivity extends AppCompatActivity  {
    public static final String TAG = ShowdetailActivity.class.getSimpleName();
    private String[] cuisines = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs", "Scandinavian", "Coffee", "English Food",
            "Burgers", "Fast Food", "Noodle Soups",
            "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };

    @BindView(R.id.cashConverted)
    TextView cashConverted;
    @BindView(R.id.coinSelected)
    TextView coinSelected;
    @BindView(R.id.mListView)
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetail);
        ButterKnife.bind(this);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        String vb = i.getStringExtra("editValue");
        cashConverted.setText("KSH . "+ vb);

        //Adapter array
        CryptosInfoArrayAdapter adapter = new CryptosInfoArrayAdapter(this, android.R.layout.simple_list_item_1, cuisines);
        mListView.setAdapter(adapter);

//        Intent intent = getIntent();
//        intent.getStringExtra("editText_value_double");
//
//
//        //receving capturedRadioButton from Detail activity
//        String rb = intent.getStringExtra("receivedRbutton");
//        coinSelected.setText(rb);
//
//        //receiving calcultion
//        long lr = intent.getLongExtra("result",0L);
//
//        cashConverted.setText((int) lr);








    }
}