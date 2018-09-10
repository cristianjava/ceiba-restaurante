package co.com.ceiba.restaurante.testUnitarias;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.restaurante.RestauranteApplication;
import co.com.ceiba.restaurante.negocio.model.Plato;
import co.com.ceiba.restaurante.negocio.model.TipoPlato;
import co.com.ceiba.restaurante.negocio.service.MeseroService;
import co.com.ceiba.restaurante.negocio.service.PedidoService;
import co.com.ceiba.restaurante.negocio.service.PlatoService;
import co.com.ceiba.restaurante.testDataBuilder.PlatoTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={RestauranteApplication.class})
@DataJpaTest
public class MeseroTest {

	@Autowired
	MeseroService maestroService;

	@Autowired
	PlatoService platoService;
	
	@Autowired
	PedidoService pedidoService;
	
	// Atributos de las pruebas
	private static final long ID = 1;
	private static final String NOMBRE = "Bandeja sencilla";
	private static final String DESCRIPCION = "sopa, arroz, ensalada, huevo y jugo";
	private static final double VALOR = 10000;
	private static final TipoPlato TIPO_PLATO = new TipoPlato(2, null, null);

	private static final long ID_UNO = 2;
	private static final String NOMBRE_UNO = "jugo naturale mora";
	private static final String DESCRIPCION_UNO = "mora";
	private static final double VALOR_UNO = 3000;
	private static final TipoPlato TIPO_PLATO_UNO = new TipoPlato(5, null, null);

	private static final long ID_DOS = 3;
	private static final String NOMBRE_DOS = "Cocacola";
	private static final String DESCRIPCION_DOS = "350";
	private static final double VALOR_DOS = 2000;
	private static final TipoPlato TIPO_PLATO_DOS = new TipoPlato(6, null, null);
	
	@Test
	public void generarPedido() {

		// arrange
		List<Plato> platosTest = new ArrayList<>();
		
		PlatoTestDataBuilder platoTestDataBuilder = new PlatoTestDataBuilder().conId(ID).conNombre(NOMBRE).conDescripcion(DESCRIPCION).conValor(VALOR).conTipoPlato(TIPO_PLATO);

		PlatoTestDataBuilder platoUnoTestDataBuilder = new PlatoTestDataBuilder().conId(ID_UNO).conNombre(NOMBRE_UNO).conDescripcion(DESCRIPCION_UNO).conValor(VALOR_UNO).conTipoPlato(TIPO_PLATO_UNO);

		PlatoTestDataBuilder platoDosTestDataBuilder = new PlatoTestDataBuilder().conId(ID_DOS).conNombre(NOMBRE_DOS).conDescripcion(DESCRIPCION_DOS).conValor(VALOR_DOS).conTipoPlato(TIPO_PLATO_DOS);
		
		Plato platoTest= platoTestDataBuilder.build();
		Plato platoUnoTest= platoUnoTestDataBuilder.build();
		Plato platoDosTest= platoDosTestDataBuilder.build();
		platosTest.add(platoTest);
		platosTest.add(platoUnoTest);
		platosTest.add(platoDosTest);
		
		// act
		platoService.guardarPlato(platoTest);
		platoService.guardarPlato(platoUnoTest);
		platoService.guardarPlato(platoDosTest);
		
		maestroService.generarPedido(platosTest);

		// assert
		assertNotNull(pedidoService.findAll());
	}
}
