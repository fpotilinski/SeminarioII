<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Tripder!</title>

<!-- Bootstrap core CSS -->
<link href="/SII_ClienteWeb/vendor2/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<style>
body {
	padding-top: 54px;
}

@media ( min-width : 992px) {
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
			<a class="navbar-brand" href="#"><img
				src="/SII_ClienteWeb/logochico.png"
				srcset="/SII_ClienteWeb/logochico.png 2x, 
             /SII_ClienteWeb/logochico.png 768w, 
             /SII_ClienteWeb/logochico.png 768w 2x, 
             /SII_ClienteWeb/logochico.png 1200w, 
             /SII_ClienteWeb/logochico.png 1200w 2x" /></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Inicio
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container"></div>



	<!-- Bootstrap core JavaScript -->
	<script src="/SII_ClienteWeb/vendor/jquery/jquery.min.js"></script>
	<script
		src="/SII_ClienteWeb/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/SII_ClienteWeb/js/cargaCiudades.js"></script>
</body>

</html>
