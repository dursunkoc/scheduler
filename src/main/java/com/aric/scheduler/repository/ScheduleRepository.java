/**
 * 
 */
package com.aric.scheduler.repository;

import org.springframework.data.repository.CrudRepository;

import com.aric.scheduler.domain.Schedule;

/**
 * @author dursunkoc
 *
 */
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

}
