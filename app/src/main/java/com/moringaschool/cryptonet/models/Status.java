
package com.moringaschool.cryptonet.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("error_code")
    @Expose
    private int errorCode;
    @SerializedName("error_message")
    @Expose
    private Object errorMessage;
    @SerializedName("elapsed")
    @Expose
    private int elapsed;
    @SerializedName("credit_count")
    @Expose
    private int creditCount;
    @SerializedName("notice")
    @Expose
    private Object notice;
    @SerializedName("total_count")
    @Expose
    private int totalCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Status() {
    }

    /**
     * 
     * @param elapsed
     * @param errorMessage
     * @param errorCode
     * @param creditCount
     * @param totalCount
     * @param timestamp
     * @param notice
     */
    public Status(String timestamp, int errorCode, Object errorMessage, int elapsed, int creditCount, Object notice, int totalCount) {
        super();
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.elapsed = elapsed;
        this.creditCount = creditCount;
        this.notice = notice;
        this.totalCount = totalCount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getElapsed() {
        return elapsed;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }

    public int getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(int creditCount) {
        this.creditCount = creditCount;
    }

    public Object getNotice() {
        return notice;
    }

    public void setNotice(Object notice) {
        this.notice = notice;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
