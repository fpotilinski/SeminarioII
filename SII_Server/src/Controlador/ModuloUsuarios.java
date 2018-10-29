package Controlador;

import DAO.UsuarioDao;
import DTO.UsuarioDTO;
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
	
	public UsuarioDTO registrarUsuario(UsuarioDTO usuario) {
		Usuario usuarioNegocio = new Usuario(0, usuario.getEmail(), usuario.getPassword(), usuario.getAvatar(),
				usuario.getNombre(), usuario.getApellido(), usuario.getFechaNacimiento(), usuario.getSexo());
		usuarioNegocio.save();
		return usuario;
	}
}
