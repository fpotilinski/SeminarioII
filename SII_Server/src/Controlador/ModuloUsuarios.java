package Controlador;

import java.util.ArrayList;
import java.util.List;

import DAO.CiudadDao;
import DAO.IdiomaDao;
import DAO.PreferenciaDao;
import DAO.UsuarioDao;
import DTO.CiudadDTO;
import DTO.IdiomaDTO;
import DTO.PreferenciaDTO;
import DTO.UsuarioDTO;
import Negocio.Ciudad;
import Negocio.Idioma;
import Negocio.Preferencia;
import Negocio.Usuario;

public class ModuloUsuarios {
	private static ModuloUsuarios controlador;
	
	public static ModuloUsuarios getInstancia() {
		if (controlador == null) {
			controlador = new ModuloUsuarios();
		}
		return controlador;
	}
	
	public UsuarioDTO login(String email, String password) {
		return UsuarioDao.getInstancia().loginUsuario(email, password);
	}
	
	public void registrarUsuario(UsuarioDTO usuario) {
		List<Ciudad> ciudadesDeseadas = new ArrayList<Ciudad>();
		List<Ciudad> ciudadesVisitadas = new ArrayList<Ciudad>();
		List<Preferencia> preferencias = new ArrayList<Preferencia>();
		List<Idioma> idiomas = new ArrayList<Idioma>();
		for(CiudadDTO ciudad : usuario.getCiudadesDeseadas()) {
			ciudadesDeseadas.add(CiudadDao.getInstancia().toNegocio(ciudad));
		}
		for(CiudadDTO ciudad : usuario.getCiudadesVisitadas()) {
			ciudadesDeseadas.add(CiudadDao.getInstancia().toNegocio(ciudad));
		}
		for(PreferenciaDTO preferencia : usuario.getPreferencias()) {
			preferencias.add(PreferenciaDao.getInstancia().toNegocio(preferencia));
		}
		for(IdiomaDTO idioma : usuario.getIdiomas()) {
			idiomas.add(IdiomaDao.getInstancia().toNegocio(idioma));
		}
		
		Usuario usuarioNegocio = new Usuario(0, usuario.getEmail(), usuario.getPassword(), usuario.getAvatar(),
				usuario.getNombre(), usuario.getApellido(), usuario.getFechaNacimiento(), usuario.getSexo(), 
				usuario.getPresentacion(), preferencias, ciudadesVisitadas, ciudadesDeseadas, null, CiudadDao.getInstancia().toNegocio(usuario.getCiudadResidencia()), idiomas);
		
		usuarioNegocio.save();

	}
	
	public List<PreferenciaDTO> listadoPreferencias(){
		return PreferenciaDao.getInstancia().listadoPreferencias();
	}
}
