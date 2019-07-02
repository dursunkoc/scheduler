/**
 * 
 */
package com.aric.scheduler.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aric.scheduler.domain.Task;
import com.aric.scheduler.domain.TaskExecution;
import com.aric.scheduler.repository.TaskExecutionRepository;
import com.aric.scheduler.repository.TaskRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dursunkoc
 *
 */
@RestController
@RequestMapping(path = "api/taskexecution")
@Slf4j
public class TaskExecutionController {

	@Autowired
	private TaskExecutionRepository taskExecutionRepository;

	@Autowired
	private TaskRepository taskRepository;


	@GetMapping
	@Transactional
	public List<TaskExecution> getTaskExecutions(@RequestParam(name="taskId") Long taskId) {
		Optional<Task> task = taskRepository.findById(taskId);
		Optional<List<TaskExecution>> taskExecution = task.map(taskExecutionRepository::findByTask);
		return taskExecution.orElse(Collections.emptyList());
	}

	@PostMapping
	@Transactional
	public TaskExecution createTaskExecution(@RequestBody TaskExecution taskExecution) {
		log.info("Creating TaskExecution ({})", taskExecution);
		TaskExecution saved = taskExecutionRepository.save(taskExecution);
		return saved;
	}
}
