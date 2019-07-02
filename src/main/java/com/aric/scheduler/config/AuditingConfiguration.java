package com.aric.scheduler.config;

import java.util.Optional;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author dursunkoc
 *
 */
@EnableAsync
@SpringBootApplication
@EnableJpaAuditing
public class AuditingConfiguration {
	@Bean
	public AuditorAware<String> auditorProvider() {

		/*
		 * if you are using spring security, you can get the currently logged username
		 * with following code segment.
		 * SecurityContextHolder.getContext().getAuthentication().getName()
		 */
		return () -> Optional.ofNullable("SYSTEM");
	}
}