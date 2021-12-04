package co.gov.restitucion.prueba.daointerface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.gov.restitucion.prueba.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	public List<Usuario> findAllUsuario();
	
	public Usuario findUsuarioByDocumento(String documento);
	
	public Usuario findUsuarioByUserName(String username);

}
