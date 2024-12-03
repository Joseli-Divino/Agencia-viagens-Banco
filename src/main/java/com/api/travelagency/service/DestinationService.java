package com.api.travelagency.service;

import com.api.travelagency.model.Destination;
import com.api.travelagency.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    private final DestinationRepository repository;

    public DestinationService(DestinationRepository repository) {
        this.repository = repository;
    }

    public Destination save(Destination destination) {
        return repository.save(destination);
    }

    public List<Destination> findAll() {
        return repository.findAll();
    }

    public List<Destination> search(String query) {
        return repository.findByNameContainingOrLocationContaining(query, query);
    }

    public Destination findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Destination not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void rateDestination(Long id, int rating) {
        Destination destination = findById(id);
        int newRatingCount = destination.getRatingCount() + 1;
        double newAverage = ((destination.getAverageRating() * destination.getRatingCount()) + rating) / newRatingCount;
        destination.setRatingCount(newRatingCount);
        destination.setAverageRating(newAverage);
        save(destination);
    }
}
