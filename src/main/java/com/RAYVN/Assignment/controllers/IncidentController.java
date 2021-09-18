package com.RAYVN.Assignment.controllers;

import com.RAYVN.Assignment.models.Incident;
import com.RAYVN.Assignment.services.IncidentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class IncidentController {

    private final IncidentService service;

    IncidentController(IncidentService service) {
        this.service = service;
    }

    @GetMapping("/incidents")
    List<Incident> all() {
        return service.all();
    }

    @PostMapping("/incident")
    Incident newIncident(@RequestBody Incident newIncident) {
        return service.newIncident(newIncident);
    }

    @GetMapping("/incident/{id}")
    Incident one(@PathVariable String id) {
        return service.one(id);
    }

    @GetMapping("/latestIncident")
    Incident latest() {
        return service.latest();
    }

    @PutMapping("/incident/{id}")
    Incident replaceIncident(@RequestBody Incident newIncident, @PathVariable String id) {
        return service.replaceIncident(newIncident, id);
    }

    @DeleteMapping("/incident/{id}")
    void deleteIncident(@PathVariable String id) {
        service.deleteIncident(id);
    }
}