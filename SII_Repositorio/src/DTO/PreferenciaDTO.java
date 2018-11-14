package DTO;

import java.io.Serializable;

public class PreferenciaDTO implements Serializable{
	private int idPreferencia;
	private String tipo;
	private String nombre;
	
	public PreferenciaDTO() {}

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
