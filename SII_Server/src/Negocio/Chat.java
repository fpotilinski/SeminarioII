package Negocio;

import java.util.List;

public class Chat {
	private int idChat;
	private List<Usuario> usuarios;
	private List<Mensaje> mensajes;
	
	public Chat(int idChat, List<Usuario> usuarios, List<Mensaje> mensajes) {
		this.idChat = idChat;
		this.usuarios = usuarios;
		this.mensajes = mensajes;
	}

	public int getIdChat() {
		return idChat;
	}

	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	
	
}
