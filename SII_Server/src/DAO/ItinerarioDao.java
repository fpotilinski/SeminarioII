package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import DTO.ItinerarioDTO;
import DTO.UsuarioDTO;
import Entities.ItinerarioEntity;
import Entities.UsuarioEntity;
import Hibernate.HibernateUtil;

public class ItinerarioDao {
	private static ItinerarioDao instancia;
	private SessionFactory sf;

	public ItinerarioDao() {
		sf = HibernateUtil.getSessionFactory();
	}

	public static ItinerarioDao getInstancia() {
		if (instancia == null) {
			instancia = new ItinerarioDao();
		}
		return instancia;
	}
	
	public ItinerarioDTO toDTO(ItinerarioEntity entity){
		ItinerarioDTO dto = new ItinerarioDTO();
		dto.setDescripcion(entity.getDescripcion());
		dto.setFechaDesde(entity.getFechaDesde());
		dto.setFechaHasta(entity.getFechaHasta());
		dto.setIdItinerario(entity.getIdItinerario());
		List<UsuarioDTO> invitados = new ArrayList<UsuarioDTO>();
		for(UsuarioEntity usuarioEntity : entity.getInvitados()) {
			invitados.add(UsuarioDao.getInstancia().toDTO(usuarioEntity));
		}
		dto.setInvitados(invitados);
		dto.setUsuarioAdministrador(UsuarioDao.getInstancia().toDTO(entity.getUsuarioAdministrador()));
		
		return dto;
	}
}
