package com.mindhub.backend.event.models.entities;

import com.mindhub.backend.event.models.enums.Genders;
import com.mindhub.backend.event.models.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    private boolean activated;
    @NotNull
    @Size(min = 8, max = 50)
    private String password;
    private short age;
    @NotNull
    private Genders genders;
    @NotNull
    private Roles roles;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "customer_event",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "event_id"),
//            uniqueConstraints = {@UniqueConstraint( columnNames = {"customer_id", "event_id"})})
//    private List<EventLocation> eventLocations;

    @OneToMany(mappedBy = "customerComment",fetch = FetchType.EAGER)
    private List<Comment> comments;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<CustomerEvent> customerEvents = new ArrayList<>();

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    public Customer( String name, String lastName, String email, boolean activated, String password, short age, Genders genders, Roles roles ) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.password = password;
        this.age = age;
        this.genders = genders;
        this.roles = roles;
    }
}
