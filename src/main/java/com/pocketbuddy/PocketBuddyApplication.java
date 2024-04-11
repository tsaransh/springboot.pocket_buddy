package com.pocketbuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PocketBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketBuddyApplication.class, args);
	}

}
