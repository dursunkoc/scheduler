/**
 * 
 */
package com.aric.scheduler.domain;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author dursunkoc
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PROTECTED)
public abstract class Auditable<U> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@CreatedBy
	private U createdBy;

	@CreatedDate
	private Date createdDate;

	@LastModifiedBy
	private U lastModifiedBy;

	@LastModifiedDate
	private Date lastModifiedDate;
}