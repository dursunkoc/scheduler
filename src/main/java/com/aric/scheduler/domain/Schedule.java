/**
 * 
 */
package com.aric.scheduler.domain;

import java.util.Date;

import javax.persistence.Entity;
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
public class Schedule  extends Auditable<String>{

	@Temporal(TemporalType.DATE)
	private Date scheduleDate;
}
