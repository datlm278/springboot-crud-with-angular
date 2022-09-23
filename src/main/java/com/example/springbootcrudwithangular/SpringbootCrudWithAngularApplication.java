package com.example.springbootcrudwithangular;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "${swagger.config.title}",
		description = "${swagger.config.title}",
		version = "${swagger.config.version}"),
		servers = {@Server(url = "${swagger.config.url}")})
public class SpringbootCrudWithAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudWithAngularApplication.class, args);
	}

}
