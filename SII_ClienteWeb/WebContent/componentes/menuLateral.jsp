<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<nav id="sidebar">
	<div class="sidebar-header">
		<a class="navbar-brand" href="/SII_ClienteWeb/index2.jsp"><img
			src="/SII_ClienteWeb/logochico.png"
			srcset="/SII_ClienteWeb/logochico.png 2x, 
             /SII_ClienteWeb/logochico.png 768w, 
             /SII_ClienteWeb/logochico.png 768w 2x, 
             /SII_ClienteWeb/logochico.png 1200w, 
             /SII_ClienteWeb/logochico.png 1200w 2x" /></a>
	</div>

	<ul class="list-unstyled components">
		<p>Tu Espacio</p>
		<li class="active"><a href="#homeSubmenu" data-toggle="collapse"
			aria-expanded="false" class="dropdown-toggle">Planea tu Viaje</a>
			<ul class="collapse list-unstyled" id="homeSubmenu">
				<li><a href="#">Itinerarios</a></li>
				<li><a href="#">Proximo Viaje</a></li>
				<li><a href="#">Buscar Destinos</a></li>
			</ul></li>
		<li><a href="#">Tripder Match</a></li>
		<li><a href="#">Tripders</a></li>
		<li><a href="#pageSubmenu" data-toggle="collapse"
			aria-expanded="false" class="dropdown-toggle">Perfil</a>
			<ul class="collapse list-unstyled" id="pageSubmenu">
				<li><a href="#">Preferencias</a></li>
				<li><a href="#">Configuración</a></li>
			</ul></li>
	</ul>

	<ul class="list-unstyled CTAs">
		<!--                 <li> -->
		<!--                     <a href="https://bootstrapious.com/tutorial/files/sidebar.zip" class="download">Download source</a> -->
		<!--                 </li> -->
		<li><a href="https://bootstrapious.com/p/bootstrap-sidebar"
			class="article">Log Out</a></li>
	</ul>
</nav>

</html>