package com.trains.web.api.mapper;

import com.trains.web.api.model.TrainRoutes;
import com.trains.web.api.model.TrainsResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * TrainsResponseDataModelMapper Class.
 */
@Component
public class TrainsResponseDataModelMapper implements IMapper<List<TrainRoutes>, TrainsResponseModel> {

    private static final String SUCCESS = "success";
    private static final String NOT_FOUND = "not found";
    /**
     * Maps a list of {@link TrainRoutes} to a list of {@link TrainsResponseModel}.
     */
    @Override
    public TrainsResponseModel map(final List<TrainRoutes> routesList) {

        final List<TrainRoutes> routes = new ArrayList<>();
        for (final TrainRoutes trainRequestData: routesList) {
            final TrainRoutes train = new TrainRoutes();
            train.setCost(trainRequestData.getCost());
            train.setTime(trainRequestData.getTime());
            train.setStations(trainRequestData.getStations());
            routes.add(train);
        }

        final TrainsResponseModel responseModel = new TrainsResponseModel();
        if (routes.isEmpty()) {
            responseModel.setStatusCode(HttpStatus.NOT_FOUND.value());
            responseModel.setMessage(NOT_FOUND);
        }
        else {
            responseModel.setRoutes(routes);
            responseModel.setStatusCode(HttpStatus.OK.value());
            responseModel.setMessage(SUCCESS);
        }

        return responseModel;
    }
}
