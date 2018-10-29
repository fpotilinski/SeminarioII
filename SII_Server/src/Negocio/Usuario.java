package Negocio;

import java.util.Date;

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
	
	public Usuario(int idUsuario, String email, String password, String avatar, String nombre,
			String apellido, Date fechaNacimiento, String sexo) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
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
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public void save() {
		UsuarioDao.getInstancia().save(this);
	}
	
}
