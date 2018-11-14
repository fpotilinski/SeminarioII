package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ItinerarioDTO implements Serializable{
	private int idItinerario;
	private CiudadDTO ciudad;
	private Date fechaDesde;
	private Date fechaHasta;
	private UsuarioDTO usuarioAdministrador;
	private List<UsuarioDTO> invitados;
	private String descripcion;
	
	public ItinerarioDTO() {}

	public int getIdItinerario() {
		return idItinerario;
	}

	public void setIdItinerario(int idItinerario) {
		this.idItinerario = idItinerario;
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public UsuarioDTO getUsuarioAdministrador() {
		return usuarioAdministrador;
	}

	public void setUsuarioAdministrador(UsuarioDTO usuarioAdministrador) {
		this.usuarioAdministrador = usuarioAdministrador;
	}

	public List<UsuarioDTO> getInvitados() {
		return invitados;
	}

	public void setInvitados(List<UsuarioDTO> invitados) {
		this.invitados = invitados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
