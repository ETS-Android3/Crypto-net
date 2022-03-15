
package com.moringaschool.cryptonet.model2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("website")
    @Expose
    private List<String> website = null;
    @SerializedName("twitter")
    @Expose
    private List<Object> twitter = null;
    @SerializedName("message_board")
    @Expose
    private List<String> messageBoard = null;
    @SerializedName("chat")
    @Expose
    private List<Object> chat = null;
    @SerializedName("facebook")
    @Expose
    private List<Object> facebook = null;
    @SerializedName("explorer")
    @Expose
    private List<String> explorer = null;
    @SerializedName("reddit")
    @Expose
    private List<String> reddit = null;
    @SerializedName("technical_doc")
    @Expose
    private List<String> technicalDoc = null;
    @SerializedName("source_code")
    @Expose
    private List<String> sourceCode = null;
    @SerializedName("announcement")
    @Expose
    private List<Object> announcement = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Urls() {
    }

    /**
     * 
     * @param sourceCode
     * @param website
     * @param twitter
     * @param messageBoard
     * @param chat
     * @param facebook
     * @param explorer
     * @param reddit
     * @param technicalDoc
     * @param announcement
     */
    public Urls(List<String> website, List<Object> twitter, List<String> messageBoard, List<Object> chat, List<Object> facebook, List<String> explorer, List<String> reddit, List<String> technicalDoc, List<String> sourceCode, List<Object> announcement) {
        super();
        this.website = website;
        this.twitter = twitter;
        this.messageBoard = messageBoard;
        this.chat = chat;
        this.facebook = facebook;
        this.explorer = explorer;
        this.reddit = reddit;
        this.technicalDoc = technicalDoc;
        this.sourceCode = sourceCode;
        this.announcement = announcement;
    }

    public List<String> getWebsite() {
        return website;
    }

    public void setWebsite(List<String> website) {
        this.website = website;
    }

    public List<Object> getTwitter() {
        return twitter;
    }

    public void setTwitter(List<Object> twitter) {
        this.twitter = twitter;
    }

    public List<String> getMessageBoard() {
        return messageBoard;
    }

    public void setMessageBoard(List<String> messageBoard) {
        this.messageBoard = messageBoard;
    }

    public List<Object> getChat() {
        return chat;
    }

    public void setChat(List<Object> chat) {
        this.chat = chat;
    }

    public List<Object> getFacebook() {
        return facebook;
    }

    public void setFacebook(List<Object> facebook) {
        this.facebook = facebook;
    }

    public List<String> getExplorer() {
        return explorer;
    }

    public void setExplorer(List<String> explorer) {
        this.explorer = explorer;
    }

    public List<String> getReddit() {
        return reddit;
    }

    public void setReddit(List<String> reddit) {
        this.reddit = reddit;
    }

    public List<String> getTechnicalDoc() {
        return technicalDoc;
    }

    public void setTechnicalDoc(List<String> technicalDoc) {
        this.technicalDoc = technicalDoc;
    }

    public List<String> getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(List<String> sourceCode) {
        this.sourceCode = sourceCode;
    }

    public List<Object> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(List<Object> announcement) {
        this.announcement = announcement;
    }

}
