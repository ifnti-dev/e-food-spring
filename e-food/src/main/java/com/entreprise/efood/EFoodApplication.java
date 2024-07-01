package com.entreprise.efood;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// @EnableSwagger2
@EnableWebMvc
public class EFoodApplication {


	private static final Logger LOGGER = LogManager.getLogger(EFoodApplication.class);

	public static void main(String[] args) {

		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
		
		SpringApplication.run(EFoodApplication.class, args);
	}

}
