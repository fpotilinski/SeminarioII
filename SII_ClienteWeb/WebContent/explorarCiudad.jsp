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
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img id="img_destino" class="centered-and-cropped" width=100% height="250" src="https://mapio.net/images-p/1125107.jpg" alt="First slide">
  </div>
  <div class="carousel-item">
      <img id="img_destino" class="centered-and-cropped" width=100% height="250" src="https://d1bvpoagx8hqbg.cloudfront.net/originals/francescas-erasmus-experience-in-barcelona-spain-0559c02187f501e6d925a1d9841ebd37.jpg" alt="First slide">
  </div>
</div>
</div>
      <div>
      
<h6 class="p-3 mb-2 bg-dark text-white">Explorar<h3 class="p-3 mb-2 bg-warning text-dark"> <strong>Santa Teresita</strong></h3></h6>


          
  </div> 
    <div class="container">
   
<div class="row">
  <div class="col-sm-6">
  <h5 class="card-header">Visitando</h5>
    <div class="card">
      <div class="card-body">
        <p class="card-text">
        <figure class="figure"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src="https://www.webcampus.uade.edu.ar/Fotos/3/ID_956303.jpg" alt="Bear"><figcaption class="figure-caption text-center">Manu</figcaption></figure>
        <figure class="figure"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src="https://www.webcampus.uade.edu.ar/Fotos/0/ID_102600.jpg" alt="Bear"><figcaption class="figure-caption text-center">Gastoncito</figcaption></figure>
        <figure class="figure"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src="https://www.webcampus.uade.edu.ar/Fotos/1/ID_910071.jpg" alt="Bear"><figcaption class="figure-caption text-center">Carla</figcaption></figure>
        </p>
        <a href="#" class="btn btn-primary">Contactar viajeros</a>
      </div>
    </div> 
  </div>
  <div class="col-sm-6">
  <h5 class="card-header">Viven aquí</h5>
    <div class="card">
      <div class="card-body">
        <p class="card-text">
        <figure class="figure"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src="/SII_ClienteWeb/descarga.png" alt="Bear"><figcaption class="figure-caption text-center">Federico</figcaption></figure>
        <figure class="figure"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src="/SII_ClienteWeb/descarga.png" alt="Bear"><figcaption class="figure-caption text-center">Federico</figcaption></figure>
        <figure class="figure"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src="/SII_ClienteWeb/descarga.png" alt="Bear"><figcaption class="figure-caption text-center">Federico</figcaption></figure>
        </p>
         
        <a href="#" class="btn btn-primary">Contactar locales</a>
      </div> 
    </div> 
  </div>
    <div class="col-sm-6"> 
  <h5 class="card-header">Viven aquí2 </h5>
    <div class="card">
      <div class="card-body">
        <p class="card-text">
        <figure class="figure"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src="/SII_ClienteWeb/descarga.png" alt="Bear"><figcaption class="figure-caption text-center">Federico</figcaption></figure>
        <figure class="figure"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src="/SII_ClienteWeb/descarga.png" alt="Bear"><figcaption class="figure-caption text-center">Federico</figcaption></figure>
        <figure class="figure"><img id="img_destino" class="centered-and-cropped" width="75" height="75" style="border-radius:50%" src="/SII_ClienteWeb/descarga.png" alt="Bear"><figcaption class="figure-caption text-center">Federico</figcaption></figure>
        </p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
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
