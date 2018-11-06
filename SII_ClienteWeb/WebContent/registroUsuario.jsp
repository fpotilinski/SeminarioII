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

</div>
	
	<table class="table table-bordered" cellspacing="0" witdh=80%>
     
    <tr>
            <td width="20%">
            <b> Datos generales </b>
            </td>
            <td width="20%">
             Perfil! 
            </td>
            <td width="20%">
             Preferencias! 
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
        <img src="/SII_ClienteWeb/huevo.png" align =center/>
          <h1 class="mt-5"> Listo? Vamos a crear tu cuenta!</h1>
          <p class="lead">Arranquemos por unos datos generales...</p>
          <ul class="list-unstyled">
          </div>
          </div>
          <div class="shadow-sm p-3 mb-5 bg-white rounded">
          <form action="/SII_ClienteWeb/Servlets/ServletModuloUsuarios" method="post" id="registroUsuario2">
			  <div class="form-row">
			    <div class="col-md-4 mb-3">
			      <label for="validationServer01">Email</label>
			      <input type="text" class="form-control" id="email" required>
			    </div>
			    <div class="col-md-4 mb-3">
			      <label for="validationServer02">Contraseña</label>
			      <input type="password" class="form-control" id="password"  required>
			    </div>
			    <div class="col-md-4 mb-3">
			      <label for="validationServerUsername">Usuario</label>
			      <div class="input-group">
			        <div class="input-group-prepend">
			          <span class="input-group-text" id="inputGroupPrepend3">@</span>
			        </div>
			        <input type="text" class="form-control" id="validationServerUsername" aria-describedby="inputGroupPrepend3" required>
			      </div>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="col-md-6 mb-3">
			      <label for="validationServer03">Nombre</label>
			      <input type="text" class="form-control" id="validationServer03"required>
			    </div>
			    <div class="col-md-3 mb-3">
			      <label for="validationServer04">Apellido</label>
			      <input type="text" class="form-control" id="validationServer04" required>
			    </div>
			    <div class="col-md-3 mb-3">
			      <label for="validationServer05">Fecha de Nacimiento</label>
			      <input type="date" class="form-control" id="validationServer05" required>
			    </div>
			  </div>
			  	<div class="form-row">
			    <div class="col-md-6 mb-3">
			      <label for="validationServer03">¿En qué ciudad vivís?</label>
			      <input class="form-control" id="paises" name="ciudad" list="json-paises"  required />
				  <datalist id="json-paises"></datalist>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="col-md-6 mb-3">
			      <label for="validationServer03">¿A qué te dedicás?</label>
			      <input type="text" class="form-control" id="validationServer04" required>
			    </div>
			  </div>
			  <input type="hidden" name="action" value="registroUsuario2">
            <input type="submit" class="btn btn-dark" align=center name="registroUsuario2" value="¡Siguiente paso!">
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
