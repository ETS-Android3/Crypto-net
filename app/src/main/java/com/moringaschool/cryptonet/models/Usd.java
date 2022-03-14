
package com.moringaschool.cryptonet.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usd extends Quote{

    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("volume_24h")
    @Expose
    private double volume24h;
    @SerializedName("volume_change_24h")
    @Expose
    private double volumeChange24h;
    @SerializedName("percent_change_1h")
    @Expose
    private double percentChange1h;
    @SerializedName("percent_change_24h")
    @Expose
    private double percentChange24h;
    @SerializedName("percent_change_7d")
    @Expose
    private double percentChange7d;
    @SerializedName("percent_change_30d")
    @Expose
    private double percentChange30d;
    @SerializedName("percent_change_60d")
    @Expose
    private double percentChange60d;
    @SerializedName("percent_change_90d")
    @Expose
    private double percentChange90d;
    @SerializedName("market_cap")
    @Expose
    private double marketCap;
    @SerializedName("market_cap_dominance")
    @Expose
    private double marketCapDominance;
    @SerializedName("fully_diluted_market_cap")
    @Expose
    private double fullyDilutedMarketCap;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Usd() {
    }

    /**
     * 
     * @param marketCap
     * @param volume24h
     * @param marketCapDominance
     * @param percentChange30d
     * @param volumeChange24h
     * @param lastUpdated
     * @param percentChange24h
     * @param percentChange7d
     * @param price
     * @param percentChange60d
     * @param fullyDilutedMarketCap
     * @param percentChange90d
     * @param percentChange1h
     */
    public Usd(double price, double volume24h, double volumeChange24h, double percentChange1h, double percentChange24h, double percentChange7d, double percentChange30d, double percentChange60d, double percentChange90d, double marketCap, double marketCapDominance, double fullyDilutedMarketCap, String lastUpdated) {
        super();
        this.price = price;
        this.volume24h = volume24h;
        this.volumeChange24h = volumeChange24h;
        this.percentChange1h = percentChange1h;
        this.percentChange24h = percentChange24h;
        this.percentChange7d = percentChange7d;
        this.percentChange30d = percentChange30d;
        this.percentChange60d = percentChange60d;
        this.percentChange90d = percentChange90d;
        this.marketCap = marketCap;
        this.marketCapDominance = marketCapDominance;
        this.fullyDilutedMarketCap = fullyDilutedMarketCap;
        this.lastUpdated = lastUpdated;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(double volume24h) {
        this.volume24h = volume24h;
    }

    public double getVolumeChange24h() {
        return volumeChange24h;
    }

    public void setVolumeChange24h(double volumeChange24h) {
        this.volumeChange24h = volumeChange24h;
    }

    public double getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(double percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public double getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(double percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public double getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(double percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public double getPercentChange30d() {
        return percentChange30d;
    }

    public void setPercentChange30d(double percentChange30d) {
        this.percentChange30d = percentChange30d;
    }

    public double getPercentChange60d() {
        return percentChange60d;
    }

    public void setPercentChange60d(double percentChange60d) {
        this.percentChange60d = percentChange60d;
    }

    public double getPercentChange90d() {
        return percentChange90d;
    }

    public void setPercentChange90d(double percentChange90d) {
        this.percentChange90d = percentChange90d;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public double getMarketCapDominance() {
        return marketCapDominance;
    }

    public void setMarketCapDominance(double marketCapDominance) {
        this.marketCapDominance = marketCapDominance;
    }

    public double getFullyDilutedMarketCap() {
        return fullyDilutedMarketCap;
    }

    public void setFullyDilutedMarketCap(double fullyDilutedMarketCap) {
        this.fullyDilutedMarketCap = fullyDilutedMarketCap;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
