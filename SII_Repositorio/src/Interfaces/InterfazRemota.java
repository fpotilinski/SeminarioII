package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import DTO.UsuarioDTO;


public interface InterfazRemota extends Remote{
	public static final String url = "//localhost/ObjetoRemoto";
	
	public UsuarioDTO loginUsuario(String email,String password) throws RemoteException;
	
}
