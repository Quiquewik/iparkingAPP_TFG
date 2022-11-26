package servidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@AutoConfiguration
public class IparkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(IparkingApplication.class, args);
	}

}
