package com.stepan.task_manager.todo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import java.time.*;

@Setter
@Getter
@Accessors(chain=true)
@ToString
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Todo {

	
    @Id
    @Column(columnDefinition="VARCHAR(191)")
    private String id;
    private String userId;
    private String task;
    private boolean complete = false;
    private Instant created;

    
    @PrePersist
    void init() {
    	this.created = Instant.now();
        this.id = UUID.randomUUID().toString();
    }
    
}
