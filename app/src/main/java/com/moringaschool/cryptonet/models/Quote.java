
package com.moringaschool.cryptonet.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("KES")
    @Expose
    private Kes kes;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Quote() {
    }

    /**
     * 
     * @param kes
     */
    public Quote(Kes kes) {
        super();
        this.kes = kes;
    }

    public Kes getKes() {
        return kes;
    }

    public void setKes(Kes kes) {
        this.kes = kes;
    }

}
