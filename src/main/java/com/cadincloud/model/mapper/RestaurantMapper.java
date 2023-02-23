package com.cadincloud.model.mapper;

import com.cadincloud.model.api.Restaurant;
import com.cadincloud.model.entity.RestaurantEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    Restaurant entityToApi(RestaurantEntity source);

    RestaurantEntity apiToEntity(Restaurant destination);

    List<Restaurant> entityToApi(List<RestaurantEntity> source);

    List<RestaurantEntity> apiToEntity(List<Restaurant> destination);
}
