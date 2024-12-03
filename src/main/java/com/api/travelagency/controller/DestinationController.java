package com.api.travelagency.controller;

import com.api.travelagency.model.Destination;
import com.api.travelagency.model.Reservation;
import com.api.travelagency.service.DestinationService;
import com.api.travelagency.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    private final DestinationService destinationService;
    private final ReservationService reservationService;

    // Constructor Injection for Services
    public DestinationController(DestinationService destinationService, ReservationService reservationService) {
        this.destinationService = destinationService;
        this.reservationService = reservationService;
    }

    /**
     * Endpoint to create a new travel destination.
     * Method: POST
     * URL: /api/destinations
     */
    @PostMapping
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationService.save(destination);
    }

    /**
     * Endpoint to list all travel destinations.
     * Method: GET
     * URL: /api/destinations
     */
    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.findAll();
    }

    /**
     * Endpoint to search destinations by name or location.
     * Method: GET
     * URL: /api/destinations/search
     * Query Parameter: query
     */
    @GetMapping("/search")
    public List<Destination> searchDestinations(@RequestParam String query) {
        return destinationService.search(query);
    }

    /**
     * Endpoint to get detailed information about a specific destination.
     * Method: GET
     * URL: /api/destinations/{id}
     */
    @GetMapping("/{id}")
    public Destination getDestinationDetails(@PathVariable Long id) {
        return destinationService.findById(id);
    }

    /**
     * Endpoint to rate a destination and update its average rating.
     * Method: PATCH
     * URL: /api/destinations/{id}/rate
     * Query Parameter: rating
     */
    @PatchMapping("/{id}/rate")
    public void rateDestination(@PathVariable Long id, @RequestParam int rating) {
        destinationService.rateDestination(id, rating);
    }

    /**
     * Endpoint to delete a travel destination.
     * Method: DELETE
     * URL: /api/destinations/{id}
     */
    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable Long id) {
        destinationService.delete(id);
    }

    /**
     * Endpoint to reserve a travel package for a specific destination.
     * Method: POST
     * URL: /api/destinations/{id}/reserve
     * Request Body: Reservation object (customerName, numberOfPeople)
     */
    @PostMapping("/{id}/reserve")
    public Reservation reservePackage(@PathVariable Long id, @RequestBody Reservation reservation) {
        // Find the destination to associate with the reservation
        Destination destination = destinationService.findById(id);
        reservation.setDestination(destination);

        // Save the reservation and return it
        return reservationService.save(reservation);
    }
}
