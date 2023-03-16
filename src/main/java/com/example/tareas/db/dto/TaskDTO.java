package com.example.tareas.db.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Boolean isValid;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
