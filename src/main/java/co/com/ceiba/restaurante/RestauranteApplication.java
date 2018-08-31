package co.com.ceiba.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"co.com.ceiba.restaurante.negocio.model","co.com.ceiba.restaurante.negocio.repository","co.com.ceiba.restaurante"})
@EntityScan("co.com.ceiba.restaurante.negocio.entity")
public class RestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}
}
