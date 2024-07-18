package com.gft.workshop.rutas;

import com.gft.workshop.rutas.model.DrivingRoute;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * Endpoints:
 * - `POST /routes`: Crear una nueva ruta.
 * - `GET /routes/{id}`: Obtener detalles de una ruta por ID.
 * - `PUT /routes/{id}`: Actualizar información de una ruta.
 * - `DELETE /routes/{id}`: Eliminar una ruta.
 */
//TODO ExceptionHandler or ControllerAdvice?

@RestController
public class RoutesController {

    RoutesService service;

    public RoutesController(RoutesService service) {
        this.service = service;
    }

    @PostMapping("/routes")
    public Mono<ResponseEntity<DrivingRoute>> createRoute(@RequestBody DrivingRoute newRoute) {
        return service.createRoute(newRoute).map(RoutesController::buildResponse)
                .onErrorReturn(ResponseEntity.badRequest().build());

    }

    @GetMapping("/routes/{id}")
    public Mono<ResponseEntity<DrivingRoute>> getRoute(@PathVariable Long id) {
        return service.getRoute(id).map(RoutesController::buildResponse);

    }

    @PutMapping("/routes/{id}")
    public Mono<ResponseEntity<DrivingRoute>> putRoute(
            @PathVariable Long id,
            @RequestBody DrivingRoute drivingRoute) {
        return service.putRoute(id, drivingRoute).map(RoutesController::buildResponse);
    }

    @DeleteMapping("/routes/{id}")
    public Mono<ResponseEntity<DrivingRoute>> deleteRoute(@PathVariable Long id) {
        return service.deleteRoute(id).map(RoutesController::buildResponse);
    }

    /**
     * Transforms a Mono of a Driving route into a Mono of a Response entity of the driving route.
     * @param drivingRoute
     * @return
     */

    private static ResponseEntity<DrivingRoute> buildResponse(DrivingRoute drivingRoute) {
        return new ResponseEntity<>(drivingRoute, HttpStatusCode.valueOf(200));
    }


}
