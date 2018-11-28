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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class UsuarioEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private Integer idUsuario;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="avatar")
	private String avatar;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="fechaNacimiento")
	private Date fechaNacimiento;
	@Column(name="sexo")
	private String sexo;
	@Column(name="presentacion")
	private String presentacion;
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "Usuario_Preferencias",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idPreferencia")
        )
	private List<PreferenciaEntity> preferencias;
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "Usuario_CiudadesVisitadas",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idCiudad")
        )
	private List<CiudadEntity> ciudadesVisitadas;
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "Usuario_CiudadesDeseadas",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idCiudad")
        )
	private List<CiudadEntity> ciudadesDeseadas;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idItinerario")
	private List<ItinerarioEntity> itinerariosPropios;
	
	@ManyToMany(mappedBy = "invitados")
	private List<ItinerarioEntity> itinerariosInvitado;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ciudadResidencia")
	private CiudadEntity ciudadResidencia;
	
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "Usuario_Idioma",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idIdioma")
        )
	private List<IdiomaEntity> idiomas;
	
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "Usuario_Chat",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idChat")
        )
	private List<ChatEntity> chats;
	
	public UsuarioEntity() {}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
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

	public List<PreferenciaEntity> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<PreferenciaEntity> preferencias) {
		this.preferencias = preferencias;
	}

	public List<CiudadEntity> getCiudadesVisitadas() {
		return ciudadesVisitadas;
	}

	public void setCiudadesVisitadas(List<CiudadEntity> ciudadesVisitadas) {
		this.ciudadesVisitadas = ciudadesVisitadas;
	}

	public List<CiudadEntity> getCiudadesDeseadas() {
		return ciudadesDeseadas;
	}

	public void setCiudadesDeseadas(List<CiudadEntity> ciudadesDeseadas) {
		this.ciudadesDeseadas = ciudadesDeseadas;
	}



	public CiudadEntity getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(CiudadEntity ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public List<ItinerarioEntity> getItinerariosPropios() {
		return itinerariosPropios;
	}

	public void setItinerariosPropios(List<ItinerarioEntity> itinerariosPropios) {
		this.itinerariosPropios = itinerariosPropios;
	}

	public List<ItinerarioEntity> getItinerariosInvitado() {
		return itinerariosInvitado;
	}

	public void setItinerariosInvitado(List<ItinerarioEntity> itinerariosInvitado) {
		this.itinerariosInvitado = itinerariosInvitado;
	}

	public List<IdiomaEntity> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<IdiomaEntity> idiomas) {
		this.idiomas = idiomas;
	}

	public List<ChatEntity> getChats() {
		return chats;
	}

	public void setChats(List<ChatEntity> chats) {
		this.chats = chats;
	}
	
	


}
