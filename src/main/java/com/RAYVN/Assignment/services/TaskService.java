package com.RAYVN.Assignment.services;


import com.RAYVN.Assignment.models.RayvnTask;
import com.RAYVN.Assignment.repositories.IncidentRepository;
import com.RAYVN.Assignment.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskService {

    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private TaskRepository repository;


    public RayvnTask newTask(RayvnTask task, String incidentId) {
        var existingIncident = incidentRepository.existsById(incidentId);
        if(!existingIncident) throw new RuntimeException("Incident doesnt exist");
        var incident = incidentRepository.findById(incidentId);
        var existingTask = repository.existsById(incidentId);
        if(existingTask) throw new RuntimeException("Task already exists");
        task.setCreatedTime(System.currentTimeMillis());
        task.setIncident(incident.get());
        return repository.save(task);
    }

    public RayvnTask replaceTask(RayvnTask task) {
        return repository.findById(task.getId())
                .map(x -> {
                    x.setName(task.getName());
                    x.setCompletedAt(task.getCompletedAt());
                    x.setDueDate(task.getDueDate());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    task.setCreatedTime(System.currentTimeMillis());
                    return repository.save(task);
                });
    }

    public RayvnTask one(String id) {
        return repository.findById(id).orElseGet(() -> null);
    }

    public void deleteTask(String id) {
        repository.deleteById(id);
    }

    public List<RayvnTask> allForIncident(String incidentId) {
        return repository.findAllByIncidentId(incidentId);
    }

    public List<RayvnTask> allForIncidentWithPassedDueDate(String incidentId) {
        return repository.findAllByIncidentIdAndDueDateLessThan(incidentId, System.currentTimeMillis());
    }

    public List<RayvnTask> allForIncidentNotCompletedWithPassedDueDate(String incidentId) {
        return repository.findAllByIncidentIdAndDueDateLessThanAndCompletedAtIsNull(incidentId, System.currentTimeMillis());
    }

    public List<RayvnTask> allForIncidentNotCompleted(String incidentId) {
        return repository.findAllByIncidentIdAndCompletedAtIsNull(incidentId);
    }
}
