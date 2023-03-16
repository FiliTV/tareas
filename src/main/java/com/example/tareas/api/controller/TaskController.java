package com.example.tareas.api.controller;

import com.example.tareas.api.dao.TaskDAO;
import com.example.tareas.api.view.TaskView;
import com.example.tareas.service.TaskService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@AllArgsConstructor
@RestController()
@RequestMapping("/tasks")
public class TaskController {
    private static final java.util.
            logging.Logger log = java.util.logging.Logger.getLogger(TaskController.class.getName());


    TaskService taskService;
    @CrossOrigin
    @PostMapping
    public void create(@RequestBody TaskDAO task){

        FormatValidator.validate(task);


        taskService.create(task);
    }

    @CrossOrigin
    @GetMapping
    public List<TaskView> list() {
        return taskService.list();
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        taskService.delete(id);
    }
    @CrossOrigin
    @PutMapping(value = "/{id}")
    public void update(@PathVariable String id, @RequestBody TaskDAO task) {
        FormatValidator.validate(task);

        log.info(id);
        taskService.update(id,task);
    }
}
