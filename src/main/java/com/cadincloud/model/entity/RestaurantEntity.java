package com.cadincloud.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RestaurantEntity {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int stars;

    private String city;

    private LocalDate since;
}
