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
			  <div class="col-md-6 mb-3">
			  <label for="validationServer03"><b>Mi estilo de viaje es...</b></label></br>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
				  <label class="form-check-label" for="inlineCheckbox1">Relax</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
				  <label class="form-check-label" for="inlineCheckbox2">Aventura</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Diversión</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Descubrimiento</label>
				</div>
			  </div>
			  
			  <div class="col-md-6 mb-3">
			  <label for="validationServer03"><b>Prefiero...</b></label></br>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
				  <label class="form-check-label" for="inlineCheckbox1">Playa</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
				  <label class="form-check-label" for="inlineCheckbox2">Montaña</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Selva</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Ciudad</label>
				</div>
			  </div>
			  </div>
			  <div class="form-row">
			  <div class="col-md-6 mb-3">
			  <label for="validationServer03"><b>Me interesa...</b></label></br>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
				  <label class="form-check-label" for="inlineCheckbox1">Gastronomia</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
				  <label class="form-check-label" for="inlineCheckbox2">Historia y Cultura</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Pubs & Parties</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Free walking tours</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Tours organizados</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Conocer gente nueva</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Actividades grupales</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Shopping</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Cine</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Música</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Deportes extremos</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Museos</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Playa y cruceros</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Turismo Mítico</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
				  <label class="form-check-label" for="inlineCheckbox3">Aire libre y naturaleza</label>
				</div>
			  </div>
			  </div>
            <input type="hidden" name="action" value="registroUsuario4">
            <input type="submit" class="btn btn-dark" align=center name="registroUsuario4" value="¡Siguiente paso!">
			</form>
</div>
          </ul>
    </div>
    
 

 
    <!-- Bootstrap core JavaScript -->
    <script src="/SII_ClienteWeb/vendor/jquery/jquery.min.js"></script>
    <script src="/SII_ClienteWeb/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/SII_ClienteWeb/js/cargaCiudades.js"></script>
  </body>

</html>
