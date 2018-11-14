package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DTO.PreferenciaDTO;
import DTO.UsuarioDTO;
import Entities.PreferenciaEntity;
import Entities.UsuarioEntity;
import Hibernate.HibernateUtil;
import Negocio.Preferencia;

public class PreferenciaDao {
	private static PreferenciaDao instancia;
	private SessionFactory sf;

	public PreferenciaDao() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static PreferenciaDao getInstancia() {
		if (instancia == null) {
			instancia = new PreferenciaDao();
		}
		return instancia;
	}
	
	public List<PreferenciaDTO> listadoPreferencias(){
		List<PreferenciaDTO> preferenciasDTO = new ArrayList<PreferenciaDTO>();
		Session session = sf.openSession();
		session.beginTransaction();
		List<PreferenciaEntity> preferenciasEntity = (List<PreferenciaEntity>) session
				.createQuery("from PreferenciaEntity c").list();
		
		for(PreferenciaEntity preferencia : preferenciasEntity) {
			preferenciasDTO.add(toDTO(preferencia));
		}
		
		return preferenciasDTO;
	}
	
	public PreferenciaDTO toDTO(PreferenciaEntity preferencia) {
		PreferenciaDTO preferenciaDTO = new PreferenciaDTO();
		preferenciaDTO.setIdPreferencia(preferencia.getIdPreferencia());
		preferenciaDTO.setNombre(preferencia.getNombre());
		preferenciaDTO.setTipo(preferencia.getTipo());
		return preferenciaDTO;
	}
	
	public Preferencia toNegocio(PreferenciaDTO preferencia) {
		return new Preferencia(preferencia.getIdPreferencia(), preferencia.getTipo(), preferencia.getNombre());
	}
}
