package com.cadincloud.bootstrap;

import com.cadincloud.model.entity.RestaurantEntity;
import com.cadincloud.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.time.LocalDate.now;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RestaurantService service;

    @Override
    public void run(String... args) throws Exception {
        final var restaurants = List.of(
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 1")
                        .city("Oradea")
                        .since(now().minusYears(1))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 2")
                        .city("Oradea")
                        .since(now().minusYears(2))
                        .stars(5)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 3")
                        .city("Bors")
                        .since(now().minusYears(3))
                        .stars(2)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 4")
                        .city("Oradea")
                        .since(now().minusYears(4))
                        .stars(1)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 5")
                        .city("Iasi")
                        .since(now().minusYears(5))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 6")
                        .city("Oradea")
                        .since(now().minusYears(1))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 7")
                        .city("Oradea")
                        .since(now().minusYears(2))
                        .stars(5)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 8")
                        .city("Bors")
                        .since(now().minusYears(3))
                        .stars(2)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 9")
                        .city("Oradea")
                        .since(now().minusYears(4))
                        .stars(1)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 10")
                        .city("Iasi")
                        .since(now().minusYears(5))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 11")
                        .city("Oradea")
                        .since(now().minusYears(1))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 12")
                        .city("Oradea")
                        .since(now().minusYears(2))
                        .stars(5)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 13")
                        .city("Bors")
                        .since(now().minusYears(3))
                        .stars(2)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 14")
                        .city("Oradea")
                        .since(now().minusYears(4))
                        .stars(1)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 15")
                        .city("Iasi")
                        .since(now().minusYears(5))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 16")
                        .city("Oradea")
                        .since(now().minusYears(1))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 17")
                        .city("Oradea")
                        .since(now().minusYears(2))
                        .stars(5)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 18")
                        .city("Bors")
                        .since(now().minusYears(3))
                        .stars(2)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 19")
                        .city("Oradea")
                        .since(now().minusYears(4))
                        .stars(1)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 20")
                        .city("Iasi")
                        .since(now().minusYears(5))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 21")
                        .city("Oradea")
                        .since(now().minusYears(1))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 22")
                        .city("Oradea")
                        .since(now().minusYears(2))
                        .stars(5)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 23")
                        .city("Bors")
                        .since(now().minusYears(3))
                        .stars(2)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 24")
                        .city("Oradea")
                        .since(now().minusYears(4))
                        .stars(1)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 25")
                        .city("Iasi")
                        .since(now().minusYears(5))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 26")
                        .city("Oradea")
                        .since(now().minusYears(1))
                        .stars(4)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 27")
                        .city("Oradea")
                        .since(now().minusYears(2))
                        .stars(5)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 28")
                        .city("Bors")
                        .since(now().minusYears(3))
                        .stars(2)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 29")
                        .city("Oradea")
                        .since(now().minusYears(4))
                        .stars(1)
                        .build(),
                RestaurantEntity.builder()
                        .name("RestaurantEntity - 30")
                        .city("Iasi")
                        .since(now().minusYears(5))
                        .stars(4)
                        .build());
        restaurants.forEach(service::addRestaurant);
    }
}
