package com.gft.workshop.rutas;

import com.gft.workshop.rutas.model.DrivingRoute;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@DirtiesContext
@WebFluxTest(controllers = RoutesController.class)
class RoutesControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private RoutesService routesService;

    @Test
    void createRoute() {

        var route = DrivingRoute.builder()
                .routeId("123")
                .routeName("Avenida del Mar")
                .stops(null)
                .build();

        when(routesService.createRoute(any())).thenReturn(Mono.just(route));

        Mono<DrivingRoute> result = webTestClient.post().uri(uriBuilder -> uriBuilder
                        .path("/routes")
                        .build())
                .body(Mono.just(route), DrivingRoute.class)
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(DrivingRoute.class)
                .getResponseBody()
                .single();

        StepVerifier.create(result).expectNextMatches(response -> response.equals(route)).verifyComplete();
    }

    @Test
    void getRoute() {
        var route = DrivingRoute.builder()
                .routeId("123")
                .routeName("Avenida del Mar")
                .stops(null)
                .build();

        when(routesService.getRoute(anyLong())).thenReturn(Mono.just(route));

        Mono<DrivingRoute> result = webTestClient.get().uri(uriBuilder -> uriBuilder
                        .path("/routes")
                        .queryParam("id", "123")
                        .build())
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(DrivingRoute.class)
                .getResponseBody()
                .single();

        StepVerifier.create(result).expectNextMatches(response -> response.equals(route)).verifyComplete();
    }

    @Test
    void putRoute() {
        var route = DrivingRoute.builder()
                .routeId("123")
                .routeName("Avenida del Mar")
                .stops(null)
                .build();

        when(routesService.putRoute(anyLong(), any(DrivingRoute.class))).thenReturn(Mono.just(route));

        Mono<DrivingRoute> result = webTestClient.put().uri(uriBuilder -> uriBuilder
                        .path("/routes")
                        .queryParam("id", "123")

                        .build())
                .body(Mono.just(route), DrivingRoute.class)
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(DrivingRoute.class)
                .getResponseBody()
                .single();

        StepVerifier.create(result).expectNextMatches(response -> response.equals(route)).verifyComplete();
    }

    @Test
    void deleteRoute() {
        var route = DrivingRoute.builder()
                .routeId("123")
                .routeName("Avenida del Mar")
                .stops(null)
                .build();

        when(routesService.deleteRoute(anyLong())).thenReturn(Mono.just(route));

        Mono<DrivingRoute> result = webTestClient.delete().uri(uriBuilder -> uriBuilder
                        .path("/routes")
                        .queryParam("id", "123")
                        .build())
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(DrivingRoute.class)
                .getResponseBody()
                .single();

        StepVerifier.create(result).expectNextMatches(response -> response.equals(route)).verifyComplete();
    }
}