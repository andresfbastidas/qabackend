package co.edu.usbcali.wordsqa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proyecto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProyecto;

	@Column(name="descripcion_proyecto")
	private String descripcionProyecto;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="nombre_proyecto")
	private String nombreProyecto;

	//bi-directional many-to-one association to Archivo
	@OneToMany(mappedBy="proyecto")
	private List<Archivo> archivos;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="proyectos")
	private List<Usuario> usuarios;

	public Proyecto() {
	}

	public Long getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getDescripcionProyecto() {
		return this.descripcionProyecto;
	}

	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombreProyecto() {
		return this.nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public List<Archivo> getArchivos() {
		return this.archivos;
	}

	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}

	public Archivo addArchivo(Archivo archivo) {
		getArchivos().add(archivo);
		archivo.setProyecto(this);

		return archivo;
	}

	public Archivo removeArchivo(Archivo archivo) {
		getArchivos().remove(archivo);
		archivo.setProyecto(null);

		return archivo;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}