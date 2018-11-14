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

@Entity
@Table(name="Chat")
public class ChatEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idChat")
	private Integer idChat;
	@Column(name="referencia")
	private String referencia;
	@ManyToMany(mappedBy = "chats")
	private List<UsuarioEntity> usuarios;
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "chat")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<MensajeEntity> mensajes;

}
