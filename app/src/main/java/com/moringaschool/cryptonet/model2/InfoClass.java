
package com.moringaschool.cryptonet.model2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.cryptonet.model2.Urls;

public class InfoClass {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("subreddit")
    @Expose
    private String subreddit;
    @SerializedName("notice")
    @Expose
    private String notice;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("tag-names")
    @Expose
    private List<String> tagNames = null;
    @SerializedName("tag-groups")
    @Expose
    private List<String> tagGroups = null;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("platform")
    @Expose
    private Object platform;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("twitter_username")
    @Expose
    private String twitterUsername;
    @SerializedName("is_hidden")
    @Expose
    private int isHidden;
    @SerializedName("date_launched")
    @Expose
    private Object dateLaunched;
    @SerializedName("contract_address")
    @Expose
    private List<Object> contractAddress = null;
    @SerializedName("self_reported_circulating_supply")
    @Expose
    private Object selfReportedCirculatingSupply;
    @SerializedName("self_reported_tags")
    @Expose
    private Object selfReportedTags;
    @SerializedName("self_reported_market_cap")
    @Expose
    private Object selfReportedMarketCap;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InfoClass() {
    }

    /**
     * 
     * @param symbol
     * @param selfReportedCirculatingSupply
     * @param description
     * @param contractAddress
     * @param dateLaunched
     * @param selfReportedMarketCap
     * @param subreddit
     * @param tagNames
     * @param platform
     * @param dateAdded
     * @param tags
     * @param isHidden
     * @param twitterUsername
     * @param urls
     * @param tagGroups
     * @param name
     * @param logo
     * @param id
     * @param category
     * @param slug
     * @param notice
     * @param selfReportedTags
     */
    public InfoClass(int id, String name, String symbol, String category, String description, String slug, String logo, String subreddit, String notice, List<String> tags, List<String> tagNames, List<String> tagGroups, Urls urls, Object platform, String dateAdded, String twitterUsername, int isHidden, Object dateLaunched, List<Object> contractAddress, Object selfReportedCirculatingSupply, Object selfReportedTags, Object selfReportedMarketCap) {
        super();
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.category = category;
        this.description = description;
        this.slug = slug;
        this.logo = logo;
        this.subreddit = subreddit;
        this.notice = notice;
        this.tags = tags;
        this.tagNames = tagNames;
        this.tagGroups = tagGroups;
        this.urls = urls;
        this.platform = platform;
        this.dateAdded = dateAdded;
        this.twitterUsername = twitterUsername;
        this.isHidden = isHidden;
        this.dateLaunched = dateLaunched;
        this.contractAddress = contractAddress;
        this.selfReportedCirculatingSupply = selfReportedCirculatingSupply;
        this.selfReportedTags = selfReportedTags;
        this.selfReportedMarketCap = selfReportedMarketCap;
    }

    public int getId() {
        return id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTagNames() {
        return tagNames;
    }

    public void setTagNames(List<String> tagNames) {
        this.tagNames = tagNames;
    }

    public List<String> getTagGroups() {
        return tagGroups;
    }

    public void setTagGroups(List<String> tagGroups) {
        this.tagGroups = tagGroups;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Object getPlatform() {
        return platform;
    }

    public void setPlatform(Object platform) {
        this.platform = platform;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public int getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(int isHidden) {
        this.isHidden = isHidden;
    }

    public Object getDateLaunched() {
        return dateLaunched;
    }

    public void setDateLaunched(Object dateLaunched) {
        this.dateLaunched = dateLaunched;
    }

    public List<Object> getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(List<Object> contractAddress) {
        this.contractAddress = contractAddress;
    }

    public Object getSelfReportedCirculatingSupply() {
        return selfReportedCirculatingSupply;
    }

    public void setSelfReportedCirculatingSupply(Object selfReportedCirculatingSupply) {
        this.selfReportedCirculatingSupply = selfReportedCirculatingSupply;
    }

    public Object getSelfReportedTags() {
        return selfReportedTags;
    }

    public void setSelfReportedTags(Object selfReportedTags) {
        this.selfReportedTags = selfReportedTags;
    }

    public Object getSelfReportedMarketCap() {
        return selfReportedMarketCap;
    }

    public void setSelfReportedMarketCap(Object selfReportedMarketCap) {
        this.selfReportedMarketCap = selfReportedMarketCap;
    }

}
