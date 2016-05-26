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
		<h1>Les pizzas du moment</h1>
	</div>
	<div id="pizzasDuMoment">
		<a class="btn btn-success" href="<c:url value="/pizzas/new"></c:url>">nouvelle pizza</a>
		<table class="table table-striped" align="center" width="50%">
			<thead>
				<tr>
					<td>Id</td>
					<td>NOM</td>
					<td>Prix</td>
					<td>Cat&eacute;gorie</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pizza" items="${listePizza }">
				<tr id="tr-${pizza.code }">
					<!-- Code à  insérer dans le HTML pour afficher les données -->
					<td>${pizza.code }</td>
					<td>${pizza.nom }</td>
					<td>${pizza.prix }&euro;</td>
					<td>${pizza.categorie }</td>
					<td><img src="http://placehold.it/150x150"></td>
					<td></td>
					<td><a class="btn btn-info" href="<c:url value="/pizzas/edit?code=${pizza.code}"></c:url>">modifier</a></td>
					<td><button id="supprimer" class="btn btn-danger supprimer" type="button" onclick="supprimer('${pizza.code }')">Supprimer</button></td>
					<!-- Fin du code à  insérer dans le HTML pour afficher les données -->
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="col-lg-8 col-lg-offset-2 col-md-offset-2 /* à compléter */">
		<blockquote>
			<p>The world is a dangerous place to live; not because of the
				people who are evil, but because of the people who don't do anything
				about it.</p>
			<small>par <cite>Albert Einstein</cite></small>
		</blockquote>
	</div>

	<br /> <br />

	<!-- Atouts  -->
	<div id="atouts">
		<!-- à compléter -->
	</div>

</div>

</div>

<div class="clearfix"></div>

<%@ include file="footer.jsp"%>