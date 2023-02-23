package com.cadincloud.controller;

import com.cadincloud.model.api.Restaurant;
import com.cadincloud.model.dto.CollectionResponse;
import com.cadincloud.model.dto.PageInfo;
import com.cadincloud.model.dto.RestaurantFilters;
import com.cadincloud.model.entity.RestaurantEntity;
import com.cadincloud.model.mapper.RestaurantMapper;
import com.cadincloud.service.RestaurantService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("restaurants")
public class RestaurantController {
    private final RestaurantMapper mapper;
    private final RestaurantService service;

    @GetMapping
    CollectionResponse<Restaurant> getRestaurants(RestaurantFilters filters, Pageable pageable) {
        final var restaurants = service.getRestaurants(filters, pageable);
        return new CollectionResponse<>(
                mapper.entityToApi(restaurants.getContent()),
                new PageInfo(
                        restaurants.getTotalPages(),
                        restaurants.getTotalElements(),
                        pageable.getPageNumber(),
                        pageable.getPageSize()));
    }

    @GetMapping("{restaurantId}")
    Restaurant getRestaurant(@PathVariable Long restaurantId) {
        return mapper.entityToApi(
                service.getRestaurant(restaurantId));
    }

    @PostMapping
    Restaurant addRestaurant(@RequestBody RestaurantEntity newRestaurantEntity) {
        return mapper.entityToApi(
                service.addRestaurant(newRestaurantEntity));
    }

    @PutMapping("{restaurantId}")
    Restaurant replaceRestaurant(@PathVariable Long restaurantId,
                                 @RequestBody Restaurant newRestaurant) {
        return mapper.entityToApi(
                service.replaceRestaurant(restaurantId, mapper.apiToEntity(newRestaurant)));
    }

    @PatchMapping("{restaurantId}")
    Restaurant patchRestaurant(@PathVariable Long restaurantId, @RequestBody JsonPatch patch) {
        return mapper.entityToApi(
                service.patchRestaurant(restaurantId, patch));
    }

    @DeleteMapping("{restaurantId}")
    Restaurant deleteRestaurant(@PathVariable Long restaurantId) {
        return mapper.entityToApi(
                service.deleteRestaurant(restaurantId));
    }
}
