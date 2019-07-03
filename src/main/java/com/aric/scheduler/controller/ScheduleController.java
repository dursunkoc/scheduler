/**
 * 
 */
package com.aric.scheduler.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aric.scheduler.domain.Schedule;
import com.aric.scheduler.exceptions.AlreadyExistingSchedule;
import com.aric.scheduler.repository.ScheduleRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dursunkoc
 *
 */
@RestController
@RequestMapping(path = "api/schedule")
@Slf4j
public class ScheduleController {
	@Autowired
	private ScheduleRepository scheduleRepository;

	@GetMapping
	public Iterable<Schedule> getAll() {
		return scheduleRepository.findAll();
	}

	@GetMapping("/{planName}")
	public Iterable<Schedule> getByPlanName(@PathVariable("planName") String planName) {
		return scheduleRepository.findByPlanName(planName);
	}

	@GetMapping("/{planName}/{scheduleDate}")
	public Schedule getByPlanNameAndDate(@PathVariable("planName") String planName,
			@PathVariable("scheduleDate") @DateTimeFormat(pattern = "yyyy.MM.dd") Date scheduleDate) {
		return scheduleRepository.findByPlanNameAndScheduleDate(planName, scheduleDate);
	}

	@PostMapping("/{planName}")
	public Schedule createSchedule(@PathVariable("planName") String planName,
			@RequestParam("scheduleDate") @DateTimeFormat(pattern = "yyyy.MM.dd") Date scheduleDate)
			throws AlreadyExistingSchedule {
		log.debug("Creating a schedule for plan {}, at {}", planName, scheduleDate);

		Schedule existingSchedule = scheduleRepository.findByPlanNameAndScheduleDate(planName, scheduleDate);
		if (existingSchedule != null) {
			throw new AlreadyExistingSchedule(
					"Such schedule(planName:" + planName + ", scheduleDate:" + scheduleDate + ") already exists");
		}

		Schedule schedule = Schedule.builder().scheduleDate(scheduleDate).planName(planName).build();
		return scheduleRepository.save(schedule);
	}
}
