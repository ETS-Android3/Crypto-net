package com.moringaschool.cryptonet.models;

import com.google.firebase.database.DataSnapshot;

public class Save {
    private String CoinShorName;
    private String CoinLongName;
    private String money;

    public Save(){

    }

    public String getCoinShorName() {
        return CoinShorName;
    }

    public void setCoinShorName(DataSnapshot coinShorName) {
        CoinShorName = coinShorName;
    }

    public String getCoinLongName() {
        return CoinLongName;
    }

    public void setCoinLongName(DataSnapshot coinLongName) {
        CoinLongName = coinLongName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
