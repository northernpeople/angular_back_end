package com.stepan.angular_back_end.todo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

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
public class Todo {

	
    @Id
    @Column(columnDefinition="VARCHAR(191)")
    private String id;
    
    private Instant created;
    
    private String task;
    
    @PrePersist
    void init() {
    	this.created = Instant.now();
        this.id = UUID.randomUUID().toString();
    }
    
}
