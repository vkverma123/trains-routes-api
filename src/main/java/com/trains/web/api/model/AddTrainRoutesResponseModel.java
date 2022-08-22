package com.trains.web.api.model;


public class AddTrainRoutesResponseModel {

    private int statusCode;
    private String message;

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }
    /**
     * @param statusCode the statusCode to set
     */
    public AddTrainRoutesResponseModel setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message the message to set
     */
    public AddTrainRoutesResponseModel setMessage(final String message) {
        this.message = message;
        return this;
    }

}
