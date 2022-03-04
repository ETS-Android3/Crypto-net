package com.moringaschool.cryptonet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;


public class TypeOfCryptoDialog  extends DialogFragment  {
    public static final String TAG = TypeOfCryptoDialog.class.getSimpleName();

    String selectedCoin;
    int EthNu = 4;
    int result;


    //    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_type_of_crypto_dialog, container, false);



        Button cancelButton = (Button) rootView.findViewById(R.id.cancelButton);
        Button submitButton = (Button) rootView.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup surveyRadioGroup = (RadioGroup) rootView.findViewById(R.id.moodRadioGroup); //pull group
                int selectedId = surveyRadioGroup.getCheckedRadioButtonId(); //get selected ID
                Intent i = getActivity().getIntent();
                int vb = (i.getIntExtra("editValue",0));

                RadioButton BTC = (RadioButton) rootView.findViewById(R.id.radioButton1);
                RadioButton ETH = (RadioButton) rootView.findViewById(R.id.radioButton2);
                RadioButton LTC = (RadioButton) rootView.findViewById(R.id.radioButton3);
                RadioButton USDT = (RadioButton) rootView.findViewById(R.id.radioButton4);
                RadioButton BNB = (RadioButton) rootView.findViewById(R.id.radioButton5);
                RadioButton SOL = (RadioButton) rootView.findViewById(R.id.radioButton6);

                if(ETH.isChecked()){
                     selectedCoin = ETH.getText().toString();
                }
                else if(BTC.isChecked()){
                    selectedCoin = BTC.getText().toString();
                }
                else if(LTC.isChecked()){
                    selectedCoin = LTC.getText().toString();
                }
                else if(USDT.isChecked()){
                    selectedCoin = USDT.getText().toString();
                }
                else if(BNB.isChecked()){
                    selectedCoin = BNB.getText().toString();
                }
                else if(SOL.isChecked()){
                    selectedCoin = SOL.getText().toString();
                }


                Toast.makeText(getActivity(), selectedCoin, Toast.LENGTH_SHORT).show();






//
//                final RadioButton selectedRadioButton = (RadioButton) rootView.findViewById(selectedId); //get radio button value via ID
//
//                if(selectedRadioButton.equals("BTC")) {
//                    int bitcoin = 1;
//                    int btcVal = vb * bitcoin;
//                }
//                else if(selectedRadioButton.equals("Eth")){
//                    int Eth = 2;
//                    int EthVal = vb * Eth;
//                }
//                else if(selectedRadioButton.equals("LTC")){
//                    int ltc = 3;
//                        int ltcVal = vb * ltc;
//                }
//                else if(selectedRadioButton.equals("USDT")){
//                    int usdt = 4;
//                        int usdtVal = vb * usdt;
//                }
//                else if(selectedRadioButton.equals("BNB")){
//                    int bnb = 5;
//                        int bnbVal = vb * bnb;
//                }
//                else if(selectedRadioButton.equals("SOL")){
//                    int sol = 6;
//                        int solVal = vb * sol;
//                }
//                else{
//                    Log.e(TAG, "onClick: EROOR");
//                }
////                int capturedRadioButton = Integer.parseInt(selectedRadioButton.getText().toString());
//



            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return rootView;
  }


}