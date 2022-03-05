
package com.moringaschool.cryptonet.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    /** A Status object is always included for both successful calls and failures when possible.
     * The Status object always includes the current time on the server when the call was executed as timestamp,
     * the number of API call credits this call utilized as credit_count, and the number of milliseconds it took to process the request as elapsed.
     * Any details about errors encountered can be found under the error_code and error_message
     * */

    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("error_code")
    @Expose
    private Integer errorCode;
    @SerializedName("error_message")
    @Expose
    private Object errorMessage;
    @SerializedName("elapsed")
    @Expose
    private Integer elapsed;
    @SerializedName("credit_count")
    @Expose
    private Integer creditCount;
    @SerializedName("notice")
    @Expose
    private Object notice;
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;

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
    public Status(String timestamp, Integer errorCode, Object errorMessage, Integer elapsed, Integer creditCount, Object notice, Integer totalCount) {
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

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public void setElapsed(Integer elapsed) {
        this.elapsed = elapsed;
    }

    public Integer getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(Integer creditCount) {
        this.creditCount = creditCount;
    }

    public Object getNotice() {
        return notice;
    }

    public void setNotice(Object notice) {
        this.notice = notice;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}
