package DAO;

import org.hibernate.SessionFactory;

import DTO.ImagenDTO;
import Entities.ImagenEntity;
import Hibernate.HibernateUtil;
import Negocio.Imagen;

public class ImagenDao {
	private static ImagenDao instancia;
	private SessionFactory sf;

	public ImagenDao() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static ImagenDao getInstancia() {
		if (instancia == null) {
			instancia = new ImagenDao();
		}
		return instancia;
	}
	
	public Imagen toNegocio(ImagenDTO imagen) {
		return new Imagen(imagen.getIdImagen(), imagen.getNombre(), imagen.getUrl());
	}
	
	public ImagenDTO toDTO(ImagenEntity entity) {
		ImagenDTO imagen = new ImagenDTO();
		imagen.setIdImagen(entity.getIdImagen());
		imagen.setNombre(entity.getNombre());
		imagen.setUrl(entity.getUrl());
		return imagen;
	}
}
