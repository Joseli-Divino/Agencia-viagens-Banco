package com.api.travelagency.service;

import com.api.travelagency.model.Reservation;
import com.api.travelagency.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    // Constructor Injection
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    // Save a new reservation
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }
}
