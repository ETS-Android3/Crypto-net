package com.moringaschool.cryptonet;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class TypeOfCryptoDialog extends DialogFragment   {
    public static final String TAG = TypeOfCryptoDialog.class.getSimpleName();


    //    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
        View rootView = inflater.inflate(R.layout.fragment_type_of_crypto_dialog, container, false);
//
//
        RadioGroup surveyRadioGroup = (RadioGroup) rootView.findViewById(R.id.moodRadioGroup); //pull group

        int selectedId = surveyRadioGroup.getCheckedRadioButtonId(); //get selected ID

        final RadioButton selectedRadioButton = (RadioButton) rootView.findViewById(selectedId); //get radio button val via ID

        Button cancelButton = (Button) rootView.findViewById(R.id.cancelButton);
        Button submitButton = (Button) rootView.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, selectedRadioButton.getText().toString());
                dismiss();
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