package br.com.nataliadiotto.todolist.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID") //automatically generate Id
    private UUID id;

    private String description;

    @Column(length = 50) //limiting title length
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private UUID userId;

    public void setTitle(String title) throws Exception{
        if (title.length() > 50) {
            throw new Exception ("The title should contain a maximum of 50 characters");
        }
        this.title = title;
    }

}


