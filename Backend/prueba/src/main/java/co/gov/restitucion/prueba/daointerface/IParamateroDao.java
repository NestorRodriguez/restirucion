package co.gov.restitucion.prueba.daointerface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.gov.restitucion.prueba.entities.Parametro;

public interface IParamateroDao extends CrudRepository<Parametro, Long> {

	public Parametro findParametroByTipoParametro(String email);
	
	public List<Parametro> findAllParametro(long tipoParametro, boolean estado);
}
