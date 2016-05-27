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
		<p>En amoureux ou en famille, notre �quipe vous accueil 6 jours/7,
			du lundi au samedi.</p>
		<p>
			<a class="btn btn-danger" href="#" role="button">Trop cool ! Je
				veux r�server !</a>
		</p>
	</div>
	<!-- Thumbnails -->
	<div class="page-header">
		<h1>Liste des clients</h1>
	</div>
	<div id="clientMoment">
		<a class="btn btn-success" href="<c:url value="/pizzas/new"></c:url>">nouvelle pizza</a>
		<table class="table table-striped" align="center" width="50%">
			<thead>
				<tr>
					<td>Id</td>
					<td>NOM</td>
					<td>PRENOM</td>
					<td>EMAIL</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="client" items="${listeClient }">
				<tr id="tr-${pizza.id }">
					<!-- Code � ins�rer dans le HTML pour afficher les donn�es -->
					<td>${client.id }</td>
					<td>${client.nom }</td>
					<td>${client.prenom }</td>
					<td>${client.email }</td>
					<td><a class="btn btn-info" href="<c:url value="/pizzas/edit?code=${pizza.code}"></c:url>">modifier</a></td>
					<td><button id="supprimer" class="btn btn-danger supprimer" type="button" onclick="supprimer('${pizza.code }')">Supprimer</button></td>
					<!-- Fin du code � ins�rer dans le HTML pour afficher les donn�es -->
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<form class="form-horizontal" action="<c:url value="/pizzas/new"></c:url>" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>pizza personnalis�&eacute;</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">id</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text" placeholder="code pizza"
							class="form-control input-md" required="" disabled>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nom</label>
					<div class="col-md-4">
						<input id="nom" name="nom" type="text" placeholder="nom pizza"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prenom">Pr&eacute;nom</label>
					<div class="col-md-4">
						<input id="prix" name="prix" type="text" placeholder="prix pizza"
							class="form-control input-md" required="">
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email</label>
					<div class="col-md-4">
						<input id="prix" name="email" type="text" placeholder="prix pizza"
							class="form-control input-md" required="">
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="modifier"></label>
					<div class="col-md-8">
						<button id="modifier" class="btn btn-success" type="submit">Ajouter</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	

</div>

</div>

<div class="clearfix"></div>

<%@ include file="footer.jsp"%>