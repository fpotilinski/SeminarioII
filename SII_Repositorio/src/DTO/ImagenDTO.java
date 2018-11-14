package DTO;

import java.io.Serializable;
import java.util.List;

public class ImagenDTO implements Serializable{
	private Integer idImagen;
	private String nombre;
	private String url;
	private List<CiudadDTO> ciudad;
	
	public ImagenDTO() {}

	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
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

	public List<CiudadDTO> getCiudad() {
		return ciudad;
	}

	public void setCiudad(List<CiudadDTO> ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}
