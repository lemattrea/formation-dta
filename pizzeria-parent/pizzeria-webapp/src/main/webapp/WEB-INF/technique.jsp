<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<div class="container" id="contenu">
	<div class="jumbotron">
		<h1>Bienvenue sur le site de La Florentina !</h1>
		<p>Notre amour pour les pizzas se ressent jusque dans vos
			assiettes.</p>
		<p>En amoureux ou en famille, notre équipe vous accueil 6 jours/7,
			du lundi au samedi.</p>
		<p>
			<a class="btn btn-danger" href="#" role="button">Trop cool ! Je
				veux réserver !</a>
		</p>
	</div>
	<!-- Thumbnails -->
	<div class="page-header">
		<h1>Données techniques</h1>
	</div>
	<div id="pizzasDuMoment">
		<table class="table table-striped" align="center" width="50%">
			<caption>temps d'éxécution des servlets</caption>
			<thead>
				<tr>
					<td>Nom</td>
					<td>Temps(milliseconde)</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${time_servlet.entrySet() }">
				<tr>
					<!-- Code à  insérer dans le HTML pour afficher les données -->
					<td>${entry.getKey() }</td>
					<td>${entry.getValue() }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="table table-striped" align="center" width="50%">
			<caption>Session</caption>
			<tbody>
				<tr>
					<!-- Code à  insérer dans le HTML pour afficher les données -->
					<td>Nombre de session ouverts :</td>
					<td>${openSession }</td>
				</tr>
			</tbody>
		</table>
	</div>


</div>

</div>

<div class="clearfix"></div>

<%@ include file="footer.jsp"%>