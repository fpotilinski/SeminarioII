package Controlador;

import java.util.Date;
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
	
	public CiudadDTO buscarCiudadByIdFechas(int idCiudad, Date fechaIda, Date fechaVuelta) {
		System.out.println("llego");
		return CiudadDao.getInstancia().buscarCiudadByIdFechas(idCiudad, fechaIda, fechaVuelta);
	}
	
	public List<CiudadDTO> buscarCiudadesByPais(String pais) {
		return CiudadDao.getInstancia().ciudadesByPais(pais);
	}

}
