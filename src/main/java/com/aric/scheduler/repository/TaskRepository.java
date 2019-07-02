/**
 * 
 */
package com.aric.scheduler.repository;

import org.springframework.data.repository.CrudRepository;

import com.aric.scheduler.domain.Task;

/**
 * @author dursunkoc
 *
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
	public Task findByName(String name);
}
