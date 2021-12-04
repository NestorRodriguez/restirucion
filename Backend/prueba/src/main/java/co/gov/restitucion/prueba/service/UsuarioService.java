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
		return this.usuarioDao.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario, int id) {
		return this.usuarioDao.save(usuario);
	}

	@Override
	public void delete(int id) {
		this.usuarioDao.deleteById((long) id);
	}

	@Override
	public Usuario getUser(Usuario usuario) {
		return this.usuarioDao.findUsuarioByMail(usuario.getEmail());
	}

}
