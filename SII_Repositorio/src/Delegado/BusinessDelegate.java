package Delegado;

import java.rmi.Naming;
import java.rmi.RemoteException;

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

}