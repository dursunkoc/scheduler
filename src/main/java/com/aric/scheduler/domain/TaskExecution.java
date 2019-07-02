package com.aric.scheduler.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class TaskExecution extends Auditable<String> {
	@ManyToOne(optional = false)
	private Task task;

	@ManyToOne(optional = false)
	private Schedule schedule;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date finishDate;
}
