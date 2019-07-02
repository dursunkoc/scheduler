/**
 * 
 */
package com.aric.scheduler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aric.scheduler.domain.Task;
import com.aric.scheduler.domain.TaskExecution;

/**
 * @author dursunkoc
 *
 */
public interface TaskExecutionRepository extends CrudRepository<TaskExecution, Long> {
	public List<TaskExecution> findByTask(Task task);
}
