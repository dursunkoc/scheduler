package com.aric.scheduler.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * @author dursunkoc
 *
 */
@Data
@Entity
public class TaskExecution {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@ManyToOne(optional = false)
	private Task task;
	
	private Date startDate;
	
	private Date finishDate;
}
