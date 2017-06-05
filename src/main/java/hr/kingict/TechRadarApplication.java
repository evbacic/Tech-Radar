package hr.kingict;

import hr.kingict.model.Technology;
import hr.kingict.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class TechRadarApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechRadarApplication.class, args);
	}

}
