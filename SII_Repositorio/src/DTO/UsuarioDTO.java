package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UsuarioDTO implements Serializable{
	private int idUsuario;
	private String email;
	private String password;
	private String avatar;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String sexo;
	private String presentacion;
	private List<PreferenciaDTO> preferencias;
	private List<CiudadDTO> ciudadesVisitadas;
	private List<CiudadDTO> ciudadesDeseadas;
	private List<ItinerarioDTO> itinerarios;
	private CiudadDTO ciudadResidencia;
	private List<IdiomaDTO> idiomas;
	private List<ChatDTO> chats;
	
	
	public UsuarioDTO() {}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getPresentacion() {
		return presentacion;
	}


	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}


	public List<PreferenciaDTO> getPreferencias() {
		return preferencias;
	}


	public void setPreferencias(List<PreferenciaDTO> preferencias) {
		this.preferencias = preferencias;
	}


	public List<CiudadDTO> getCiudadesVisitadas() {
		return ciudadesVisitadas;
	}


	public void setCiudadesVisitadas(List<CiudadDTO> ciudadesVisitadas) {
		this.ciudadesVisitadas = ciudadesVisitadas;
	}


	public List<CiudadDTO> getCiudadesDeseadas() {
		return ciudadesDeseadas;
	}


	public void setCiudadesDeseadas(List<CiudadDTO> ciudadesDeseadas) {
		this.ciudadesDeseadas = ciudadesDeseadas;
	}


	public List<ItinerarioDTO> getItinerarios() {
		return itinerarios;
	}


	public void setItinerarios(List<ItinerarioDTO> itinerarios) {
		this.itinerarios = itinerarios;
	}


	public CiudadDTO getCiudadResidencia() {
		return ciudadResidencia;
	}


	public void setCiudadResidencia(CiudadDTO ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}


	public List<IdiomaDTO> getIdiomas() {
		return idiomas;
	}


	public void setIdiomas(List<IdiomaDTO> idiomas) {
		this.idiomas = idiomas;
	}


	public List<ChatDTO> getChats() {
		return chats;
	}


	public void setChats(List<ChatDTO> chats) {
		this.chats = chats;
	}
	
	
	
}
