package com.mindhub.backend.event;

import com.mindhub.backend.event.models.entities.*;
import com.mindhub.backend.event.models.enums.Genders;
import com.mindhub.backend.event.models.enums.Roles;
import com.mindhub.backend.event.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class EventApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}

	@Bean
	public CommandLineRunner lineRunner( CustomerRepository customerRepository, EventRepository eventRepository,
										 CommentRepository commentRepository, LocationRepository locationRepository,
										 EventLocationRepository eventLocationRepository, CustomerEventRepository customerEventRepository ){
		return (args) -> {
			// Crear un objeto de prueba para Customer
			Customer john = new Customer("John", "Doe", "john@example.com", true, "password", (short) 30, Genders.MALE, Roles.USER);
			customerRepository.save(john);

		// Crear un objeto de prueba para Event
			Event event = new Event("Descripción del evento", "imagen.jpg", (short) 18, "Nombre del evento");
			event.setCustomer( john );
			eventRepository.save(event);

			// Crear un objeto de prueba para Comment y establecer las relaciones
			Comment comment = new Comment("¡Qué gran evento!");
			comment.setCustomerComment(john); // Establecer la relación con John
			comment.setEventComment(event); // Establecer la relación con el evento
			commentRepository.save(comment);

		// Crear un objeto de prueba para Location
			Location location = new Location("Nombre de la ubicación", "Dirección de la ubicación", "imagen.jpg");
			locationRepository.save(location);

		// Crear un objeto de prueba para EventLocation
			EventLocation eventLocation = new EventLocation(new Date(), 10);
			eventLocation.setEvent(event);
			eventLocation.setLocation(location);
			eventLocationRepository.save(eventLocation);

		// Crear un objeto de prueba para CustomerEvent y establecer las relaciones
			CustomerEvent customerEvent = new CustomerEvent();
			customerEvent.setCustomer(john);
			customerEvent.setEventLocation(eventLocation);
			customerEventRepository.save(customerEvent);
		};
	}

}
