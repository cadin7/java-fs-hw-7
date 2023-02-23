package com.cadincloud.repository;

import com.cadincloud.model.entity.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
    boolean existsByNameAndIdNot(String restaurantName, long id);
}
