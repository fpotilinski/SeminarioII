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
    <div class="row">
    <table class="table table-bordered" cellspacing="0" witdh=100%>
    <tr>
            <td>
             1) Datos generales 
            </td>
            <td>
             2) Perfil! 
            </td>
            <td>
            <b> 3) Preferencias! </b>
            </td>
            <td>
            4) Foto!
            </td>
            <td>
            5) Listo!
            </td>
            </tr>
            </table>
    </div>
      <div class="row">
        <div class="col-lg-12 text-center">
        <h1 class="mt-5"> <img src="/SII_ClienteWeb/huevo3.png" align =center/></h1>
          <h1 class="mt-5"> Y sobre tus viajes, qué preferís? :)</h1>
          <p class="lead">Seleccioná las opciones</p>
          <ul class="list-unstyled">
          </div>
          </div>
          <form action="/SII_ClienteWeb/Servlets/ServletModuloVentas" method="post" id="loginUsuarios">
            <table class="table table-bordered" cellspacing="0" witdh=100%>
            
            <tr>
            <td>
            Estilo:
            </td>
            <td>
            <label class="container">
		  <input type="checkbox" checked="checked"> Montaña
		  <span class="checkmark"></span>
		  </label>
		  <label class="container">
		  <input type="checkbox" checked="checked"> Playa
		  <span class="checkmark"></span>
		  </label>
		  <label class="container">
		  <input type="checkbox" checked="checked"> Historia
		  <span class="checkmark"></span>
		  </label>
		  <label class="container">
		  <input type="checkbox" checked="checked"> Fiesta
		  <span class="checkmark"></span>
		  </label>
            </td>
            <tr>
            <td>
            Password:
            </td>
            <td>
            <input class="form-control" id="password" name="password" type="password">
            </td>
            </tr>
            <tr>
            <td>
            Nombre:
            </td>
            <td>
            <input class="form-control" id="password" name="password" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Apellido:
            </td>
            <td>
            <input class="form-control" id="password" name="password" type="text">
            </td>
            </tr>
            <tr>
            <td>
            Fecha de Nacimiento:
            </td>
            <td>
            <input class="form-control" id="password" name="password" type="date">
            </td>
            </tr>
            <tr>
            <td>
            Sexo:
            </td>
            <td> 
            <label>
            <input class="form-control" type="radio" name="numero" value="Hombre"> Hombre
        </label>
        <label>
            <input class="form-control" type="radio" name="numero" value="Mujer"> Mujer
        </label>
        <label>
            <input class="form-control" type="radio" name="numero" value="No informo"> No informo
        </label>
            </td>
            </tr>
            
            <tr>
            <td>
            ¿En qué ciudad vivís?
            </td>
            <td>
			<input class="form-control" id="paises" list="json-paises" placeholder="Escribe el nombre de un país" />
			<datalist id="json-paises"></datalist>
            </td>
            </tr>
            
            <tr>
            <td>
             
            </td>
            
            <td>
            <input type="hidden" name="action" value="loginUsuarios">
            <input type="submit" class="btn btn-primary" align=center name="loginUsuarios" value="¡Siguiente paso!">
            </td>
            </tr>
            </table>
            </form>

          </ul>
    </div>

 
    <!-- Bootstrap core JavaScript -->
    <script src="/SII_ClienteWeb/vendor/jquery/jquery.min.js"></script>
    <script src="/SII_ClienteWeb/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/SII_ClienteWeb/js/cargaCiudades.js"></script>
  </body>

</html>
