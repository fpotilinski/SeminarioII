<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="DTO.CiudadDTO"%>
<%@ page import="DTO.IdiomaDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>

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
	
	<% List<CiudadDTO> ciudades= (List<CiudadDTO>)request.getAttribute("ciudades");
	List<IdiomaDTO> idiomas = (List<IdiomaDTO>)request.getAttribute("idiomas");
	
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
	<div class="container">
		<div class="progress">
			<div class="progress-bar progress-bar-striped bg-warning"
				role="progressbar" style="width: 20%" aria-valuenow="15"
				aria-valuemin="0" aria-valuemax="100"></div>
		</div>

		<table class="table table-bordered" cellspacing="0" witdh=80%>

			<tr>
				<td width="20%">Datos generales</td>
				<td width="20%"><b>Perfil! </b></td>
				<td width="20%">Preferencias!</td>
				<td width="20%">Foto!</td>
				<td width="20%">Listo!</td>
			</tr>
		</table>
		<div class="row">
			<div class="col-lg-12 text-center">
				<img src="/SII_ClienteWeb/huevo2.png" align=center />
				<h1 class="mt-5">Genial! Sigamos creando tu cuenta :)</h1>
				<p class="lead">Contanos un poco de vos...</p>

			</div>
		</div>
		<div class="shadow-sm p-3 mb-5 bg-white rounded">
			<form action="/SII_ClienteWeb/Servlets/ServletModuloUsuarios"
				method="post" id="registroUsuario3">
				<div class="form-row">

					<label for="validationServer01">¿Cómo te presentarías?</label>
					<textarea class="form-control" name="presentacion" id="presentacion"
						id="exampleFormControlTextarea1" rows="3"></textarea>


				</div>
				
				
				<div class="form-row">
					<div class="col-md-6 mb-3">
					<br>
						<label for="validationServer03">¿Qué ciudades visitaste?</label>

						<div class="form-row" id="ciudad">
						    <select name="ciudades_visitadas" id="ciudades_visitadas" class="form-control"  multiple="multiple">
								<%if (ciudades != null) { 
									CiudadDTO ciudad= null;
									for (Iterator<CiudadDTO> i = ciudades.iterator(); i.hasNext();) {
										ciudad = i.next();
										if (ciudad.getIdCiudad() == 1){
								%>
									<option selected value=<%=ciudad.getIdCiudad()%>><%=ciudad.getNombre() + ", " + ciudad.getPais()%></option>
								<%}else {%>
									<option value=<%=ciudad.getIdCiudad()%>><%=ciudad.getNombre() + ", " + ciudad.getPais()%></option>
								<%}} }%>
							</select>
						
						</div>
						 
					</div>
				</div>
				
					<div class="form-row">
					<div class="col-md-6 mb-3">
					<br>
						<label for="validationServer03">¿Qué ciudades te gustaría conocer?</label>

						<div class="form-row" id="ciudad2">
						    <select name="ciudades_deseadas" id="ciudades_deseadas" class="form-control"  multiple="multiple">
								<%if (ciudades != null) { 
									CiudadDTO ciudad= null;
									for (Iterator<CiudadDTO> i = ciudades.iterator(); i.hasNext();) {
										ciudad = i.next();
										if (ciudad.getIdCiudad() == 1){
								%>
									<option selected value=<%=ciudad.getIdCiudad()%>><%=ciudad.getNombre() + ", " + ciudad.getPais()%></option>
								<%}else {%>
									<option value=<%=ciudad.getIdCiudad()%>><%=ciudad.getNombre() + ", " + ciudad.getPais()%></option>
								<%}} }%>
							</select>
						
						</div>
						 
					</div>
				</div>
				
				<div class="form-row">
					<div class="col-md-6 mb-3">
						<label for="validationServer03">¿Qué idiomas hablás?</label>
						<div class="form-row" id="idiomas">
						    <select name="idiomas_habla" id="idiomas_habla" class="form-control"  multiple="multiple">
								<%if (idiomas != null) { 
									IdiomaDTO idioma= null;
									for (Iterator<IdiomaDTO> i = idiomas.iterator(); i.hasNext();) {
										idioma = i.next();
										if (idioma.getIdIdioma() == 1){
								%>
									<option selected value=<%=idioma.getIdIdioma() %>><%=idioma.getDescripcion()%></option>
								<%}else {%>
									<option value=<%=idioma.getIdIdioma() %>><%=idioma.getDescripcion() %></option>
								<%}} }%>
							</select>
						
						</div>
						<br>
					</div>
				</div>

				<input type="hidden" name="action" value="registroUsuario3">
				<input type="submit" class="btn btn-dark" align=center
					name="registroUsuario3" value="¡Siguiente paso!">
			</form>
		</div>

	</div>



	<!-- Bootstrap core JavaScript -->
	<script src="/SII_ClienteWeb/vendor/jquery/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="/SII_ClienteWeb/dist/js/BsMultiSelect.js"></script>
	<script>$("select").bsMultiSelect();</script>
	<script
		src="/SII_ClienteWeb/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- 	<script src="/SII_ClienteWeb/js/cargaCiudades.js"></script> -->
	<script src="/SII_ClienteWeb/js/duplicarCampo.js"></script>
</body>

</html>
