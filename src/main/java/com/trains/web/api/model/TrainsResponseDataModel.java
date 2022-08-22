package com.trains.web.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TrainsResponseDataModel Class.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainsResponseDataModel {
    private List<TrainRoutes> trainResponseList;
}
