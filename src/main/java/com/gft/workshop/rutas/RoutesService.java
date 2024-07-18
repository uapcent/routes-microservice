package com.gft.workshop.rutas;

import com.gft.workshop.rutas.model.DrivingRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RoutesService {

    private final RouteRepository routeRepository;

    @Autowired
    public RoutesService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;

    }

    public Mono<DrivingRoute> deleteRoute(Long id) {
        return routeRepository.deleteRoute(id);
    }

    public Mono<DrivingRoute> putRoute(Long id, DrivingRoute drivingRoute) {
        return routeRepository.findById(String.valueOf(id)).flatMap(existingRoute -> {
            existingRoute.setRouteName(drivingRoute.getRouteName());
            existingRoute.setStops(drivingRoute.getStops());
//TODO            existingRoute.setSchedule(drivingRoute.getSchedule());
            return routeRepository.save(existingRoute);
        });
    }

    public Mono<DrivingRoute> getRoute(Long id) {
        return routeRepository.getRoute(id);
    }

    public Mono<DrivingRoute> createRoute(DrivingRoute route) {
        return routeRepository.createRoute(route);
    }
}
