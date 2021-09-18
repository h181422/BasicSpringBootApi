package com.RAYVN.Assignment.services;


import com.RAYVN.Assignment.models.Incident;
import com.RAYVN.Assignment.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository repository;

    public List<Incident> all() {
        return repository.findAll();
    }

    public Incident newIncident(Incident newEmployee) {
        var existingIncident = repository.existsById(newEmployee.getId());
        if(existingIncident) throw new RuntimeException("Already exists");
        newEmployee.setCreatedTime(System.currentTimeMillis());
        return repository.save(newEmployee);
    }

    public Incident one(String id) {
        return repository.findById(id).orElseGet(() -> null);
    }

    public Incident latest() {
        return repository.findFirstByOrderByCreatedTimeDesc();
    }

    public Incident replaceIncident(Incident newIncident, String id) {
        return repository.findById(id)
                .map(x -> {
                    x.setName(newIncident.getName());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newIncident.setId(id);
                    newIncident.setCreatedTime(System.currentTimeMillis());
                    return repository.save(newIncident);
                });
    }

    public void deleteIncident(String id) {
        repository.deleteById(id);
    }
}
