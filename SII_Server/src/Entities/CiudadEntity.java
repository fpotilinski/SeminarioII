package Entities;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ciudad")
public class CiudadEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCiudad")
	private Integer idCiudad;
	@Column(name="nombre")
	private String nombre;
	@Column(name="pais")
	private String pais;
	@Column(name="informacion")
	private String informacion;
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "Ciudad_Imagen",
            joinColumns = @JoinColumn(name = "idCiudad"),
            inverseJoinColumns = @JoinColumn(name = "idImagen")
        )
	private List<ImagenEntity> imagenes;
   
	@ManyToMany(mappedBy = "ciudadesDeseadas")
	private List<UsuarioEntity> deseados;
	
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "Ciudad_Itinerario",
            joinColumns = @JoinColumn(name = "idCiudad"),
            inverseJoinColumns = @JoinColumn(name = "idItinerario")
        )
	private List<ItinerarioEntity> itinerarios;
	
	@OneToMany(mappedBy = "ciudadResidencia")
	private List<UsuarioEntity> residentes;
	
	public CiudadEntity() {}
	
	

	public List<UsuarioEntity> getResidentes() {
		return residentes;
	}



	public void setResidentes(List<UsuarioEntity> residentes) {
		this.residentes = residentes;
	}



	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public List<ImagenEntity> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImagenEntity> imagenes) {
		this.imagenes = imagenes;
	}

	public List<UsuarioEntity> getDeseados() {
		return deseados;
	}

	public void setDeseados(List<UsuarioEntity> deseados) {
		this.deseados = deseados;
	}

	public List<ItinerarioEntity> getItinerarios() {
		return itinerarios;
	}

	public void setItinerarios(List<ItinerarioEntity> itinerarios) {
		this.itinerarios = itinerarios;
	}
	
	
	
	

}
