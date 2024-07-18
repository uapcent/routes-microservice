package com.gft.workshop.rutas.model;

import com.gft.workshop.rutas.model.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 *     {
 *       "stopId": "1",
 *       "stopName": "Estación Central",
 *       "coordinates": {
 *         "latitude": 40.712776,
 *         "longitude": -74.005974
 *       },
 *       "arrivalTimes": [
 *         "08:00",
 *         "08:30",
 *         "09:00"
 *       ]
 *     },
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RouteStop {

    private int stopId;
    private String stopName;
    private Location coordinates;
    private Collection<String> arrivalTimes;
}
