package DTO;

import java.util.List;

public class ChatDTO {
	private int idChat;
	private String referencia;
	private List<UsuarioDTO> usuarios;
	private List<MensajeDTO> mensajes;
	public int getIdChat() {
		return idChat;
	}
	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	public List<MensajeDTO> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<MensajeDTO> mensajes) {
		this.mensajes = mensajes;
	}
	
}
