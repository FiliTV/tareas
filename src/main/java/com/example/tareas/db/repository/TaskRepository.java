package com.example.tareas.db.repository;

import com.example.tareas.db.dto.TaskDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends CrudRepository<TaskDTO, Long> {

    @Modifying
    @Query("update TaskDTO t set t.description = :description where t.id = :id")
    void updateDescription(@Param(value = "id") long id, @Param(value = "description") String description);

    @Modifying
    @Query("update TaskDTO t set t.isValid = :valid where t.id = :id")
    void updateValid(@Param(value = "id")long id,@Param(value = "valid") Boolean valid);

}
