package Negocio;

import java.util.Date;
import java.util.List;

import DAO.UsuarioDao;

public class Usuario {
	private int idUsuario;
	private String email;
	private String password;
	private String avatar;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String sexo;
	private String presentacion;
	private List<Preferencia> preferencias;
	private List<Ciudad> ciudadesVisitadas;
	private List<Ciudad> ciudadesDeseadas;
	private List<Itinerario> itinerarios;
	private Ciudad ciudadResidencia;
	private List<Idioma> idiomas;
	
	public Usuario(int idUsuario, String email, String password, String avatar, String nombre,
			String apellido, Date fechaNacimiento, String sexo, String presentacion, List<Preferencia> preferencias,
			List<Ciudad> ciudadesVisitadas, List<Ciudad> ciudadesDeseadas, List<Itinerario> itinerarios,
			Ciudad ciudadResidencia, List<Idioma> idiomas) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.presentacion = presentacion;
		this.preferencias = preferencias;
		this.ciudadesVisitadas = ciudadesVisitadas;
		this.ciudadesDeseadas = ciudadesDeseadas;
		this.itinerarios = itinerarios;
		this.ciudadResidencia = ciudadResidencia;
		this.idiomas = idiomas;
	}
	
	

	public Usuario(int idUsuario2, String email2, String password2, String avatar2, String nombre2, String apellido2,
			Date fechaNacimiento2, String sexo2, String presentacion2, Object preferencias2, Object ciudadesVisitadas2,
			Object ciudadesDeseadas2, Object itinerarios2, Object ciudadResidencia2, Object idiomas2) {
		// TODO Auto-generated constructor stub
	}



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



	public List<Preferencia> getPreferencias() {
		return preferencias;
	}



	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}



	public List<Ciudad> getCiudadesVisitadas() {
		return ciudadesVisitadas;
	}



	public void setCiudadesVisitadas(List<Ciudad> ciudadesVisitadas) {
		this.ciudadesVisitadas = ciudadesVisitadas;
	}



	public List<Ciudad> getCiudadesDeseadas() {
		return ciudadesDeseadas;
	}



	public void setCiudadesDeseadas(List<Ciudad> ciudadesDeseadas) {
		this.ciudadesDeseadas = ciudadesDeseadas;
	}



	public List<Itinerario> getItinerarios() {
		return itinerarios;
	}



	public void setItinerarios(List<Itinerario> itinerarios) {
		this.itinerarios = itinerarios;
	}



	public Ciudad getCiudadResidencia() {
		return ciudadResidencia;
	}



	public void setCiudadResidencia(Ciudad ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	
	

	public List<Idioma> getIdiomas() {
		return idiomas;
	}



	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}



	public void save() {
		UsuarioDao.getInstancia().save(this);
	}
	
}
