package com.stepan.task_manager.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")

@Setter
@Getter
@Accessors(chain=true)
@ToString
@EqualsAndHashCode(of={"username"})
@Entity
public class User{

	@Id
	@Column(columnDefinition="VARCHAR(191)")
	private String id;

	private String username;
		
	private LocalDateTime createdDate;
	
	@PrePersist
	void init() {
		this.id = UUID.randomUUID().toString();
		createdDate = LocalDateTime.now();
	}
	

}
