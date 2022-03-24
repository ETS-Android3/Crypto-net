package com.moringaschool.cryptonet.models;

import com.google.firebase.database.DataSnapshot;

public class Save {
    private String CoinShortNameSaved;
    private String CoinLongNameSaved;
    private String moneySaved;



    public Save(){

    }

    public String getCoinShortNameSaved() {
        return CoinShortNameSaved;
    }

    public void setCoinShortNameSaved(String coinShortNameSaved) {
        CoinShortNameSaved = coinShortNameSaved;
    }

    public String getCoinLongNameSaved() {
        return CoinLongNameSaved;
    }

    public void setCoinLongNameSaved(String coinLongNameSaved) {
        CoinLongNameSaved = coinLongNameSaved;
    }

    public String getMoneySaved() {
        return moneySaved;
    }

    public void setMoneySaved(String moneySaved) {
        this.moneySaved = moneySaved;
    }
}
