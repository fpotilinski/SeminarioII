package Negocio;

public class Idioma {
	private int idIdioma;
	private String descripcion;
	
	public Idioma(int idIdioma, String descripcion) {
		this.idIdioma = idIdioma;
		this.descripcion = descripcion;
	}
	
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
