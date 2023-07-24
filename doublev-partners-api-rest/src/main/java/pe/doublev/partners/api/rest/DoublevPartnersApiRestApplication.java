package pe.doublev.partners.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"pe.back.core.repositories.jpa",
		"pe.back.core",
		"pe.doublev.partners.api.rest"})
@EntityScan(basePackages = "pe.back.core.repositories.jpa.domain.models")
@EnableJpaRepositories(basePackages = {"pe.back.core.repositories.jpa.application.repository"})
public class DoublevPartnersApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoublevPartnersApiRestApplication.class, args);
	}

}
