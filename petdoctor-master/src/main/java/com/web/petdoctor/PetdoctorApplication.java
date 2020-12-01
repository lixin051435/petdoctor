package com.web.petdoctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PetdoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetdoctorApplication.class, args);
	}

}
