package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DTO.CiudadDTO;
import DTO.IdiomaDTO;
import Entities.CiudadEntity;
import Entities.IdiomaEntity;
import Hibernate.HibernateUtil;
import Negocio.Idioma;

public class IdiomaDao {
	private static IdiomaDao instancia;
	private SessionFactory sf;

	public IdiomaDao() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static IdiomaDao getInstancia() {
		if (instancia == null) {
			instancia = new IdiomaDao();
		}
		return instancia;
	}
	
	public List<IdiomaDTO> listadoIdiomas(){
		List<IdiomaDTO> idiomasDTO = new ArrayList<IdiomaDTO>();
		Session session = sf.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<IdiomaEntity> idiomasEntity = (List<IdiomaEntity>) session
				.createQuery("from IdiomaEntity c").list();
		session.getTransaction().commit();
		session.close();
		
		for(IdiomaEntity idioma : idiomasEntity) {
			idiomasDTO.add(toDTO(idioma));
		}
		
		return idiomasDTO;
	}
	
	public IdiomaEntity buscarIdiomaByIdEntity(int idIdioma) {
		Session session = sf.openSession();
		session.beginTransaction();
		IdiomaEntity idiomaEntity = (IdiomaEntity) session
				.createQuery("from IdiomaEntity c where c.idIdioma = :idIdioma")
				.setParameter("idIdioma", idIdioma).uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		return idiomaEntity;
	}
	
	
	public Idioma toNegocio(IdiomaDTO idioma) {
		return new Idioma(idioma.getIdIdioma(), idioma.getDescripcion());
	}
	
	public IdiomaDTO toDTO(IdiomaEntity entity) {
		IdiomaDTO idioma = new IdiomaDTO();
		idioma.setDescripcion(entity.getDescripcion());
		idioma.setIdIdioma(entity.getIdIdioma());
		return idioma;
	}
}
