package co.gov.restitucion.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.gov.restitucion.prueba.daointerface.IParametroDao;
import co.gov.restitucion.prueba.entities.Parametro;
import co.gov.restitucion.prueba.serviceinterface.IParametroService;

@Service
public class ParametroService implements IParametroService{

	@Autowired
	private IParametroDao parametroDao;
	
	@Override
	public List<Parametro> findAll() {
		return this.parametroDao.findAllParametro();
	}

	@Override
	public Parametro create(Parametro Parametro) {
		return this.parametroDao.save(Parametro);
	}

	@Override
	public Parametro update(Parametro Parametro, int id) {
		return this.parametroDao.save(Parametro);
	}

	@Override
	public void delete(int id) {
		this.parametroDao.deleteById((long) id);
	}

	@Override
	public List<Parametro> getUser(int idTipoParametro, boolean estado) {
		return this.parametroDao.findParametroByTipoParametro(idTipoParametro, estado);
	}

}
