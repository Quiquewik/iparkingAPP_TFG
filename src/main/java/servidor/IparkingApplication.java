package servidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import servidor.view.FrmStart;

import java.io.IOException;

@SpringBootApplication
@AutoConfiguration
public class IparkingApplication {

	public static void lanzarServidor(String[] args) {
		SpringApplication.run(IparkingApplication.class, args);
	}

	public static void main(String[] args) throws IOException {
		new FrmStart(args);
	}
}
