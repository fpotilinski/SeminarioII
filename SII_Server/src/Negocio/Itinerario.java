package Negocio;

import java.util.Date;
import java.util.List;

public class Itinerario {
	private int idItinerario;
	private Ciudad ciudad;
	private Date fechaDesde;
	private Date fechaHasta;
	private Usuario usuarioAdministrador;
	private List<Usuario> invitados;
	private String descripcion;
	
	public Itinerario(int idItinerario, Ciudad ciudad, Date fechaDesde, Date fechaHasta, Usuario usuarioAdministrador,
			List<Usuario> invitados) {
		this.idItinerario = idItinerario;
		this.ciudad = ciudad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.usuarioAdministrador = usuarioAdministrador;
		this.invitados = invitados;
	}

	public int getIdItinerario() {
		return idItinerario;
	}

	public void setIdItinerario(int idItinerario) {
		this.idItinerario = idItinerario;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
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

	public Usuario getUsuarioAdministrador() {
		return usuarioAdministrador;
	}

	public void setUsuarioAdministrador(Usuario usuarioAdministrador) {
		this.usuarioAdministrador = usuarioAdministrador;
	}

	public List<Usuario> getInvitados() {
		return invitados;
	}

	public void setInvitados(List<Usuario> invitados) {
		this.invitados = invitados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
