package DTO;

import java.io.Serializable;

public class IdiomaDTO implements Serializable{
	private int idIdioma;
	private String descripcion;
	
	public IdiomaDTO() {}

	public int getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(int idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
