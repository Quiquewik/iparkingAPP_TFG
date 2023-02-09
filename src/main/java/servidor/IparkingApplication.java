package servidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class IparkingApplication {

	public static void lanzarServidor(String[] args) {
		SpringApplication.run(IparkingApplication.class, args);
	}
}
