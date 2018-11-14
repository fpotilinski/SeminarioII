package Negocio;

import java.util.List;

public class Ciudad {
	private int idCiudad;
	private String nombre;
	private String pais;
	private String informacion;
	private List<Imagen> imagenes;
	
	public Ciudad(int idCiudad, String nombre, String pais, String informacion, List<Imagen> imagenes) {
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.imagenes = imagenes;
		this.pais = pais;
		this.informacion = informacion;
	}
	



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

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
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
	
}
