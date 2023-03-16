package com.example.tareas.service;

import com.example.tareas.api.dao.TaskDAO;
import com.example.tareas.api.view.TaskView;
import com.example.tareas.db.dto.TaskDTO;
import com.example.tareas.db.repository.TaskRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class TaskServiceTest {

    @Test
    void testCreate() {
        TaskRepository taskRepository = mock(TaskRepository.class);
        TaskService taskService = new TaskService(taskRepository);


        TaskDAO task = TaskDAO
                .builder()
                .description("test")
                .build();
        taskService.create(task);

        TaskDTO taskDTO = TaskDTO
                .builder()
                .description("test")
                .isValid(true)
//                .createdAt(Instant.now())
                .build();

        then(taskRepository).should().save(taskDTO);

    }

    @Test
    void testList() {
        TaskRepository taskRepository = mock(TaskRepository.class);
        TaskService taskService = new TaskService(taskRepository);

        List<TaskDTO> expectedTasks = Collections.singletonList(
                TaskDTO.
                        builder()
                        .description("test")
                        .build())
                ;
        given(taskRepository.findAll()).willReturn(expectedTasks);

        List<TaskView> actual = taskService.list();


        List<TaskView> tasks = Collections.singletonList(TaskView
                .builder()
                        .description("test")
                .build());
        assertThat(tasks)
                .isEqualTo(actual);
    }

    @Test
    void testUpdate() {
        TaskRepository taskRepository = mock(TaskRepository.class);
        TaskService taskService = new TaskService(taskRepository);

        Optional<TaskDTO> result = Optional.of(TaskDTO.builder()
                        .description("test2")
                .build());
        given(taskRepository.findById(Long.valueOf(1))).willReturn(result);

        TaskDAO task = TaskDAO.builder().description("test").build();
        taskService.update("1", task);


        then(taskRepository).should().save(TaskDTO.builder()
                .description("test")
                .build());

    }

    @Test
    void testDelete() {
        TaskRepository taskRepository = mock(TaskRepository.class);
        TaskService taskService = new TaskService(taskRepository);

        taskService.delete("1");
        then(taskRepository).should().deleteById(Long.valueOf(1));
    }
}