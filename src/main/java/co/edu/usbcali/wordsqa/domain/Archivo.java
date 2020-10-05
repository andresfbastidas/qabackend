package co.edu.usbcali.wordsqa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the archivo database table.
 * 
 */
@Entity
@NamedQuery(name="Archivo.findAll", query="SELECT a FROM Archivo a")
public class Archivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_archivo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArchivo;

	@Column(name="nombre_archivo")
	private String nombreArchivo;

	@Column(name="url_archivo")
	private String urlArchivo;

	//bi-directional many-to-one association to Anotacion
	@OneToMany(mappedBy="archivo")
	private List<Anotacion> anotacions;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public Archivo() {
	}

	public Long getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getUrlArchivo() {
		return this.urlArchivo;
	}

	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

	public List<Anotacion> getAnotacions() {
		return this.anotacions;
	}

	public void setAnotacions(List<Anotacion> anotacions) {
		this.anotacions = anotacions;
	}

	public Anotacion addAnotacion(Anotacion anotacion) {
		getAnotacions().add(anotacion);
		anotacion.setArchivo(this);

		return anotacion;
	}

	public Anotacion removeAnotacion(Anotacion anotacion) {
		getAnotacions().remove(anotacion);
		anotacion.setArchivo(null);

		return anotacion;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}