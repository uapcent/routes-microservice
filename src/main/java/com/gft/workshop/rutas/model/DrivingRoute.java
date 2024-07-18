package com.gft.workshop.rutas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

/**
 * {
 *   "routeId": "123",
 *   "routeName": "Ruta Centro-Norte",
 *   "stops": [ {} ],
 *   "schedule": {
 *     "weekdays": {
 *       "startTime": "06:00",
 *       "endTime": "22:00",
 *       "frequencyMinutes": 15
 *     },
 *     "weekends": {
 *       "startTime": "07:00",
 *       "endTime": "20:00",
 *       "frequencyMinutes": 20
 *     }
 *   }
 * }
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class DrivingRoute {
    @Id
    private String routeId;
    private String routeName;
    private Collection<RouteStop> stops;
    //TODO schedule
}
