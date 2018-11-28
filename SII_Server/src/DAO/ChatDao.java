package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DTO.ChatDTO;
import DTO.MensajeDTO;
import DTO.UsuarioDTO;
import Entities.ChatEntity;
import Entities.MensajeEntity;
import Entities.UsuarioEntity;
import Hibernate.HibernateUtil;

public class ChatDao {

	private static ChatDao instancia;
	private SessionFactory sf;

	public ChatDao() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static ChatDao getInstancia() {
		if (instancia == null) {
			instancia = new ChatDao();
		}
		return instancia;
	}

	public void grabarChat(ChatEntity chat) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.merge(chat);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public ChatEntity dtoToEntity(ChatDTO chat) {
		ChatEntity aux = new ChatEntity();
		aux.setIdChat(chat.getIdChat());
		List<MensajeDTO> mensajesDto = chat.getMensajes();
		List<UsuarioDTO> usuariosDto = chat.getUsuarios();
		List<MensajeEntity> mensajes = new ArrayList<MensajeEntity>();
		List<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
		
		for (MensajeDTO m : mensajesDto) {
			mensajes.add(MensajeDao.getInstancia().dtoToEntity(m));
		}
		for (UsuarioDTO u : usuariosDto) {
			usuarios.add(UsuarioDao.getInstancia().dtoToEntity(u));
		}
		
		aux.setMensajes(mensajes);
		aux.setReferencia(chat.getReferencia());
		aux.setUsuarios(usuarios);
		return aux;
	}

	public ChatDTO entityToDto(ChatEntity chat) {
		ChatDTO aux = new ChatDTO();
		aux.setIdChat(chat.getIdChat());
		List<MensajeEntity> mensajes = chat.getMensajes();
		List<UsuarioEntity> usuarios = chat.getUsuarios();
		List<MensajeDTO> mensajesDto = new ArrayList<MensajeDTO>();
		List<UsuarioDTO> usuariosDto = new ArrayList<UsuarioDTO>();
		
		for (MensajeEntity m : mensajes) {
			mensajesDto.add(MensajeDao.getInstancia().entityToDto(m));
		}
		for (UsuarioEntity u : usuarios) {
			usuariosDto.add(UsuarioDao.getInstancia().toDTO(u));
		}
		
		aux.setMensajes(mensajesDto);
		aux.setReferencia(chat.getReferencia());
		aux.setUsuarios(usuariosDto);
		return aux;
	}

}