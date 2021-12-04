package co.gov.restitucion.prueba.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOS_PARAMETROS")
public class TipoParametro implements Serializable {
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
	 * Identificador de la entidad Tipo Parametro
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

	@Override
	public String toString() {
		return "TipoParametro [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

}
