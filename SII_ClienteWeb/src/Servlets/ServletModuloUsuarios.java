package Servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DTO.ChatDTO;
import DTO.CiudadDTO;
import DTO.IdiomaDTO;
import DTO.PreferenciaDTO;
import DTO.UsuarioDTO;
import Delegado.BusinessDelegate;

@WebServlet("/Servlets/ServletModuloUsuarios")
public class ServletModuloUsuarios extends HttpServlet {
	final String output = "/uploads"; // carpeta donde se guardarán los archivos subidos
	private static final long serialVersionUID = -2995544905709948607L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (request.getParameter("action").equalsIgnoreCase("loginUsuarios")) {

			RequestDispatcher dispatcher;
			try {

				UsuarioDTO usuario = null;
				String email = ((String) request.getParameter("email"));
				String password = ((String) request.getParameter("password"));

				usuario = BusinessDelegate.getInstancia().loginUsuario(email, password);
				if (usuario != null) {
					request.setAttribute("error", "Login OK!!!");
					session.setAttribute("usuario", usuario);
					dispatcher = request.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response);
				} else {

					request.setAttribute("error", "Usuario o password invalido");

					dispatcher = request.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			if (request.getParameter("action").equalsIgnoreCase("registroUsuario")) {
				RequestDispatcher dispatcher;
				UsuarioDTO usuario = new UsuarioDTO();
				session.setAttribute("usuario", usuario);
				List<CiudadDTO> ciudades = new ArrayList<CiudadDTO>();
				ciudades = BusinessDelegate.getInstancia().listarCiudades();
				request.setAttribute("ciudades", ciudades);
				dispatcher = request.getRequestDispatcher("/registroUsuario.jsp");
				dispatcher.forward(request, response);
			} else {
				if (request.getParameter("action").equalsIgnoreCase("registroUsuario2")) {
					RequestDispatcher dispatcher;
					try {
						// Obtenemos el usuario en sesion y le grabamos los datos de esta pantalla
						UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
						String apellido = request.getParameter("apellido");
						usuario.setApellido(apellido);
						String nombre = request.getParameter("nombre");
						usuario.setNombre(nombre);
						String ocupacion = request.getParameter("ocupacion");
						String email = request.getParameter("email");
						usuario.setEmail(email);
						String password = request.getParameter("password");
						usuario.setPassword(password);
						CiudadDTO ciudad = new CiudadDTO();
						int idCiudad = Integer.parseInt(request.getParameter("ciudad_residencia"));
						ciudad.setIdCiudad(idCiudad);
						usuario.setCiudadResidencia(ciudad);
						// Fecha de nacimiento
						String fch_nac = (request.getParameter("fch_nac"));
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
						String año = fch_nac.substring(0, 4);
						String mes = fch_nac.substring(5, 7);
						String dia = fch_nac.substring(8, 10);
						String strFecha2 = año + "-" + mes + "-" + dia;
						Date fch_nac1 = formatoDelTexto.parse(strFecha2);
						usuario.setFechaNacimiento(fch_nac1);

						// Actualizamos el usuario en session
						session.setAttribute("usuario", usuario);

						// Buscamos ciudades e idiomas para la siguiente pantalla
						List<CiudadDTO> ciudades = new ArrayList<CiudadDTO>();
						ciudades = BusinessDelegate.getInstancia().listarCiudades();
						List<IdiomaDTO> idiomas = new ArrayList<IdiomaDTO>();
						idiomas = BusinessDelegate.getInstancia().listadoIdiomas();
						request.setAttribute("ciudades", ciudades);
						request.setAttribute("idiomas", idiomas);
					} catch (Exception e) {
						// TODO: handle exception
					}

					dispatcher = request.getRequestDispatcher("/registroUsuario2.jsp");
					dispatcher.forward(request, response);
				} else {
					if (request.getParameter("action").equalsIgnoreCase("registroUsuario3")) {
						RequestDispatcher dispatcher;

						UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
						String presentacion = request.getParameter("presentacion");
						usuario.setPresentacion(presentacion);

						// Recuperamos y guardamos ciudades visitadas en usuario
						String[] ciudades = request.getParameterValues("ciudades_visitadas");
						List<CiudadDTO> ciudadesUsuario = new ArrayList<CiudadDTO>();
						for (int loopIndex = 0; loopIndex < ciudades.length; loopIndex++) {
							CiudadDTO ciudad = new CiudadDTO();
							ciudad.setIdCiudad(Integer.parseInt(ciudades[loopIndex]));
							ciudadesUsuario.add(ciudad);
						}
						usuario.setCiudadesVisitadas(ciudadesUsuario);

						// Recuperamos y guardamos ciudades deseadas en usuario
						String[] ciudadesDeseadas = request.getParameterValues("ciudades_deseadas");
						List<CiudadDTO> ciudadesDeseadasUsuario = new ArrayList<CiudadDTO>();
						for (int loopIndex = 0; loopIndex < ciudadesDeseadas.length; loopIndex++) {
							CiudadDTO ciudad = new CiudadDTO();
							ciudad.setIdCiudad(Integer.parseInt(ciudadesDeseadas[loopIndex]));
							ciudadesDeseadasUsuario.add(ciudad);
						}
						usuario.setCiudadesDeseadas(ciudadesDeseadasUsuario);

						// Recuperamos y guardamos idiomas en usuario
						String[] idiomas = request.getParameterValues("idiomas_habla");
						List<IdiomaDTO> idiomasUsuario = new ArrayList<IdiomaDTO>();
						for (int loopIndex = 0; loopIndex < idiomas.length; loopIndex++) {
							IdiomaDTO idioma = new IdiomaDTO();
							idioma.setIdIdioma(Integer.parseInt(idiomas[loopIndex]));
							idiomasUsuario.add(idioma);
						}
						usuario.setIdiomas(idiomasUsuario);

						List<PreferenciaDTO> preferencias = BusinessDelegate.getInstancia().listadoPreferencias();
						List<PreferenciaDTO> estilos = new ArrayList<PreferenciaDTO>();
						List<PreferenciaDTO> lugares = new ArrayList<PreferenciaDTO>();
						List<PreferenciaDTO> actividades = new ArrayList<PreferenciaDTO>();

						Set<String> tipos_preferencias = new HashSet<>();
						for (PreferenciaDTO p : preferencias) {
							tipos_preferencias.add(p.getTipo());
						}

						request.setAttribute("tipos_preferencias", tipos_preferencias);
						request.setAttribute("preferencias", preferencias);

//							request.setAttribute("preferencias", preferencias);
						dispatcher = request.getRequestDispatcher("/registroUsuario3.jsp");
						dispatcher.forward(request, response);
					} else {
						if (request.getParameter("action").equalsIgnoreCase("registroUsuario4")) {
							RequestDispatcher dispatcher;
							UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

							List<PreferenciaDTO> preferencias = BusinessDelegate.getInstancia().listadoPreferencias();
							Set<String> tipos_preferencias = new HashSet<>();
							for (PreferenciaDTO p : preferencias) {
								tipos_preferencias.add(p.getTipo());
							}

							String tipo_preferencia;
							List<PreferenciaDTO> preferenciasDTO = new ArrayList<PreferenciaDTO>();
							for (Iterator<String> i = tipos_preferencias.iterator(); i.hasNext();) {
								tipo_preferencia = i.next();

								// Recuperamos y guardamos preferencias seleccionadas por usuario
								String[] lista_preferencias = request.getParameterValues(tipo_preferencia);

								for (int loopIndex = 0; loopIndex < lista_preferencias.length; loopIndex++) {
									PreferenciaDTO pref = new PreferenciaDTO();
									pref.setIdPreferencia(Integer.parseInt(lista_preferencias[loopIndex]));
									preferenciasDTO.add(pref);
								}
							}

							usuario.setPreferencias(preferenciasDTO);
							session.setAttribute("usuario", usuario);

							dispatcher = request.getRequestDispatcher("/registroUsuario4.jsp");
							dispatcher.forward(request, response);
						} else {
							if (request.getParameter("action").equalsIgnoreCase("registroFinalizado")) {
								// Finalizar registro - Tomar usuario de sesion y mandarlo a grabar!
								RequestDispatcher dispatcher;
								UsuarioDTO usuario = new UsuarioDTO();
								usuario = (UsuarioDTO) session.getAttribute("usuario");

								DiskFileItemFactory factory = new DiskFileItemFactory();
								ServletFileUpload upload = new ServletFileUpload(factory);

								ServletContext servletContext = this.getServletConfig().getServletContext();
								File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
								factory.setRepository(repository);

								// req es la HttpServletRequest que recibimos del formulario.
								// Los items obtenidos serán cada uno de los campos del formulario,
								// tanto campos normales como ficheros subidos.
								List items;
								try {
									items = upload.parseRequest(request);
									String avatar = null;
									// Se recorren todos los items, que son de tipo FileItem
									for (Object item : items) {
										FileItem uploaded = (FileItem) item;

										// Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el
										// fichero
										// subido donde nos interese
										if (!uploaded.isFormField()) {
											// No es campo de formulario, guardamos el fichero en algún sitio
											File fichero = new File("C:/img", uploaded.getName());
											avatar = fichero.getPath();
											try {
												uploaded.write(fichero);
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										} else {
											// es un campo de formulario, podemos obtener clave y valor
											String key = uploaded.getFieldName();
											String valor = uploaded.getString();
										}

									}

									if (avatar != null) {
										usuario.setAvatar(avatar);
									}

									BusinessDelegate.getInstancia().registrarUsuario(usuario);

									dispatcher = request.getRequestDispatcher("/login.jsp");
									dispatcher.forward(request, response);

								} catch (FileUploadException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							} else {
								if (request.getParameter("action").equalsIgnoreCase("cancelarRegistro")) {
									RequestDispatcher dispatcher;
									// Si cancela el registro, matamos el atributo usuario de sesion y redirigimos
									session.removeAttribute("usuario");
									dispatcher = request.getRequestDispatcher("/registroCancelado.jsp");
									dispatcher.forward(request, response);
								} else {
									if (request.getParameter("action").equalsIgnoreCase("chats")) {
										RequestDispatcher dispatcher;
										
										UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
										List<ChatDTO> chats = BusinessDelegate.getInstancia().listadoChats(usuario);
										request.setAttribute("chats", chats);
										request.setAttribute("usuario", usuario);
																				
										dispatcher = request.getRequestDispatcher("/chat2.jsp");
										dispatcher.forward(request, response);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}