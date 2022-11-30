package hu.steve.transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.steve.transport.service.InitDbService;

@SpringBootApplication
public class TransportPlanApplication implements CommandLineRunner{

	@Autowired
	InitDbService initDbService;
	
	public static void main(String[] args) {
		SpringApplication.run(TransportPlanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initDbService.initDb();		
	}

}
