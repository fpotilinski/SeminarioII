<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>tripder!</title>

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
     
        <div class="col-lg-12 text-center">
        
          <h1 class="mt-5"> Hola :)<img src="/SII_ClienteWeb/dino.png" align =center/></h1>
          <p class="lead">Ingresa tus datos para acceder a Tripder!</p>
          <ul class="list-unstyled">
          <div class="shadow-sm p-3 mb-5 bg-white rounded">
          <form action="/SII_ClienteWeb/Servlets/ServletModuloUsuarios" method="post" id="loginUsuarios">
            <table class="table table-bordered" cellspacing="0" witdh=50%>
            
            <tr>
            <td>
            Email:
            </td>
            <td>
            <input class="form-control" id="email" name="email" type="text">
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
            
            </td>
            
            <td>
            <input type="hidden" name="action" value="loginUsuarios">
            <a class="btn btn-dark" href="/SII_ClienteWeb/Servlets/ServletModuloUsuarios?action=registroUsuario">�Quiero registrarme!</a>
            <input type="submit" class="btn btn-dark" align=center name="loginUsuarios" value="Ingresar">
            </td>
            </tr>
            </table>
            </form>
</div>
          </ul>
        </div>
      </div>
    </div>
    <form action="/SII_ClienteWeb/Servlets/ServletModuloUsuarios" method="post" id="loginUsuarios">
            
            <input type="hidden" name="action" value="chat">
            <a class="btn btn-dark" href="/SII_ClienteWeb/Servlets/ServletModuloUsuarios?action=registroUsuario">�Quiero registrarme!</a>
            <input type="submit" class="btn btn-dark" align=center name="loginUsuarios" value="Ingresar">
          
            </form>

 
    <!-- Bootstrap core JavaScript -->
    <script src="/SII_ClienteWeb/vendor/jquery/jquery.min.js"></script>
    <script src="/SII_ClienteWeb/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
