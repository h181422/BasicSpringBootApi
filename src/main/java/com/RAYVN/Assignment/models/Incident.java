package com.RAYVN.Assignment.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Incident {
    @Id
    private String id;
    private String name;
    private long createdTime;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<RayvnTask> tasks;

    public Incident() {
        super();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public void setTasks(List<RayvnTask> tasks) {
        this.tasks = tasks;
    }

    public List<RayvnTask> getTasks() {
        return tasks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCreatedTime() {
        return createdTime;
    }
}
