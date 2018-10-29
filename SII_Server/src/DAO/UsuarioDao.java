package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DTO.UsuarioDTO;
import Entities.UsuarioEntity;
import Hibernate.HibernateUtil;
import Negocio.Usuario;

public class UsuarioDao {
	private static UsuarioDao instancia;
	private SessionFactory sf;

	public UsuarioDao() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static UsuarioDao getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioDao();
		}
		return instancia;
	}
	
	public UsuarioDTO loginUsuario(String email, String password) {
		Session session = sf.openSession();
		session.beginTransaction();
		UsuarioEntity usuarioEntity = (UsuarioEntity) session
				.createQuery("from UsuarioEntity c where c.email = :email and c.password = :password")
				.setParameter("email", email)
				.setParameter("password", password).uniqueResult();
		session.getTransaction().commit();
		session.close();
		if(usuarioEntity == null) {
			return null;
		}
		return toDTO(usuarioEntity);
	}
	
	public void save(Usuario usuario) {
		
	}

	
	public UsuarioDTO toDTO(UsuarioEntity usuario) {
		UsuarioDTO aux = new UsuarioDTO();
		aux.setApellido(usuario.getApellido());
		aux.setAvatar(usuario.getAvatar());
		aux.setEmail(usuario.getEmail());
		aux.setFechaNacimiento(usuario.getFechaNacimiento());
		aux.setIdUsuario(usuario.getIdUsuario());
		aux.setNombre(usuario.getNombre());
		aux.setPassword(usuario.getPassword());
		aux.setSexo(usuario.getSexo());
		return aux;
	}

}
