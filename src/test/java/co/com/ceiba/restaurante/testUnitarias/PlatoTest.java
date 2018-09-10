package co.com.ceiba.restaurante.testUnitarias;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.restaurante.RestauranteApplication;
import co.com.ceiba.restaurante.negocio.model.Plato;
import co.com.ceiba.restaurante.negocio.service.PlatoService;
import co.com.ceiba.restaurante.testDataBuilder.PlatoTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={RestauranteApplication.class})
@DataJpaTest
public class PlatoTest {

	@Autowired
	PlatoService platoService;
	
	@Test
	public void guardarPlato() {

		// arrange
		PlatoTestDataBuilder platoTestDataBuilder = new PlatoTestDataBuilder();

		// act
		Plato platoTest= platoTestDataBuilder.build();
		platoService.guardarPlato(platoTest);

		// assert
		assertNotNull(platoService.findByNombre(platoTest));
	}
}
