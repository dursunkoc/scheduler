/**
 * 
 */
package com.aric.scheduler.controller;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aric.scheduler.domain.Task;
import com.aric.scheduler.repository.TaskRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dursunkoc
 *
 */
@RestController
@RequestMapping(path = "api/task")
@Slf4j
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@GetMapping
	public Task getTaskByName(@RequestParam(name = "name") String name) {
		return taskRepository.findByName(name);
	}

	@PostMapping
	@Transactional
	public Task createTask(@RequestBody Task task) {
		log.info("Creating Task ({})", task);
		
		Set<Task> predecessors = task.getPredecessors()
				.stream()
				.map(Task::getId)
				.map(taskRepository::findById)
				.map(Optional::get)
				.collect(Collectors.toSet());
		
		task.setPredecessors(predecessors);
		Task saved = taskRepository.save(task);
		return saved;
	}
}
