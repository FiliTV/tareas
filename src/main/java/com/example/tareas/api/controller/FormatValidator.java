package com.example.tareas.api.controller;

import com.example.tareas.api.dao.TaskDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class FormatValidator {
    public static void validate(TaskDAO task) {
        if(task.getDescription() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        };
    }
}
