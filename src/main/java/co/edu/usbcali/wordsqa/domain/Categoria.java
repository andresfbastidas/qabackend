package co.edu.usbcali.wordsqa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;

	@Column(name="nombre_categoria")
	private String nombreCategoria;

	//bi-directional many-to-one association to Anotacion
	@OneToMany(mappedBy="categoria")
	private List<Anotacion> anotacions;

	public Categoria() {
	}

	public Long getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<Anotacion> getAnotacions() {
		return this.anotacions;
	}

	public void setAnotacions(List<Anotacion> anotacions) {
		this.anotacions = anotacions;
	}

	public Anotacion addAnotacion(Anotacion anotacion) {
		getAnotacions().add(anotacion);
		anotacion.setCategoria(this);

		return anotacion;
	}

	public Anotacion removeAnotacion(Anotacion anotacion) {
		getAnotacions().remove(anotacion);
		anotacion.setCategoria(null);

		return anotacion;
	}

}