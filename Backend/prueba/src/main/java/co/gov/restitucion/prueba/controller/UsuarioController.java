package co.gov.restitucion.prueba.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import co.gov.restitucion.prueba.entities.Usuario;
import co.gov.restitucion.prueba.serviceinterface.IUsuarioService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@PostMapping("/usuario/find")
	public Usuario findByUserOrDocument(@RequestBody Usuario usuario){
		return usuarioService.getUser(usuario.getUsername(), usuario.getDocumento()); 
	}
	
	@PostMapping("/usuario")
	public Usuario create(@RequestBody Usuario usuario){
		return usuarioService.create(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario update(@PathVariable int id, @RequestBody Usuario usuario) {
		return usuarioService.update(usuario, id);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void delete(@PathVariable int id) {
		this.usuarioService.delete((int) id);
	}
}
