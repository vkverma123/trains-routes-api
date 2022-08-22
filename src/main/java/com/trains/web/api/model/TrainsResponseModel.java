package com.trains.web.api.model;

import java.util.List;

/**
 * TrainsResponseModel Class.
 */
public class TrainsResponseModel {

    private List<TrainRoutes> routes;
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
    public TrainsResponseModel setStatusCode(int statusCode) {
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
    public TrainsResponseModel setMessage(final String message) {
        this.message = message;
        return this;
    }
    /**
     * @return the data
     */
    public List<TrainRoutes> getRoutes() {
        return routes;
    }
    /**
     * @param routes the routes to set
     */
    public TrainsResponseModel setRoutes(List<TrainRoutes> routes) {
        this.routes = routes;
        return this;
    }

}
