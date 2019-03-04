package com.stepan.task_manager.user;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")

@Setter
@Getter
@Accessors(chain = true)
@ToString
@EqualsAndHashCode(of = { "email" })
@Entity
public class User {

	@Id
	@Column(columnDefinition = "VARCHAR(191)")
	private String id;

	private String name;
	private String email;

	private LocalDateTime created;

	@PrePersist
	void init() {
		this.id = UUID.randomUUID().toString();
		created = LocalDateTime.now();
	}

}
