package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import DTO.CiudadDTO;
import DTO.PreferenciaDTO;
import DTO.UsuarioDTO;


public interface InterfazRemota extends Remote{
	public static final String url = "//localhost/ObjetoRemoto";
	
	public UsuarioDTO loginUsuario(String email,String password) throws RemoteException;
	public List<PreferenciaDTO> listadoPreferencias() throws RemoteException;
	public List<CiudadDTO> listarCiudades() throws RemoteException;
	public CiudadDTO buscarCiudadById(int idCiudad) throws RemoteException;
	public void registrarUsuario(UsuarioDTO usuario) throws RemoteException;
}
