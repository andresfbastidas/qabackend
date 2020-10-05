package co.edu.usbcali.wordsqa.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the anotacion database table.
 * 
 */
@Entity
@NamedQuery(name="Anotacion.findAll", query="SELECT a FROM Anotacion a")
public class Anotacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_anotacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnotacion;

	@Column(name="descripcion_anotacion")
	private String descripcionAnotacion;

	//bi-directional many-to-one association to Archivo
	@ManyToOne
	@JoinColumn(name="id_archivo")
	private Archivo archivo;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	public Anotacion() {
	}

	public Long getIdAnotacion() {
		return this.idAnotacion;
	}

	public void setIdAnotacion(Long idAnotacion) {
		this.idAnotacion = idAnotacion;
	}

	public String getDescripcionAnotacion() {
		return this.descripcionAnotacion;
	}

	public void setDescripcionAnotacion(String descripcionAnotacion) {
		this.descripcionAnotacion = descripcionAnotacion;
	}

	public Archivo getArchivo() {
		return this.archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}