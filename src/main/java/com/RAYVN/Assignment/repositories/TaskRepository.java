package com.RAYVN.Assignment.repositories;

import com.RAYVN.Assignment.models.RayvnTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<RayvnTask, String> {
    List<RayvnTask> findAllByIncidentId(String id);
    List<RayvnTask> findAllByIncidentIdAndDueDateLessThan(String id, Long dueDate);
    List<RayvnTask> findAllByIncidentIdAndCompletedAtIsNull(String id);
    List<RayvnTask> findAllByIncidentIdAndDueDateLessThanAndCompletedAtIsNull(String id, Long dueDate);
}
