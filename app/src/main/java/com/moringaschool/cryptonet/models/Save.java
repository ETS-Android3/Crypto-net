package com.moringaschool.cryptonet.models;

public class Save {
    private String CoinShorName;
    private String CoinLongName;
    private String money;

    public Save(){

    }

    public String getCoinShorName() {
        return CoinShorName;
    }

    public void setCoinShorName(String coinShorName) {
        CoinShorName = coinShorName;
    }

    public String getCoinLongName() {
        return CoinLongName;
    }

    public void setCoinLongName(String coinLongName) {
        CoinLongName = coinLongName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
