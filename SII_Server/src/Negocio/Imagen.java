package Negocio;

public class Imagen {
	private int idImagen;
	private String nombre;
	private String url;
	
	public Imagen (int idImagen, String nombre, String url) {
		this.idImagen = idImagen;
		this.nombre = nombre;
		this.url = url;
	}

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
	
}
