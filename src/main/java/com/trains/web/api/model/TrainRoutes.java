package com.trains.web.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Train Routes DataModel Class.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainRoutes {

    private List<String> stations;
    private Integer time;
    private Integer cost;
}