package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import DTO.CiudadDTO;
import DTO.IdiomaDTO;
import DTO.PreferenciaDTO;
import DTO.UsuarioDTO;


public interface InterfazRemota extends Remote{
	public static final String url = "//localhost/ObjetoRemoto";
	
	public UsuarioDTO loginUsuario(String email,String password) throws RemoteException;
	public List<PreferenciaDTO> listadoPreferencias() throws RemoteException;
	public List<CiudadDTO> listarCiudades() throws RemoteException;
	public CiudadDTO buscarCiudadById(int idCiudad) throws RemoteException;
	public void registrarUsuario(UsuarioDTO usuario) throws RemoteException;
	public CiudadDTO buscarCiudadByIdFechas(int idCiudad, Date fechaIda, Date fechaVuelta) throws RemoteException;
	public List<IdiomaDTO> listadoIdiomas() throws RemoteException;
	
}
