
package com.moringaschool.cryptonet.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("num_market_pairs")
    @Expose
    private int numMarketPairs;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("max_supply")
    @Expose
    private Object maxSupply;
    @SerializedName("circulating_supply")
    @Expose
    private double circulatingSupply;
    @SerializedName("total_supply")
    @Expose
    private double totalSupply;
    @SerializedName("platform")
    @Expose
    private Platform platform;
    @SerializedName("cmc_rank")
    @Expose
    private int cmcRank;
    @SerializedName("self_reported_circulating_supply")
    @Expose
    private Object selfReportedCirculatingSupply;
    @SerializedName("self_reported_market_cap")
    @Expose
    private Object selfReportedMarketCap;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("quote")
    @Expose
    private Quote quote;

    private String pushId;



    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param symbol
     * @param selfReportedCirculatingSupply
     * @param totalSupply
     * @param cmcRank
     * @param selfReportedMarketCap
     * @param dateAdded
     * @param circulatingSupply
     * @param platform
     * @param tags
     * @param lastUpdated
     * @param quote
     * @param numMarketPairs
     * @param name
     * @param id
     * @param maxSupply
     * @param slug
     */
    public Datum(int id, double price, String name, String symbol, String slug, int numMarketPairs, String dateAdded, List<String> tags, Object maxSupply, double circulatingSupply, double totalSupply, Platform platform, int cmcRank, Object selfReportedCirculatingSupply, Object selfReportedMarketCap, String lastUpdated, Quote quote) {
        super();
        this.id = id;
        this.price = price;
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.numMarketPairs = numMarketPairs;
        this.dateAdded = dateAdded;
        this.tags = tags;
        this.maxSupply = maxSupply;
        this.circulatingSupply = circulatingSupply;
        this.totalSupply = totalSupply;
        this.platform = platform;
        this.cmcRank = cmcRank;
        this.selfReportedCirculatingSupply = selfReportedCirculatingSupply;
        this.selfReportedMarketCap = selfReportedMarketCap;
        this.lastUpdated = lastUpdated;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
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

    public int getNumMarketPairs() {
        return numMarketPairs;
    }

    public void setNumMarketPairs(int numMarketPairs) {
        this.numMarketPairs = numMarketPairs;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Object getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Object maxSupply) {
        this.maxSupply = maxSupply;
    }

    public double getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(double circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public int getCmcRank() {
        return cmcRank;
    }

    public void setCmcRank(int cmcRank) {
        this.cmcRank = cmcRank;
    }

    public Object getSelfReportedCirculatingSupply() {
        return selfReportedCirculatingSupply;
    }

    public void setSelfReportedCirculatingSupply(Object selfReportedCirculatingSupply) {
        this.selfReportedCirculatingSupply = selfReportedCirculatingSupply;
    }

    public Object getSelfReportedMarketCap() {
        return selfReportedMarketCap;
    }

    public void setSelfReportedMarketCap(Object selfReportedMarketCap) {
        this.selfReportedMarketCap = selfReportedMarketCap;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }


 // UID for every user (USER ID)
    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
