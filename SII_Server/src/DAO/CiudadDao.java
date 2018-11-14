package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DTO.CiudadDTO;
import DTO.ImagenDTO;
import DTO.UsuarioDTO;
import Entities.CiudadEntity;
import Entities.ImagenEntity;
import Entities.UsuarioEntity;
import Hibernate.HibernateUtil;
import Negocio.Ciudad;
import Negocio.Imagen;

public class CiudadDao {
	private static CiudadDao instancia;
	private SessionFactory sf;

	public CiudadDao() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static CiudadDao getInstancia() {
		if (instancia == null) {
			instancia = new CiudadDao();
		}
		return instancia;
	}
	
	public List<CiudadDTO> listadoCiudades(){
		List<CiudadDTO> ciudadesDTO = new ArrayList<CiudadDTO>();
		Session session = sf.openSession();
		session.beginTransaction();
		List<CiudadEntity> ciudadesEntity = (List<CiudadEntity>) session
				.createQuery("from CiudadEntity c").list();
		session.getTransaction().commit();
		session.close();
		
		for(CiudadEntity ciudad : ciudadesEntity) {
			ciudadesDTO.add(toBasicDTO(ciudad));
		}
		
		return ciudadesDTO;
	}
	
	public CiudadDTO buscarCiudadById(int idCiudad) {
		List<CiudadDTO> ciudadesDTO = new ArrayList<CiudadDTO>();
		Session session = sf.openSession();
		session.beginTransaction();
		CiudadEntity ciudadEntity = (CiudadEntity) session
				.createQuery("from CiudadEntity c where c.idCiudad = :idCiudad")
				.setParameter("idCiudad", idCiudad).uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		return toDTO(ciudadEntity);
	}
	
	public CiudadDTO toBasicDTO(CiudadEntity entity) {
		CiudadDTO ciudad = new CiudadDTO();
		ciudad.setIdCiudad(entity.getIdCiudad());
		ciudad.setNombre(entity.getNombre());
		return ciudad;
	}
	
	public CiudadDTO toDTO(CiudadEntity entity) {
		CiudadDTO ciudad = new CiudadDTO();
		ciudad.setIdCiudad(entity.getIdCiudad());
		List<ImagenDTO> imagenes = new ArrayList<ImagenDTO>();
		for(ImagenEntity imagen : entity.getImagenes()) {
			imagenes.add(ImagenDao.getInstancia().toDTO(imagen));
		}
		ciudad.setImagenes(imagenes);
		ciudad.setInformacion(entity.getInformacion());
		ciudad.setNombre(entity.getNombre());
		ciudad.setPais(entity.getPais());
		List<UsuarioDTO> usuariosVisitantes = new ArrayList<UsuarioDTO>();
		for(UsuarioEntity usuario : entity.getVisitantes()) {
			usuariosVisitantes.add(UsuarioDao.getInstancia().toDTO(usuario));
		}
		ciudad.setVisitantes(usuariosVisitantes);
		
		List<UsuarioDTO> usuariosWishList = new ArrayList<UsuarioDTO>();
		for(UsuarioEntity usuario : entity.getDeseados()) {
			usuariosWishList.add(UsuarioDao.getInstancia().toDTO(usuario));
		}
		ciudad.setDeseados(usuariosWishList);
		return ciudad;
	}
	
	
	
	public Ciudad toNegocio(CiudadDTO ciudad) {
		List<Imagen> imagenes = new ArrayList<Imagen>();
		for(ImagenDTO imagen : ciudad.getImagenes()) {
			imagenes.add(ImagenDao.getInstancia().toNegocio(imagen));
		}
		return new Ciudad(ciudad.getIdCiudad(), ciudad.getNombre(),
				ciudad.getPais(), ciudad.getInformacion(), imagenes);
	}
}
