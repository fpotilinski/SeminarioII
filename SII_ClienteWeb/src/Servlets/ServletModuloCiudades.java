package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.CiudadDTO;
import Delegado.BusinessDelegate;

@WebServlet("/Servlets/ServletModuloCiudades")
public class ServletModuloCiudades extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(request.getParameter("action").equalsIgnoreCase("buscarCiudad")){
			RequestDispatcher dispatcher;
			try {
				int idCiudad = Integer.parseInt(request.getParameter("idCiudad"));
				
				CiudadDTO ciudad = new CiudadDTO();
				ciudad  = BusinessDelegate.getInstancia().buscarCiudadById(idCiudad);
				if(ciudad != null) {
					request.setAttribute("ciudad", ciudad);
					dispatcher=request.getRequestDispatcher("/explorarCiudad.jsp");
					dispatcher.forward(request, response);	
				}else {
					// Redireccionar a página de error!
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
	}

}
