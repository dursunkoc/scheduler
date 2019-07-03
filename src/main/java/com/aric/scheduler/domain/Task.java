package com.aric.scheduler.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author dursunkoc
 *
 */
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@Entity
public class Task extends Auditable<String> {

	private String name;
	private String description;
	private String planName;

	@ManyToMany
	@JoinTable(name = "TaskRel", joinColumns = { @JoinColumn(name = "predecessorId") }, inverseJoinColumns = {
			@JoinColumn(name = "successorId") })
	private Set<Task> predecessors = new HashSet<Task>();

}
