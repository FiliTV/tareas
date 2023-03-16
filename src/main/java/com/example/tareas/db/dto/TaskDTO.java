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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id) && Objects.equals(description, taskDTO.description) && Objects.equals(isValid, taskDTO.isValid) && Objects.equals(createdAt, taskDTO.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, isValid, createdAt);
    }

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Boolean isValid;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
