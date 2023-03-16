package com.example.tareas.service;


import com.example.tareas.api.controller.TaskController;
import com.example.tareas.api.dao.TaskDAO;
import com.example.tareas.api.view.TaskView;
import com.example.tareas.db.dto.TaskDTO;
import com.example.tareas.db.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskService {
    private static final java.util.
            logging.Logger log = java.util.logging.Logger.getLogger(TaskController.class.getName());

    TaskRepository taskRepository;

    public void create(TaskDAO task) {
        taskRepository.save(TaskDTO
                .builder()
                .description(task.getDescription())
                .isValid(true)
                .build());
    }

    public List<TaskView> list() {
        List<TaskDTO> all = (List<TaskDTO>) taskRepository.findAll();
        return all.stream()
                .map(t -> TaskView.builder()
                        .id(t.getId())
                        .description(t.getDescription())
                        .isValid(t.getIsValid())
                        .createdAt(t.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    public void delete(String id) {
        taskRepository.deleteById(Long.valueOf(id));
    }

    @Transactional
    public void update(String id, TaskDAO task) {
        log.info(task.toString());

        taskRepository.updateDescription(Long.parseLong(id), task.getDescription());
        taskRepository.updateValid(Long.parseLong(id), task.getValid());

    }
}
