package co.gov.restitucion.prueba.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(value = {
		@NamedQuery(name = "Parametro.findParametroByTipoParametro", query = "SELECT p FROM Parametro p WHERE p.tipoParametro.id = :tipoParametro and p.estado = :estado"),
		@NamedQuery(name = "Parametro.findAllParametro", query = "SELECT p FROM Parametro p"),
	 })

@Entity
@Table(name = "PARAMETROS")
public class Parametro implements Serializable {
	// --------------------------------
	// Constantes de la clase.
	// --------------------------------

	/**
	 * Constante de serializaci�n.
	*/
	private static final long serialVersionUID = 1265660971450473499L;

	// --------------------------------
	// Atributos de la clase.
	// --------------------------------
	
	/**
	 * Identificador de la entidad Usuario
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARAMETRO_PK", nullable = false)
	private int id;
	
	/**
	 * Descripción del parametro
	 */
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	/**
	 * Estado del Parametro
	 */
	@Column(name = "ESTADO", nullable = false)
	private boolean estado;

	/**
	 * Tipo de parametro del parametro
	 */
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PARAMETRO_FK", nullable = false)
	private TipoParametro tipoParametro;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * @return the tipoParametro
	 */
	public TipoParametro getTipoParametro() {
		return tipoParametro;
	}

	/**
	 * @param tipoParametro the tipoParametro to set
	 */
	public void setTipoParametro(TipoParametro tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	@Override
	public String toString() {
		return "Parametro [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", tipoParametro="
				+ tipoParametro + "]";
	}
	
	
	
	
}
