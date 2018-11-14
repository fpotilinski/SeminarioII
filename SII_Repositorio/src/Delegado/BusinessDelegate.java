package Delegado;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import DTO.CiudadDTO;
import DTO.PreferenciaDTO;
import DTO.UsuarioDTO;
import Interfaces.InterfazRemota;

public class BusinessDelegate {
	
	private static BusinessDelegate instancia;
	private InterfazRemota ir;
	
	public static BusinessDelegate getInstancia() {
		if (instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}

	private BusinessDelegate() {
		try {
			ir = (InterfazRemota) Naming.lookup ("//localhost/ObjetoRemoto");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UsuarioDTO loginUsuario(String email, String password) throws RemoteException{
		return ir.loginUsuario(email, password);
	}
	
	public List<PreferenciaDTO> listadoPreferencias() throws RemoteException{
		return ir.listadoPreferencias();
	}
	
	public List<CiudadDTO> listarCiudades() throws RemoteException{
		return ir.listarCiudades();
	}
	
	public CiudadDTO buscarCiudadById(int idCiudad) throws RemoteException{
		return ir.buscarCiudadById(idCiudad);
	}
	
	public void registrarUsuario(UsuarioDTO usuario) throws RemoteException{
		ir.registrarUsuario(usuario);
	}

}