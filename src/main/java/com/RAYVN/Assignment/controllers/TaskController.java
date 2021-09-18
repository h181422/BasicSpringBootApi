package com.RAYVN.Assignment.controllers;

import com.RAYVN.Assignment.models.Incident;
import com.RAYVN.Assignment.models.RayvnTask;
import com.RAYVN.Assignment.services.TaskService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class TaskController {

    private final TaskService service;

    TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/task/{incidentId}")
    RayvnTask newTask(@RequestBody RayvnTask task, @PathVariable String incidentId) {
        return service.newTask(task, incidentId);
    }

    @GetMapping("/incidenttasks/{id}")
    List<RayvnTask> tasks(@PathVariable String id) {
        return service.allForIncident(id);
    }

    @GetMapping("/incidenttasks/{id}/duedatepassed")
    List<RayvnTask> passedDuedates(@PathVariable String id) {
        return service.allForIncidentWithPassedDueDate(id);
    }

    @GetMapping("/incidenttasks/{id}/uncompleted")
    List<RayvnTask> uncompleted(@PathVariable String id) {
        return service.allForIncidentNotCompleted(id);
    }
    @GetMapping("/incidenttasks/{id}/uncompleted/duedatepassed")
    List<RayvnTask> uncompletedAndpassedDuedates(@PathVariable String id) {
        return service.allForIncidentNotCompletedWithPassedDueDate(id);
    }

    @GetMapping("/task/{id}")
    RayvnTask one(@PathVariable String id) {
        return service.one(id);
    }

    @PutMapping("/task/{id}")
    RayvnTask replaceTask(@RequestBody RayvnTask task, @PathVariable String id) {
        task.setId(id);
        return service.replaceTask(task);
    }

    @DeleteMapping("/task/{id}")
    void deleteTask(@PathVariable String id) {
        service.deleteTask(id);
    }
}