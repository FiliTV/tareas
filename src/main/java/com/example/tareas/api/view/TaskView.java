package com.example.tareas.api.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskView {
    private Long id;
    private String description;
    private Boolean isValid;
    private LocalDateTime createdAt;
}
