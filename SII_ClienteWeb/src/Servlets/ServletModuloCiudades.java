package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
				String fechaIda1 = (request.getParameter("fechaIda"));
				String fechaVuelta1 = (request.getParameter("fechaVuelta"));
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
				
				String año = fechaIda1.substring(0, 4);
				String mes = fechaIda1.substring(5, 7);
				String dia = fechaIda1.substring(8, 10);
				request.setAttribute("año1", año);
				request.setAttribute("mes1", mes);
				request.setAttribute("dia1", dia);
				String strFecha = año +"-" + mes + "-" + dia;
				año = fechaVuelta1.substring(0, 4);
				mes = fechaVuelta1.substring(5, 7);
				dia = fechaVuelta1.substring(8, 10);
				request.setAttribute("año2", año);
				request.setAttribute("mes2", mes);
				request.setAttribute("dia2", dia);
				
				String strFecha2 = año +"-" + mes + "-" + dia;
				Date fechaIda = null;
				Date fechaVuelta = null;
				try {

				fechaIda = formatoDelTexto.parse(strFecha);
				fechaVuelta = formatoDelTexto.parse(strFecha2);

				} catch (ParseException ex) {

				ex.printStackTrace();

				}
				
				CiudadDTO ciudad = new CiudadDTO();
				ciudad  = BusinessDelegate.getInstancia().buscarCiudadByIdFechas(idCiudad, fechaIda, fechaVuelta);
				
				//ciudad = BusinessDelegate.getInstancia().buscarCiudadById(idCiudad);
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
