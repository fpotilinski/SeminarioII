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
import javax.persistence.Table;

@Entity
@Table(name="Idioma")
public class IdiomaEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idIdioma")
	private Integer idIdioma;
	@Column(name="descripcion")
	private String descripcion;
    @ManyToMany(cascade = { 
            CascadeType.PERSIST, 
            CascadeType.MERGE
        })
        @JoinTable(name = "Usuario_Idioma",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idIdioma")
        )
    private List<UsuarioEntity> usuarios;

	public IdiomaEntity() {}

	public int getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(int idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
