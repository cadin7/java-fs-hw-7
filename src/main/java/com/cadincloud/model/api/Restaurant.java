package com.cadincloud.model.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class Restaurant {
    private long id;

    private String name;

    private int stars;

    private String city;

    private LocalDate since;
}
