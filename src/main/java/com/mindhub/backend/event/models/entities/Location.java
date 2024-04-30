package com.mindhub.backend.event.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String img;

    @OneToMany(mappedBy = "location")
    private List<EventLocation> eventLocations = new ArrayList<>();

    public Location( String name, String address, String img ) {
        this.name = name;
        this.address = address;
        this.img = img;
    }
}