package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DTO.MensajeDTO;
import Entities.MensajeEntity;
import Hibernate.HibernateUtil;

public class MensajeDao {

	private static MensajeDao instancia;
	private SessionFactory sf;

	public MensajeDao() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static MensajeDao getInstancia() {
		if (instancia == null) {
			instancia = new MensajeDao();
		}
		return instancia;
	}
	
	public void grabarMensaje(MensajeEntity mensaje) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.merge(mensaje);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public void grabarMensajes(List<MensajeEntity> mensajes){
		Session session = sf.openSession();
		session.beginTransaction();
		for (MensajeEntity mensaje:mensajes){
			session.merge(mensaje);
		}
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public MensajeEntity dtoToEntity(MensajeDTO mensajeDto) {
		MensajeEntity entity = new MensajeEntity();
		entity.setFecha(mensajeDto.getFecha());
		entity.setHora(mensajeDto.getHora());
		entity.setIdMensaje(mensajeDto.getIdMensaje());
		entity.setMensaje(mensajeDto.getMensaje());
		entity.setUsuario(UsuarioDao.getInstancia().dtoToEntity(mensajeDto.getUsuario()));
		entity.setChat(ChatDao.getInstancia().dtoToEntity(mensajeDto.getChat()));
		return entity;
	}
	
	public MensajeDTO entityToDto(MensajeEntity entity) {
		MensajeDTO dto = new MensajeDTO();
		dto.setFecha(entity.getFecha());
		dto.setHora(entity.getHora());
		dto.setIdMensaje(entity.getIdMensaje());
		dto.setMensaje(entity.getMensaje());	
		dto.setUsuario(UsuarioDao.getInstancia().toDTO(entity.getUsuario()));
		dto.setChat(ChatDao.getInstancia().entityToDto(entity.getChat()));
		return dto;
	}
	
}
