package DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DTO.CiudadDTO;
import DTO.IdiomaDTO;
import DTO.PreferenciaDTO;
import DTO.UsuarioDTO;
import Entities.CiudadEntity;
import Entities.IdiomaEntity;
import Entities.PreferenciaEntity;
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
	
	public void save(UsuarioDTO usuario) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setApellido(usuario.getApellido());
		usuarioEntity.setAvatar(usuario.getAvatar());
		usuarioEntity.setEmail(usuario.getEmail());
		usuarioEntity.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioEntity.setIdUsuario(usuario.getIdUsuario());
		usuarioEntity.setNombre(usuario.getNombre());
		usuarioEntity.setPassword(usuario.getPassword());
		usuarioEntity.setPresentacion(usuario.getPresentacion());
		usuarioEntity.setSexo("M");
		List<CiudadEntity> ciudadesDeseadas = new ArrayList<CiudadEntity>();
		for(CiudadDTO ciudad : usuario.getCiudadesDeseadas()) {
			int idCiudad = ciudad.getIdCiudad();
			CiudadEntity ciudadEntity = CiudadDao.getInstancia().buscarCiudadByIdEntity(idCiudad);
			ciudadesDeseadas.add(ciudadEntity);
		}
		usuarioEntity.setCiudadesDeseadas(ciudadesDeseadas);
		List<CiudadEntity> ciudadesVisitadas = new ArrayList<CiudadEntity>();
		for(CiudadDTO ciudad : usuario.getCiudadesVisitadas()) {
			int idCiudad = ciudad.getIdCiudad();
			CiudadEntity ciudadEntity = CiudadDao.getInstancia().buscarCiudadByIdEntity(idCiudad);
			ciudadesVisitadas.add(ciudadEntity);
		}
		usuarioEntity.setCiudadesVisitadas(ciudadesVisitadas);
		int idCiudad = usuario.getCiudadResidencia().getIdCiudad();
		CiudadEntity ciudadEntity = CiudadDao.getInstancia().buscarCiudadByIdEntity(idCiudad);
		usuarioEntity.setCiudadResidencia(ciudadEntity);
		List<IdiomaEntity> idiomas = new ArrayList<IdiomaEntity>();
		for(IdiomaDTO idioma : usuario.getIdiomas()) {
			int idIdioma = idioma.getIdIdioma();
			IdiomaEntity idiomaEntity = IdiomaDao.getInstancia().buscarIdiomaByIdEntity(idIdioma);
			idiomas.add(idiomaEntity);
		}
		usuarioEntity.setIdiomas(idiomas);
		List<PreferenciaEntity> preferencias = new ArrayList<PreferenciaEntity>();
		for(PreferenciaDTO preferencia : usuario.getPreferencias()){
			int idPreferencia = preferencia.getIdPreferencia();
			PreferenciaEntity preferenciaEntity = PreferenciaDao.getInstancia().buscarPreferenciaByIdEntity(idPreferencia);
			preferencias.add(preferenciaEntity);
		}
		usuarioEntity.setPreferencias(preferencias);
		session.save(usuarioEntity);
		session.getTransaction().commit();
		session.close();
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

	
	public UsuarioEntity dtoToEntity(UsuarioDTO usuario) {
		UsuarioEntity aux = new UsuarioEntity();
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

	public UsuarioEntity getById(int id) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		UsuarioEntity result = (UsuarioEntity) session.get(UsuarioEntity.class, id);
		session.getTransaction().commit();
		return result;
	}
	

}