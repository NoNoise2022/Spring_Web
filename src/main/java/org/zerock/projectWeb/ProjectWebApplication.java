package org.zerock.projectWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjectWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWebApplication.class, args);
	}

}
