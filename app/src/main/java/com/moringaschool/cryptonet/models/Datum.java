
package com.moringaschool.cryptonet.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.cryptonet.models.Platform;
import com.moringaschool.cryptonet.models.Quote;

public class Datum {

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
    @SerializedName("num_market_pairs")
    @Expose
    private Integer numMarketPairs;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("max_supply")
    @Expose
    private Long maxSupply;
    @SerializedName("circulating_supply")
    @Expose
    private Long circulatingSupply;
    @SerializedName("total_supply")
    @Expose
    private Long totalSupply;
    @SerializedName("platform")
    @Expose
    private Platform platform;
    @SerializedName("cmc_rank")
    @Expose
    private Integer cmcRank;
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
    public Datum(Integer id, String name, String symbol, String slug, Integer numMarketPairs, String dateAdded, List<String> tags, Long maxSupply, Long circulatingSupply, Long totalSupply, Platform platform, Integer cmcRank, Object selfReportedCirculatingSupply, Object selfReportedMarketCap, String lastUpdated, Quote quote) {
        super();
        this.id = id;
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

    public Integer getNumMarketPairs() {
        return numMarketPairs;
    }

    public void setNumMarketPairs(Integer numMarketPairs) {
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

    public Long getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Long maxSupply) {
        this.maxSupply = maxSupply;
    }

    public Long getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(Long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public Long getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Long totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Integer getCmcRank() {
        return cmcRank;
    }

    public void setCmcRank(Integer cmcRank) {
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

}
