package co.gov.restitucion.prueba.serviceinterface;

import java.util.List;

import co.gov.restitucion.prueba.entities.Parametro;

public interface IParametroService {
	
	public List<Parametro> findAll();

	public Parametro create(Parametro Parametro);
	
	public Parametro update(Parametro Parametro, int id);
	
	public void delete(int id);
	
	public List<Parametro> getUser(int idTipoParametro, boolean estado);

}
