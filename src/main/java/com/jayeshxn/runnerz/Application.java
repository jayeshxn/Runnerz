package com.jayeshxn.runnerz;

import com.jayeshxn.runnerz.run.Location;
import com.jayeshxn.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("Something changed!");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(
					1,
					"First Run",
					LocalDateTime.now(),
					LocalDateTime.now().plus(1, ChronoUnit.HOURS),
					5,
					Location.OUTDOOR
			);
			logger.info("Run: " + run);
		};
	}
}
