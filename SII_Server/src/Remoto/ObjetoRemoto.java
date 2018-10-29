package Remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Controlador.ModuloUsuarios;
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
}
