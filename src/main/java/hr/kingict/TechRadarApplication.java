package hr.kingict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TechRadarApplication extends SpringBootServletInitializer{

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
		return springApplicationBuilder.sources(TechRadarApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(TechRadarApplication.class, args);
	}


}
