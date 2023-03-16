package com.example.tareas.api.dao;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaskDAO {
    private String description;
    private Boolean valid;
}
