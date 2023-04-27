package com.example.utils;

import java.util.List;

public class StatusResponse<StudentModel> {
	
	int statusCode;
    String statusMessage;
    boolean success;
    Long totalCount;
    String token;
    List<StudentModel> data;
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public Long getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public List<StudentModel> getData() {
        return data;
    }
    public void setData(List<StudentModel> data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "StatusResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", success=" + success
                + ", totalCount=" + totalCount + ", token=" + token + ", data=" + data + "]";
    }
	
	
	

}
