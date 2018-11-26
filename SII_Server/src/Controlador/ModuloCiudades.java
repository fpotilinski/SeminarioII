package Controlador;

import java.util.List;

import DAO.CiudadDao;
import DTO.CiudadDTO;

public class ModuloCiudades {
	private static ModuloCiudades controlador;
	
	public static ModuloCiudades getInstancia() {
		if (controlador == null) {
			controlador = new ModuloCiudades();
		}
		return controlador;
	}
	
	public List<CiudadDTO> listarCiudades(){
		return CiudadDao.getInstancia().listadoCiudades();
	}
	
	public CiudadDTO buscarCiudadById(int idCiudad) {
		return CiudadDao.getInstancia().buscarCiudadById(idCiudad);
	}
	
	public List<CiudadDTO> buscarCiudadesByPais(String pais) {
		return CiudadDao.getInstancia().ciudadesByPais(pais);
	}
}
