package com.RAYVN.Assignment.repositories;

import com.RAYVN.Assignment.models.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, String> {
    Incident findFirstByOrderByCreatedTimeDesc();
}
