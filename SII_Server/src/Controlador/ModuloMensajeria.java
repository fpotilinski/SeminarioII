package Controlador;

import DAO.UsuarioDao;

public class ModuloMensajeria {
	private static ModuloMensajeria controlador;
	
	public static ModuloMensajeria getInstancia() {
		if (controlador == null) {
			controlador = new ModuloMensajeria();
		}
		return controlador;
	}
	
	public void crearConversacion(List<UsuarioDTO> usuariosDTO) {

	}
	
}
