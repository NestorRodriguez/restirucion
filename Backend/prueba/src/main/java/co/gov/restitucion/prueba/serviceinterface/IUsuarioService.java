package co.gov.restitucion.prueba.serviceinterface;

import java.util.List;

import co.gov.restitucion.prueba.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();

	public Usuario create(Usuario usuario);
	
	public Usuario update(Usuario usuario, int id);
	
	public void delete(long id);
	
	public Usuario getUser(String username, String ddocumento);
	
}
