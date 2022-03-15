package com.moringaschool.cryptonet.model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.cryptonet.model2.InfoClass;


public class Data {

    @SerializedName("1")
    @Expose
    private InfoClass infoClass;

    public Data(InfoClass infoClass) {
        this.infoClass = infoClass;
    }

    public InfoClass getInfoClass() {
        return infoClass;
    }

    public void setInfoClass(InfoClass infoClass) {
        this.infoClass = infoClass;
    }
}
