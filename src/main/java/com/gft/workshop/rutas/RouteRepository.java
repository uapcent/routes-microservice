package com.gft.workshop.rutas;

import com.gft.workshop.rutas.model.DrivingRoute;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RouteRepository extends ReactiveMongoRepository<DrivingRoute, String> {
    Mono<DrivingRoute> deleteRoute(Long id);

    Mono<DrivingRoute> getRoute(Long id);

    Mono<DrivingRoute> putRoute(Long id);

    Mono<DrivingRoute> createRoute(DrivingRoute route);
}
