package com.mindhub.backend.event.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 1000)
    private String description;
    @NotNull
    private String img;
    @Min( 3 )
    @Max( 100 )
    private short ageRequired;
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "eventComment",fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventLocation> eventLocations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Event( String description, String img, short ageRequired, String name ) {
        this.description = description;
        this.img = img;
        this.ageRequired = ageRequired;
        this.name = name;
    }
}
