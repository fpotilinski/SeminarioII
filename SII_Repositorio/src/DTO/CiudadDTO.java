package DTO;

import java.io.Serializable;
import java.util.List;

public class CiudadDTO implements Serializable{
	private Integer idCiudad;
	private String nombre;
	private String pais;
	private String informacion;
	private List<ImagenDTO> imagenes;
	private List<UsuarioDTO> visitantes;
	private List<UsuarioDTO> deseados;
	
	public CiudadDTO() {}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public List<ImagenDTO> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImagenDTO> imagenes) {
		this.imagenes = imagenes;
	}

	public List<UsuarioDTO> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(List<UsuarioDTO> visitantes) {
		this.visitantes = visitantes;
	}

	public List<UsuarioDTO> getDeseados() {
		return deseados;
	}

	public void setDeseados(List<UsuarioDTO> deseados) {
		this.deseados = deseados;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	
	
	

}
