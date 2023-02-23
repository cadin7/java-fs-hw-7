package com.cadincloud.service.validator;

import com.cadincloud.exceptions.ValidationException;
import com.cadincloud.model.dto.City;
import com.cadincloud.model.entity.RestaurantEntity;
import com.cadincloud.repository.RestaurantDao;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

import static java.time.LocalDate.now;
import static java.util.Optional.empty;
import static java.util.Optional.of;


@Component
@RequiredArgsConstructor
public class RestaurantValidator {
    private final RestaurantDao dao;
    private final Environment environment;
    private final City city;

    public void validateRestaurantOrThrow(RestaurantEntity restaurantEntity) {
        validate(restaurantEntity)
                .ifPresent(e -> {
                    throw e;
                });
    }

    private Optional<ValidationException> validate(RestaurantEntity restaurantEntity) {
        if (restaurantEntity.getName() == null) {
            return of(new ValidationException("RestaurantEntity name cannot be NULL!"));
        } else if (!city.getCities().contains(restaurantEntity.getCity())) {
            return of(new ValidationException("RestaurantEntity city must be from: "
                    + Arrays.toString(environment.getActiveProfiles())));
        } else if (dao.existsByNameAndIdNot(restaurantEntity)) {
            return of(new ValidationException("RestaurantEntity name cannot be duplicated!"));
        } else if (now().isBefore(restaurantEntity.getSince())) {
            return of(new ValidationException("RestaurantEntity since date must be older than current date!"));
        } else {
            return empty();
        }
    }
}
