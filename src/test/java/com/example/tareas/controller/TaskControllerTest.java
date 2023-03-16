package com.example.tareas.controller;

import com.example.tareas.api.controller.TaskController;
import com.example.tareas.api.dao.TaskDAO;
import com.example.tareas.api.view.TaskView;
import com.example.tareas.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class TaskControllerTest {
    @Test
    void testCreate() {
        TaskService taskService = mock(TaskService.class);
        TaskController controller = new TaskController(taskService);

        TaskDAO task = new TaskDAO();
        controller.create(task);

        then(taskService).should().create(task);
    }

    @Test
    void testList() {
        TaskService taskService = mock(TaskService.class);
        TaskController controller = new TaskController(taskService);

        List<TaskView> expectedTasks = List.of(new TaskView());
        given(taskService.list()).willReturn(expectedTasks);
        List<TaskView> tasks = controller.list();

        assertThat(tasks)
                .isEqualTo(expectedTasks);

    }

    @Test
    void testDelete() {
        TaskService taskService = mock(TaskService.class);
        TaskController controller = new TaskController(taskService);

        String id = "234234";

        controller.delete(id);

        then(taskService).should().delete(id);

    }

    @CrossOrigin
    @Test
    void testUpdate() {
        TaskService taskService = mock(TaskService.class);
        TaskController controller = new TaskController(taskService);

        TaskDAO task = new TaskDAO();
        controller.update("test",task);

        then(taskService).should().update("test",task);
    }
}