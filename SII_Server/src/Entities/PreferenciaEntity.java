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
@Table(name="Preferencia")
public class PreferenciaEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPreferencia")
	private Integer idPreferencia;
	@Column(name="tipo")
	private String tipo;
	@Column(name="nombre")
	private String nombre;
	@ManyToMany(mappedBy = "preferencias")
	private List<UsuarioEntity> usuarios;
	
	public PreferenciaEntity() {}

	public Integer getIdPreferencia() {
		return idPreferencia;
	}

	public void setIdPreferencia(Integer idPreferencia) {
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
