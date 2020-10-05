package co.edu.usbcali.wordsqa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email_usuario")
	private String emailUsuario;

	private String contrasena;

	private String estado;

	@Column(name="foto_url")
	private String fotoUrl;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	//bi-directional many-to-many association to Proyecto
	@ManyToMany
	@JoinTable(
		name="usuario_proyecto"
		, joinColumns={
			@JoinColumn(name="email_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_proyecto")
			}
		)
	private List<Proyecto> proyectos;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario")
	private TipoUsuario tipoUsuario;

	public Usuario() {
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFotoUrl() {
		return this.fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}