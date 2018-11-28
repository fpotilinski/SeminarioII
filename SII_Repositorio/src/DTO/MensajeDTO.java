package DTO;

import java.util.Date;

public class MensajeDTO {
	private Integer idMensaje;
	private Date fecha;
	private String hora;
	private UsuarioDTO usuario;
	private String mensaje;
	private ChatDTO chat;
	public Integer getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(Integer idMensaje) {
		this.idMensaje = idMensaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public ChatDTO getChat() {
		return chat;
	}
	public void setChat(ChatDTO chat) {
		this.chat = chat;
	}
	
	
}