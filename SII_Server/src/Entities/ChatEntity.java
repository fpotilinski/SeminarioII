package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Chat")
public class ChatEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idChat")
	private Integer idChat;
	@Column(name="referencia")
	private String referencia;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "chats")
	private List<UsuarioEntity> usuarios;
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "chat")
	@Fetch(FetchMode.JOIN)
	private List<MensajeEntity> mensajes;

	public ChatEntity(){
		
	}
	
	public Integer getIdChat() {
		return idChat;
	}
	public void setIdChat(Integer idChat) {
		this.idChat = idChat;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}
	public List<MensajeEntity> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<MensajeEntity> mensajes) {
		this.mensajes = mensajes;
	}
}
