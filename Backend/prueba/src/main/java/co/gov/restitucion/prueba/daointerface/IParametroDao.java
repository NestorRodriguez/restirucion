package co.gov.restitucion.prueba.daointerface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.gov.restitucion.prueba.entities.Parametro;
import co.gov.restitucion.prueba.entities.TipoParametro;

public interface IParametroDao extends CrudRepository<Parametro, Long> {

	public Parametro findParametroByTipoParametro(TipoParametro tipoParametro, boolean estado);
	
	public List<Parametro> findAllParametro();
}
