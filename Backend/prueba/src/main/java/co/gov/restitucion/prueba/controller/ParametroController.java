package co.gov.restitucion.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.gov.restitucion.prueba.entities.Parametro;
import co.gov.restitucion.prueba.serviceinterface.IParametroService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST})
public class ParametroController {
	
	@Autowired
	private IParametroService parametroService;
	
	@GetMapping("/parametro")
	public List<Parametro> index(){
		return parametroService.findAll();
	}
	
	@GetMapping("/parametro/tipo/{id}")
	public List<Parametro> parametroByTipoParametro(@PathVariable int id){
		return (List<Parametro>) parametroService.getUser(id, true);
	}
	
	@PostMapping("/parametro")
	public Parametro create(@RequestBody Parametro parametro){
		return parametroService.create(parametro);
	}
	
	@PutMapping("/parametro/{id}")
	public Parametro update(@PathVariable int id, @RequestBody Parametro parametro) {
		return parametroService.update(parametro, id);
	}
	
	@DeleteMapping("/parametro/{id}")
	public void delete(@PathVariable int id) {
		this.parametroService.delete(id);
	}
	
}
