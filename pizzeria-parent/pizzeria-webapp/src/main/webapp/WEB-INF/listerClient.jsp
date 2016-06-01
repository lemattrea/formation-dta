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
				<tr id="tr-${client.id }">
					<!-- Code à  insérer dans le HTML pour afficher les données -->
					<td>${client.id }</td>
					<td>${client.nom }</td>
					<td>${client.prenom }</td>
					<td>${client.email }</td>
					<td><a class="btn btn-info" href="">modifier</a></td>
					<td><button id="supprimer" class="btn btn-danger supprimer" type="button" onclick="supprimerClient('${client.id }')">Supprimer</button></td>
					<!-- Fin du code à  insérer dans le HTML pour afficher les données -->
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<form id="form-client" action="" class="form-horizontal" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>pizza personnalisé&eacute;</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">id</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text"
							class="form-control input-md" disabled>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nom</label>
					<div class="col-md-4">
						<input id="nom" name="nom" type="text" placeholder="Nom utilisateur"
							class="form-control input-md" required>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prenom">Pr&eacute;nom</label>
					<div class="col-md-4">
						<input id="prenom" name="prenom" type="text" placeholder="Prénom utilisateur"
							class="form-control input-md" required>
					</div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prenom">Mot de passe</label>
					<div class="col-md-4">
						<input id="pwd" name="pwd" type="password" placeholder=""
							class="form-control input-md" required>
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email</label>
					<div class="col-md-4">
						<input id="email" name="email" type="text" placeholder="Email utilisateur"
							class="form-control input-md" required>
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
	
	<script type="text/javascript">
		function supprimerClient(code){
			url = '<%=request.getContextPath() %>/clients/'+code;
			$.ajax({
				  type: "DELETE",
				  url: url,
				  success: function(){
					  $("#tr-"+code).remove();
				  }
			});
		}
		$( "#form-client").submit(function( event ) {
			event.preventDefault();
			var jSon = '{';
			jSon += '"nom":"'+$("#nom").val()+'",';
			jSon += '"prenom":"'+$("#prenom").val()+'",';
			jSon += '"email":"'+$("#email").val()+'"';
			jSon += '}';
			alert( jSon );
		});
	</script>
</div>

</div>

<div class="clearfix"></div>

<%@ include file="footer.jsp"%>