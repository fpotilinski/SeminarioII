<%@ page import="DTO.CiudadDTO"%>
<%@ page import="DTO.ImagenDTO"%>
<%@ page import="DTO.UsuarioDTO"%>
<%@ page import="DTO.ItinerarioDTO"%>
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
    <%CiudadDTO ciudad = (CiudadDTO) request.getAttribute("ciudad"); %>
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
  <%
  boolean primero = true;
  for(ImagenDTO imagen : ciudad.getImagenes()){ 
	  if (primero == true){
		  primero = false;
		  %>
		  <div class="carousel-item active">
		  <img id="img_destino" class="centered-and-cropped" width=100% height="250" src=<%=imagen.getUrl() %> alt="First slide">
		  </div>
		  <%   
	  }else{
		  %>
		  <div class="carousel-item">
      	<img id="img_destino" class="centered-and-cropped" width=100% height="250" src=<%=imagen.getUrl() %> alt="First slide">
  			</div>		  
	  <%}%>
	 
  <%} %> 
</div>
</div>
      <div>
      
      <%String explorar = "Explorar | " + request.getAttribute("dia1") + "." + request.getAttribute("mes1") + "." + request.getAttribute("año1") + " al " + request.getAttribute("dia2") + "." + request.getAttribute("mes2") + "." + request.getAttribute("año2");  %>
      
<h6 class="p-3 mb-2 bg-dark text-white"><%=explorar %> <a href="#" data-toggle="modal" data-target="#exampleModal" class="btn btn-dark btn-sm">Cambiar fechas</a><a href="#" class="btn btn-dark btn-sm">Armar itinerario</a><h3 class="p-3 mb-2 bg-warning text-dark"> <strong> <%=ciudad.getNombre()%> </strong></h3></h6>


          
  </div> 
    <div class="container">

<div class="row">
<div class="card">
  <div class="card-body">
    <p class="card-text"><%=ciudad.getInformacion() %></p>

  </div>
</div>
<p> </p>
</div>
<div class="row">
  <div class="col-sm-6">
  <h5 class="card-header">Visitando</h5>
    <div class="card">
      <div class="card-body">
        <p class="card-text">
        <% 
        if(ciudad.getItinerarios() != null){
        for(ItinerarioDTO itinerario : ciudad.getItinerarios()) {
        	UsuarioDTO usuario = itinerario.getUsuarioAdministrador();
        %>
            <div class="btn-group dropright"> 
            <figure class="figure" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src=<%=usuario.getAvatar() %> alt="Bear"><figcaption class="figure-caption text-center"><%=usuario.getNombre() %></figcaption> <figcaption class="figure-caption text-center"><%="68%" %></figcaption></figure>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        	<a class="dropdown-item" href="#">Ver perfil</a>
        	<a class="dropdown-item" href="#">Enviar mensaje</a>
      		</div>
    		</div>
    		
    		
    		<%
    		if (itinerario.getInvitados() != null){
    		for(UsuarioDTO usuarioInvitado : itinerario.getInvitados()){%>
                <div class="btn-group dropright"> 
                <figure class="figure" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src=<%=usuarioInvitado.getAvatar() %> alt="Bear"><figcaption class="figure-caption text-center"><%=usuarioInvitado.getNombre() %></figcaption> <figcaption class="figure-caption text-center"><%="68%" %></figcaption></figure>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            	<a class="dropdown-item" href="#">Ver perfil</a>
            	<a class="dropdown-item" href="#">Enviar mensaje</a>
          		</div>
        		</div>
    		<%} } } }%>
        </p>
        <a href="#" class="btn btn-outline-warning btn-sm">Más viajeros</a>
      </div>
    </div> 
  </div>
  <div class="col-sm-6">
  <h5 class="card-header">Residentes</h5>
    <div class="card">
      <div class="card-body">
        <p class="card-text">
        <% 
        if(ciudad.getResidentes() != null){
        for(UsuarioDTO usuario : ciudad.getResidentes()) {
        %>
            <div class="btn-group dropright"> 
            <figure class="figure" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src=<%=usuario.getAvatar() %> alt="Bear"><figcaption class="figure-caption text-center"><%=usuario.getNombre() %></figcaption> <figcaption class="figure-caption text-center"><%="68%" %></figcaption></figure>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        	<a class="dropdown-item" href="#">Ver perfil</a>
        	<a class="dropdown-item" href="#">Enviar mensaje</a>
      		</div>
    		</div>
    		
    		
    		<%} }%>
        </p>
          
        <a href="#" class="btn btn-outline-warning btn-sm">Más residentes </a>
      </div> 
    </div> 
  </div>
 
 <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Cambiar fechas</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
        	  
          <div class="modal-body">
                              <form action="/SII_ClienteWeb/Servlets/ServletModuloCiudades" method="post" id="ingresoCliente">
            <table class="table table-bordered" cellspacing="0" witdh=50%>
            
            <tr>
            <td>
            Fecha ida:
            </td>
            <td>
            <input class="form-control" id="fechaIda" name="fechaIda" type="date">
            </td>
			</tr>
            <tr>
            <td>
            Fecha regreso:
            </td>
            <td>
            <input class="form-control" id="fechaVuelta" name="fechaVuelta" type="date">
            </td>
			</tr>

            </table>
            <input type="hidden" name="action" value="buscarCiudad">
            
            <input type="hidden" name="idCiudad" value=<%=ciudad.getIdCiudad() %> >
            <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <input type="submit" class="btn btn-warning " align=center name="buscarCiudad" value="Confirmar">


          </div>
            
            </form>
          
          
          
          </div>

          
        </div>
      </div>
    </div>

 
    <!-- Bootstrap core JavaScript -->
    <script src="/SII_ClienteWeb/vendor/jquery/jquery.min.js"></script>
    <script src="/SII_ClienteWeb/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/SII_ClienteWeb/js/cargaCiudades.js"></script>
  </body>

</html>
