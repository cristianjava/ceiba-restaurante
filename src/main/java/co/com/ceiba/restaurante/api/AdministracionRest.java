package co.com.ceiba.restaurante.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.restaurante.negocio.model.Plato;
import co.com.ceiba.restaurante.negocio.service.PlatoService;

@RestController
@RequestMapping("/restaurante")
public class AdministracionRest {

	@Autowired
	PlatoService platoService;
	
	@RequestMapping(method = RequestMethod.POST ,value = "/guardarPlato")
	public void guardarPlato(@RequestBody Plato plato) {
		platoService.guardarPlato(plato);
	}
}
