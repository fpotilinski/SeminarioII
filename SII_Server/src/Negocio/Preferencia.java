package Negocio;

public class Preferencia {
	private int idPreferencia;
	private String tipo;
	private String nombre;
	
	public Preferencia(int idPreferencia, String tipo, String nombre) {
		this.idPreferencia = idPreferencia;
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	public int getIdPreferencia() {
		return idPreferencia;
	}
	public void setIdPreferencia(int idPreferencia) {
		this.idPreferencia = idPreferencia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
