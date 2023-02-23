package com.cadincloud.service;

import com.cadincloud.exceptions.ResourceNotFoundException;
import com.cadincloud.model.dto.RestaurantFilters;
import com.cadincloud.model.entity.RestaurantEntity;
import com.cadincloud.repository.RestaurantDao;
import com.cadincloud.service.validator.RestaurantValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantDao dao;
    private final RestaurantValidator validator;
    private final ObjectMapper mapper;

    public Page<RestaurantEntity> getRestaurants(RestaurantFilters filters, Pageable pageable) {
        return dao.getRestaurants(filters, pageable);
    }

    public RestaurantEntity getRestaurant(Long restaurantId) {
        return getRestaurantOrThrow(restaurantId);
    }

    public RestaurantEntity addRestaurant(RestaurantEntity newRestaurantEntity) {
        validator.validateRestaurantOrThrow(newRestaurantEntity);

        return dao.saveRestaurant(newRestaurantEntity);
    }

    public RestaurantEntity replaceRestaurant(Long restaurantId, RestaurantEntity newRestaurantEntity) {
        final var dbRestaurant = getRestaurantOrThrow(restaurantId);

        newRestaurantEntity.setId(restaurantId);
        newRestaurantEntity.setSince(dbRestaurant.getSince());
        validator.validateRestaurantOrThrow(newRestaurantEntity);

        return dao.saveRestaurant(newRestaurantEntity);
    }

    @SneakyThrows
    public RestaurantEntity patchRestaurant(Long restaurantId, JsonPatch patch) {
        final var dbRestaurant = getRestaurantOrThrow(restaurantId);
        final var patchedJson = patch.apply(mapper.valueToTree(dbRestaurant));
        final var patchedRestaurantEntity = mapper.treeToValue(patchedJson, RestaurantEntity.class);

        return replaceRestaurant(restaurantId, patchedRestaurantEntity);
    }

    public RestaurantEntity deleteRestaurant(Long restaurantId) {
        final var restaurantToDelete = getRestaurantOrThrow(restaurantId);

        dao.deleteRestaurant(restaurantId);

        return restaurantToDelete;
    }

    private RestaurantEntity getRestaurantOrThrow(Long restaurantId) {
        return dao.getRestaurant(restaurantId).orElseThrow(
                () -> new ResourceNotFoundException("Couldn't found restaurant with id: " + restaurantId));
    }
}
