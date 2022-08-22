package com.trains.web.api.init;

import com.trains.web.api.model.AddTrainRoutesResponseModel;
import com.trains.web.api.model.TrainRoutes;
import com.trains.web.api.model.TrainsResponseDataModel;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * TrainsRepository Class.
 */
@Getter
@Setter
@Component
public class TrainRepository {

    private static final String TRAINS_ROUTES_DB_PATH = "src/main/resources/static/trainsdb.csv";
    private static final String SUCCESS = "success";

    /**
     * Setup Csv Parser.
     * @return trainsResponseDataModel TrainsResponseDataModel
     */
    @Bean
    public TrainsResponseDataModel parse() throws IOException {

        CSVReader reader =
                new CSVReaderBuilder(new FileReader(TRAINS_ROUTES_DB_PATH)).
                        withSkipLines(0).
                        build();
        List<TrainRoutes> trains = reader.readAll().stream().map(data -> {
            TrainRoutes csvObject = new TrainRoutes();

            List<String> stations = new ArrayList<>();
            stations.add(data[0]);
            stations.add(data[1]);

            csvObject.setStations(stations);
            csvObject.setTime(Integer.valueOf(data[2]));
            csvObject.setCost(Integer.valueOf(data[3]));
            return csvObject;
        }).collect(Collectors.toList());

        TrainsResponseDataModel trainsResponseDataModel = new TrainsResponseDataModel();
        trainsResponseDataModel.setTrainResponseList(trains);

        return trainsResponseDataModel;
    }

    public AddTrainRoutesResponseModel write(TrainRoutes trainRoute) throws IOException {

        FileWriter csvWriter = new FileWriter(TRAINS_ROUTES_DB_PATH, true);
        csvWriter.append(trainRoute.getStations().get(0));
        csvWriter.append(",");
        csvWriter.append(trainRoute.getStations().get(1));
        csvWriter.append(",");
        csvWriter.append(trainRoute.getTime().toString());
        csvWriter.append(",");
        csvWriter.append(trainRoute.getCost().toString());
        csvWriter.append("\n");

        csvWriter.close();
        AddTrainRoutesResponseModel addTrainRoutesResponseModel = new AddTrainRoutesResponseModel();
        addTrainRoutesResponseModel.setStatusCode(HttpStatus.OK.value());
        addTrainRoutesResponseModel.setMessage(SUCCESS);
        return addTrainRoutesResponseModel;
    }
}

