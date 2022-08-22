package com.trains.web.api.controller;

import com.trains.web.api.common.ApplicationErrorType;
import com.trains.web.api.model.AddTrainRoutesResponseModel;
import com.trains.web.api.model.ErrorDetailsType;
import com.trains.web.api.model.TrainRoutes;
import com.trains.web.api.model.TrainsResponseModel;
import com.trains.web.api.service.TrainsService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Trains Controller.
 */
@RestController
public class TrainsController {

    private static final Logger LOGGER = LogManager.getLogger(TrainsController.class);
    private static final String ERROR_MESSAGE = "Sorry, Cannot process this request";

    private final TrainsService trainsService;

    /**
     * TrainsController constructor.
     * @param trainsService {@link TrainsService}.
     */
    @Autowired
    public TrainsController(
            final TrainsService trainsService) {
        this.trainsService = trainsService;
    }

    /**
     * Gets Train Route Details By Station Name.
     * @param stationName String.
     * @return ResponseEntity TrainsResponseDataModel.
     */
    @ApiOperation(value = "Get Trains Data By Station Name")
    @GetMapping("/station/{stationName}")
    @ResponseBody
    public ResponseEntity getTrainRoutesByStationName(@PathVariable("stationName") String stationName) {
        try {
            return getTrainsRoutesByStation(stationName);
        } catch (final Exception exception) {
            LOGGER.error(exception);
            return getErrorResponse(exception);
        }
    }

    /**
     * Add Train Route Details
     * @return ResponseEntity response.
     */
    @ApiOperation(value = "Add Trains Route")
    @PostMapping("/station")
    @ResponseBody
    public ResponseEntity addTrainStationsRoutes(@RequestBody TrainRoutes trainRoute) {
        try {
            return addTrainRoute(trainRoute);
        } catch (final Exception exception) {
            LOGGER.error(exception);
            return getErrorResponse(exception);
        }
    }

    /**
     * Gets Train Route Details
     * @return ResponseEntity TrainsResponseDataModel.
     */
    @ApiOperation(value = "Get Trains Routes")
    @GetMapping("/stations")
    @ResponseBody
    public ResponseEntity getAllTrainRoutes() {
        try {
            return getAllRoutes();
        } catch (final Exception exception) {
            LOGGER.error(exception);
            return getErrorResponse(exception);
        }
    }

    /**
     * Gets Error Response in case of Exception.
     * @param exception Exception.
     * @return ResponseEntity.
     */
    private ResponseEntity getErrorResponse(final Exception exception) {

        final ErrorDetailsType errorDetailsType = new ErrorDetailsType();
        errorDetailsType.setErrorCode(ApplicationErrorType.INTERNAL_SERVER_ERROR.name());
        errorDetailsType.setErrorMessage(ERROR_MESSAGE);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
                .body(errorDetailsType);
    }

    /**
     * Gets TrainRoutes by StationName.
     * @param stationName String.
     * @return ResponseEntity.
     */
    private ResponseEntity<TrainsResponseModel> getTrainsRoutesByStation(String stationName) throws IOException {
        TrainsResponseModel responseModel = trainsService.getTrainsRoutesDataByStation(stationName);
        return ResponseEntity.status(responseModel.getStatusCode()).body(responseModel);
    }

    /**
     * Gets TrainRoutes.
     * @return ResponseEntity.
     */
    private ResponseEntity<TrainsResponseModel> getAllRoutes() throws IOException {
        TrainsResponseModel responseModel = trainsService.getAllTrainsRoutes();
        return ResponseEntity.status(responseModel.getStatusCode()).body(responseModel);
    }

    /**
     * Gets TrainRoutes.
     * @return ResponseEntity.
     */
    private ResponseEntity addTrainRoute(TrainRoutes trainRoutes) throws IOException {
        AddTrainRoutesResponseModel addTrainRoutesResponseModel = trainsService.addTrainRoute(trainRoutes);
        return ResponseEntity.status(addTrainRoutesResponseModel.getStatusCode()).body(addTrainRoutesResponseModel);
    }
}
