
package com.moringaschool.cryptonet.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Platform {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("token_address")
    @Expose
    private String tokenAddress;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    /**
     * 
     * @param tokenAddress
     * @param symbol
     * @param name
     * @param id
     * @param slug
     */
    public Platform(Integer id, String name, String symbol, String slug, String tokenAddress) {
        super();
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.tokenAddress = tokenAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTokenAddress() {
        return tokenAddress;
    }

    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

}
