<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="DTO.PreferenciaDTO"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>


<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tripder!</title>

    <!-- Bootstrap core CSS -->
    <link href="/SII_ClienteWeb/vendor2/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
      body {
        padding-top: 54px;
      }
      @media (min-width: 992px) {
        body {
          padding-top: 56px;
        }
      }
    </style>

  </head>

  <body>
  
  <%
				if (request.getAttribute("error") != null) {
			%>
			<div class="col-md-12">
				<div class="alert alert-danger">
					<p><%=request.getAttribute("error")%></p>
				</div>
			</div>
			<%
				}
			%>
			<%
				if (request.getAttribute("mensaje") != null) {
			%>
			<div class="col-md-12">
				<div class="alert alert-info">
					<p><%=request.getAttribute("mensaje")%></p>
				</div>
			</div>
			<%
				}
			%>
			
			<%Set<String> tipos_preferencias = (HashSet<String>)request.getAttribute("tipos_preferencias"); 
			List<PreferenciaDTO> preferencias = (List<PreferenciaDTO>)request.getAttribute("preferencias");
			%>
  
  	     	
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="/SII_ClienteWeb/logochico.png" 
     srcset = "/SII_ClienteWeb/logochico.png 2x, 
             /SII_ClienteWeb/logochico.png 768w, 
             /SII_ClienteWeb/logochico.png 768w 2x, 
             /SII_ClienteWeb/logochico.png 1200w, 
             /SII_ClienteWeb/logochico.png 1200w 2x" /></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Inicio
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Login</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">
 <div class="progress">
  <div class="progress-bar progress-bar-striped bg-warning" role="progressbar" style="width: 20%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
  <div class="progress-bar progress-bar-striped bg-warning" role="progressbar" style="width: 20%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
</div>
	
	<table class="table table-bordered" cellspacing="0" witdh=80%>
     
    <tr>
            <td width="20%">
             Datos generales 
            </td>
            <td width="20%">
             Perfil! 
            </td>
            <td width="20%">
             <b>Preferencias! </b>
            </td>  
            <td width="20%">
            Foto! 
            </td>
            <td width="20%">
             Listo!
            </td>
            </tr>
            </table>
      <div class="row">
        <div class="col-lg-12 text-center">
        <img src="/SII_ClienteWeb/huevo3.png" align =center/>
          <h1 class="mt-5"> Y sobre tus viajes, qué preferís? :)</h1>
          <p class="lead">Seleccioná las opciones</p>
          <ul class="list-unstyled">
          </div>
          </div>
          <div class="shadow-sm p-3 mb-5 bg-white rounded">
          <form action="/SII_ClienteWeb/Servlets/ServletModuloUsuarios" method="post" id="registroUsuario4">
			  
			  <div class="form-row">
			  
			  <%if (tipos_preferencias != null) { 
					String tipo_preferencia = null;
					for (Iterator<String> i = tipos_preferencias.iterator(); i.hasNext();) {
						tipo_preferencia = i.next();
			  %>
			  			<div class="col-md-6 mb-3">
			  			<label for="validationServer03"><b><%=tipo_preferencia%></b></label></br>
			  			<select name=<%=tipo_preferencia%> id=<%=tipo_preferencia%> class="form-control"  multiple="multiple">
								<%if (preferencias != null) { 
									PreferenciaDTO preferencia = null;
									for (Iterator<PreferenciaDTO> o = preferencias.iterator(); o.hasNext();) {
										preferencia = o.next();
										if(preferencia.getTipo().equals(tipo_preferencia)){
								%> 
											<option value=<%=preferencia.getIdPreferencia()%>><%=preferencia.getNombre()%></option>
											
										<%}
									}
								}%>
						</select>
						</div>
				<%} 
			} %>
			  
	
			 
			  </div>
            <input type="hidden" name="action" value="registroUsuario4">
            <input type="submit" class="btn btn-dark" align=center name="registroUsuario4" value="¡Siguiente paso!">
			</form>
</div>
          </ul>
    </div>
    
 

 
    <!-- Bootstrap core JavaScript -->
    <script src="/SII_ClienteWeb/vendor/jquery/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="/SII_ClienteWeb/dist/js/BsMultiSelect.js"></script>
	<script>$("select").bsMultiSelect();</script>
    <script src="/SII_ClienteWeb/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/SII_ClienteWeb/js/cargaCiudades.js"></script>
  </body>

</html>