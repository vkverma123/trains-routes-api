package com.trains.web.api.service;

import com.trains.web.api.init.TrainRepository;
import com.trains.web.api.mapper.TrainsResponseDataModelMapper;
import com.trains.web.api.model.AddTrainRoutesResponseModel;
import com.trains.web.api.model.TrainRoutes;
import com.trains.web.api.model.TrainsResponseDataModel;
import com.trains.web.api.model.TrainsResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Trains Service.
 */
@Component
public class TrainsService {

    private final TrainRepository trainRepository;
    private final TrainsResponseDataModelMapper trainsResponseDataModelMapper;

    /**
     * TrainsService constructor.
     * @param trainRepository {@link TrainRepository}
     * @param trainsResponseDataModelMapper {@link TrainsResponseDataModelMapper}
     */
    @Autowired
    public TrainsService(
            final TrainRepository trainRepository,
            final TrainsResponseDataModelMapper trainsResponseDataModelMapper) {
        this.trainRepository = trainRepository;
        this.trainsResponseDataModelMapper = trainsResponseDataModelMapper;
    }

    /**
     * Gets Train Routes By RoomType.
     * @param name String.
     * @return trainsResponseModel TrainsResponseModel.
     */
    public TrainsResponseModel getTrainsRoutesDataByStation(final String name) throws IOException {
        final TrainsResponseDataModel responseDataModel = trainRepository.parse();

        List<TrainRoutes> trainsList = responseDataModel.getTrainResponseList().stream().filter(train ->  (name.equalsIgnoreCase(train.getStations().get(0)) || name.equalsIgnoreCase(train.getStations().get(1)))
        ).collect(Collectors.toList());

        final TrainsResponseModel responseModel = trainsResponseDataModelMapper.map(trainsList);

        return responseModel;
    }


    /**
     * Gets All Train Routes
     * @return trainsResponseModel TrainsResponseModel.
     */
    public TrainsResponseModel getAllTrainsRoutes() throws IOException {
        final TrainsResponseDataModel responseDataModel = trainRepository.parse();

        List<TrainRoutes> trainsList = responseDataModel.getTrainResponseList().stream().collect(Collectors.toList());

        final TrainsResponseModel responseModel = trainsResponseDataModelMapper.map(trainsList);

        return responseModel;
    }

    /**
     * Add Train Route
     * @return addTrainRoutesResponseModel AddTrainRoutesResponseModel.
     */
    public AddTrainRoutesResponseModel addTrainRoute(TrainRoutes trainRoute) throws IOException {
        final AddTrainRoutesResponseModel responseDataModel = trainRepository.write(trainRoute);
        return responseDataModel;
    }
}
