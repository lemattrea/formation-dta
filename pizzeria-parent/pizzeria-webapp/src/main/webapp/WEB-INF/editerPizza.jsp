<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@page import="java.util.TreeSet"%>
<%@page import="fr.pizzeria.model.Pizza"%>
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
		<h1>Pizza</h1>
	</div>
	<div id="pizzasDuMoment">
		<form class="form-horizontal" action="<c:url value="/pizzas/edit"></c:url>" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Modifier une pizza</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text" placeholder="code pizza" value="${pizza.code }"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nom</label>
					<div class="col-md-4">
						<input id="nom" name="nom" type="text" placeholder="nom pizza" value="${pizza.nom }"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prix">Prix</label>
					<div class="col-md-4">
						<input id="prix" name="prix" type="text" placeholder="prix pizza" value="${pizza.prix }"
							class="form-control input-md" required="">

					</div>
				</div>
				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="categorie">Categorie</label>
					<div class="col-md-4">
						<select id="categorie" name="categorie" class="form-control">
							<c:forEach var="categ" items="${categories }">
							<option <c:if test="${pizza.categorie.equals(categ)}">selected</c:if> value="${categ}">${categ.libelle}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="modifier"></label>
					<div class="col-md-8">
						<button id="modifier" class="btn btn-success" type="submit">Modifier</button>
						<button id="supprimer" class="btn btn-danger" type="button" onclick="editSupprimer('${pizza.code }')">Supprimer</button>
					</div>
				</div>

			</fieldset>
		</form>

	</div>

</div>

</div>

<div class="clearfix"></div>

<%@ include file="footer.jsp"%>