package Remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import Controlador.ModuloCiudades;
import Controlador.ModuloMensajeria;
import Controlador.ModuloUsuarios;
import DTO.ChatDTO;
import DTO.CiudadDTO;
import DTO.IdiomaDTO;
import DTO.PreferenciaDTO;
import DTO.UsuarioDTO;
import Interfaces.InterfazRemota;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfazRemota{
	 
	private static ObjetoRemoto instancia;
	private static final long serialVersionUID = 1L;

	private ObjetoRemoto() throws RemoteException {
		super();
	}

	public static ObjetoRemoto getInstance() {
		if (instancia == null)
		{
			try {
				instancia = new ObjetoRemoto();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	return instancia;
	}

	public UsuarioDTO loginUsuario(String email, String password) throws RemoteException {
		return ModuloUsuarios.getInstancia().login(email, password);
	}
	
	public List<PreferenciaDTO> listadoPreferencias() throws RemoteException{
		return ModuloUsuarios.getInstancia().listadoPreferencias();
	}
	
	public List<CiudadDTO> listarCiudades() throws RemoteException{
		return ModuloCiudades.getInstancia().listarCiudades();
	}
	
	public List<IdiomaDTO> listadoIdiomas() throws RemoteException{
		return ModuloUsuarios.getInstancia().listadoIdiomas();
	}
	
	public CiudadDTO buscarCiudadById(int idCiudad) throws RemoteException{
		return ModuloCiudades.getInstancia().buscarCiudadById(idCiudad);
	}
	
	public void registrarUsuario(UsuarioDTO usuario) throws RemoteException{
		ModuloUsuarios.getInstancia().registrarUsuario(usuario);
	}
	
	public CiudadDTO buscarCiudadByIdFechas(int idCiudad, Date fechaIda, Date fechaVuelta) throws RemoteException{
		return ModuloCiudades.getInstancia().buscarCiudadByIdFechas(idCiudad, fechaIda, fechaVuelta);
	}

	@Override
	public List<ChatDTO> listadoChats(UsuarioDTO usuario) throws RemoteException{
		return ModuloMensajeria.getInstancia().buscarConversaciones(usuario);
	}
}
