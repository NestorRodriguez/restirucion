package co.gov.restitucion.prueba.daointerface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.gov.restitucion.prueba.entities.Parametro;

public interface IParametroDao extends CrudRepository<Parametro, Long> {

	public List<Parametro> findParametroByTipoParametro(int tipoParametro, boolean estado);
	
	public List<Parametro> findAllParametro();
}
