package Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Itinerario")
public class ItinerarioEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idItinerario")
	private Integer idItinerario;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCiudad")
	private CiudadEntity ciudad;
	@Column(name="fechaDesde")
	private Date fechaDesde;
	@Column(name="fechaHasta")
	private Date fechaHasta;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUsuario")
	private UsuarioEntity usuarioAdministrador;
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "Usuario_Itinerario",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idItinerario")
        )
	private List<UsuarioEntity> invitados;
	@Column(name="descripcion")
	private String descripcion;
	
	public ItinerarioEntity() {}

	public Integer getIdItinerario() {
		return idItinerario;
	}

	public void setIdItinerario(Integer idItinerario) {
		this.idItinerario = idItinerario;
	}

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadEntity ciudad) {
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

	public UsuarioEntity getUsuarioAdministrador() {
		return usuarioAdministrador;
	}

	public void setUsuarioAdministrador(UsuarioEntity usuarioAdministrador) {
		this.usuarioAdministrador = usuarioAdministrador;
	}

	public List<UsuarioEntity> getInvitados() {
		return invitados;
	}

	public void setInvitados(List<UsuarioEntity> invitados) {
		this.invitados = invitados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
