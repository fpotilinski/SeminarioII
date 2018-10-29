package Servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.hibernate.SessionFactory;

import Hibernate.HibernateUtil;
import Interfaces.InterfazRemota;
import Remoto.ObjetoRemoto;

public class Servidor extends Thread {
	InterfazRemota objetoRemoto;

	@SuppressWarnings("unused")
	private static SessionFactory sf = null;

	// Constructor del servidor
	public Servidor() {
		iniciar();
	}

	// Main del servidor
	public static void main(String[] args) {
		new Servidor();
	}
	
	public void iniciar() {
		try {
			LocateRegistry.createRegistry(1099);
			objetoRemoto = ObjetoRemoto.getInstance();
			Naming.rebind(InterfazRemota.url, objetoRemoto);
			sf = HibernateUtil.getSessionFactory();
			System.out.println("Servidor inicializado correctamente...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

