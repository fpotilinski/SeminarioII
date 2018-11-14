package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Imagen")
public class ImagenEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idImagen")
	private Integer idImagen;
	@Column(name="nombre")
	private String nombre;
	@Column(name="url")
	private String url;
	@ManyToMany(mappedBy = "imagenes")
	private List<CiudadEntity> ciudad;
	
	public ImagenEntity() {}

	public int getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}
}
