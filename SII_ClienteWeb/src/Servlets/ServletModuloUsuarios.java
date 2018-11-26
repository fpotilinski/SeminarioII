package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.CiudadDTO;
import DTO.PreferenciaDTO;
import DTO.UsuarioDTO;
import Delegado.BusinessDelegate;



@WebServlet("/Servlets/ServletModuloUsuarios")
public class ServletModuloUsuarios extends HttpServlet{
	private static final long serialVersionUID = -2995544905709948607L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			HttpSession session = request.getSession();
			
			if(request.getParameter("action").equalsIgnoreCase("loginUsuarios")){
				
				RequestDispatcher dispatcher;
				try {
				
	    		UsuarioDTO usuario = null;
	    		String email = ((String)request.getParameter("email"));
	    		String password = ((String)request.getParameter("password"));
	    		
					usuario = BusinessDelegate.getInstancia().loginUsuario(email, password);
					if(usuario != null) {
						request.setAttribute("error", "Login OK!!!");
						session.setAttribute("usuario", usuario);
						dispatcher=request.getRequestDispatcher("/login.jsp");
						dispatcher.forward(request, response);	
					}else {
						
						request.setAttribute("error", "Usuario o password invalido");
						
						dispatcher=request.getRequestDispatcher("/login.jsp");
			    		dispatcher.forward(request, response);
						
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				if(request.getParameter("action").equalsIgnoreCase("registroUsuario")){
					RequestDispatcher dispatcher;
					dispatcher=request.getRequestDispatcher("/registroUsuario.jsp");
					dispatcher.forward(request, response);	
				}else {
					if(request.getParameter("action").equalsIgnoreCase("registroUsuario2")){
						RequestDispatcher dispatcher;
						try {
							List<CiudadDTO> ciudades = new ArrayList<CiudadDTO>();
							ciudades = BusinessDelegate.getInstancia().listarCiudades();
							request.setAttribute("ciudades", ciudades);							
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						dispatcher=request.getRequestDispatcher("/registroUsuario2.jsp");
						dispatcher.forward(request, response);	
					}else {
						if(request.getParameter("action").equalsIgnoreCase("registroUsuario3")){
							RequestDispatcher dispatcher;
							// Buscamos las preferencias parametrizadas en sistema y son las que se ofrecen
							// Para seleccionar. Convendria armar un JSON para que las elijan tipo linkedin. 
							List<PreferenciaDTO> preferencias = BusinessDelegate.getInstancia().listadoPreferencias();
							List<PreferenciaDTO> estilos = new ArrayList<PreferenciaDTO>();
							List<PreferenciaDTO> lugares = new ArrayList<PreferenciaDTO>();
							List<PreferenciaDTO> actividades = new ArrayList<PreferenciaDTO>();
							
							for (PreferenciaDTO p : preferencias) {
								if (p.getTipo().equals("Estilo")) {
									estilos.add(p);
								}else if (p.getTipo().equals("Lugar")) {
									lugares.add(p);
								}else if (p.getTipo().equals("Actividad")){
									actividades.add(p);
								}
								
							}
							request.setAttribute("estilos", estilos);
							request.setAttribute("lugares", lugares);
							request.setAttribute("actividades", actividades);
//							request.setAttribute("preferencias", preferencias);
							dispatcher=request.getRequestDispatcher("/registroUsuario3.jsp");
							dispatcher.forward(request, response);	
						}else {
							if(request.getParameter("action").equalsIgnoreCase("registroUsuario4")){
								RequestDispatcher dispatcher;
								dispatcher=request.getRequestDispatcher("/registroUsuario4.jsp");
								dispatcher.forward(request, response);	
							}else {
								if(request.getParameter("action").equalsIgnoreCase("registroFinalizado")){
									// Finalizar registro - Tomar usuario de sesion y mandarlo a grabar!
									RequestDispatcher dispatcher;
									UsuarioDTO usuario = new UsuarioDTO();
									usuario = (UsuarioDTO) session.getAttribute("usuario");
									BusinessDelegate.getInstancia().registrarUsuario(usuario);
									dispatcher=request.getRequestDispatcher("/registroFinalizado.jsp");
									dispatcher.forward(request, response);	
								}else {
									if(request.getParameter("action").equalsIgnoreCase("cancelarRegistro")) {
										RequestDispatcher dispatcher;
										// Si cancela el registro, matamos el atributo usuario de sesion y redirigimos
										session.removeAttribute("usuario");
										dispatcher=request.getRequestDispatcher("/registroCancelado.jsp");
										dispatcher.forward(request, response);	
									}
								}
							}
						}
					}
				}
			}
		}
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			doPost(req, resp);
		}
}
