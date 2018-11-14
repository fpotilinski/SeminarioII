package DAO;

import org.hibernate.SessionFactory;

import DTO.IdiomaDTO;
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
