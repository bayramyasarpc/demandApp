package yte.parttime.demandApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import yte.parttime.demandApp.configuration.DatabasePopulator;


import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan
public class DemandAppApplication {

	private final DatabasePopulator databasePopulator;

	public DemandAppApplication(DatabasePopulator databasePopulator) {
		this.databasePopulator = databasePopulator;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemandAppApplication.class, args);
	}

	@PostConstruct
	public void populateDatabase(){
		databasePopulator.populateDatabase();
	}



}
