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
		@NamedQuery(name = "Usuario.findUsuarioByMail", query = "SELECT c FROM Usuario c WHERE c.email = :email"),
		@NamedQuery(name = "Usuario.findAllUsuario", query = "SELECT c FROM Usuario c"),
		@NamedQuery(name = "Usuario.findUsuarioByUserName", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
	 })

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

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
	@Column(name = "ID_USUARIO_PK", nullable = false)
	private int id;

	/**
	 * Nombre del usuario
	 */
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	/**
	 * Nombre del usuario
	 */
	@Column(name = "SEGUNDO_NOMBRE")
	private String nombreSegundo;
	
	/**
	 * Apellido del usuario
	 */
	@Column(name = "APELLIDO", nullable = false)
	private String apellido;
	
	/**
	 * Apellido del usuario
	 */
	@Column(name = "SEGUNDO_APELLIDO")
	private String apellidoSegundo;

	/**
	 * Documento del usuario
	 */
	@Column(name = "DOCUMENTO", nullable = false)
	private String documento;

	/**
	 * Estado del usuario
	 */
	@Column(name = "ESTADO", nullable = false)
	private boolean estado;

	/**
	 * Username
	 */
	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	/**
	 * Correo del usuario
	 */
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	/**
	 * Genero del usuario
	 */
	@ManyToOne
	@JoinColumn(name = "ID_GENERO_FK", nullable = false)
	private Parametro genero;
	
	/**
	 * Tipo de documento del usuario
	 */
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_DOCUMENTO_FK", nullable = false)
	private Parametro tipoDocumento;
	

	// --------------------------------
	// Constructor de la clase.
	// --------------------------------

	/**
	 * Constructor por defecto.
	 */
	public Usuario() {

	}

	// --------------------------------
	// Metodos de la clase.
	// --------------------------------

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set 
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the genero
	 */
	public Parametro getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Parametro genero) {
		this.genero = genero;
	}

	/**
	 * @return the tipoDocumento
	 */
	public Parametro getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(Parametro tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getNombreSegundo() {
		return nombreSegundo;
	}

	public void setNombreSegundo(String nombreSegundo) {
		this.nombreSegundo = nombreSegundo;
	}

	public String getApellidoSegundo() {
		return apellidoSegundo;
	}

	public void setApellidoSegundo(String apellidoSegundo) {
		this.apellidoSegundo = apellidoSegundo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", nombreSegundo=" + nombreSegundo + ", apellido="
				+ apellido + ", apellidoSegundo=" + apellidoSegundo + ", documento=" + documento + ", estado=" + estado
				+ ", username=" + username + ", email=" + email + ", genero=" + genero + ", tipoDocumento="
				+ tipoDocumento + "]";
	}

}
