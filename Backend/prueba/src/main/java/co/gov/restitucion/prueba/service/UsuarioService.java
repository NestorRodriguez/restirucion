package co.gov.restitucion.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.gov.restitucion.prueba.daointerface.IUsuarioDao;
import co.gov.restitucion.prueba.entities.Usuario;
import co.gov.restitucion.prueba.serviceinterface.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> findAll() {
		return this.usuarioDao.findAllUsuario();
	}

	@Override
	public Usuario create(Usuario usuario) {
		Usuario user = this.usuarioDao.findUsuarioByDocumento(usuario.getDocumento());
		if(user == null) {
			user = this.usuarioDao.findUsuarioByUserName(usuario.getUsername());
			if(user == null)
				return this.usuarioDao.save(usuario);
			else
				return new Usuario();
		}
		else
			return new Usuario();
	}

	@Override
	public Usuario update(Usuario usuario, int id) {
		return this.usuarioDao.save(usuario);
	}

	@Override
	public void delete(long id) {
		this.usuarioDao.deleteById(id);
	}

	@Override
	public Usuario getUser(String username, String documento) {
		if((username == null && documento == null) || (username == "" && documento == "")) {
			return new Usuario();
		}
		else if(documento != null) {
			Usuario userDocumento = this.usuarioDao.findUsuarioByDocumento(documento);
			if(userDocumento == null)
				return new Usuario();
			else 
				return userDocumento;
		}
		else if(username != null) {
			System.out.println("Busqueda de usuarios");
			Usuario userName = this.usuarioDao.findUsuarioByUserName(username);
			if(userName == null)
				return new Usuario();
			else
				return userName; 
		}
		else {
			Usuario user = this.usuarioDao.findUsuarioByDocumento(documento);
			if(user == null)
				return new Usuario();
			else
				return user; 
		}
	}

}
