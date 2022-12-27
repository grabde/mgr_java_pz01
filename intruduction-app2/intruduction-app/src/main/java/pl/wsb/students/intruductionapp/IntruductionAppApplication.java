package pl.wsb.students.intruductionapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages={"pl.wsb.students.model", "pl.wsb.students.api.model"})
//@ComponentScan(basePackages = {"pl.wsb.students.controller", "pl.wsb.students.service", "pl.wsb.students.api.controller", "pl.wsb.students.api.mapper"})
//@EnableJpaRepositories(basePackages = {"pl.wsb.students.repository"})
public class IntruductionAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntruductionAppApplication.class, args);
	}

}
