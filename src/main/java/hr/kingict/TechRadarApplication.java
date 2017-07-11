package hr.kingict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * A main class which runs Spring boot application
 */
@SpringBootApplication
public class TechRadarApplication extends SpringBootServletInitializer{

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
		return springApplicationBuilder.sources(TechRadarApplication.class);
	}

	/**
	 * Main method which runs application
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(TechRadarApplication.class, args);
	}


}
