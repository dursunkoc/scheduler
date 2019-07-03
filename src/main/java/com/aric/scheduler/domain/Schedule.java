/**
 * 
 */
package com.aric.scheduler.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dursunkoc
 *
 */
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Schedule  extends Auditable<String>{

	private String planName;
	
	@Temporal(TemporalType.DATE)
	private Date scheduleDate;
}
