<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@page import="java.util.TreeSet"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.Set"%>
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
		<h1>Pizza</h1>
	</div>
	<div id="pizzasDuMoment">
		<%
			Pizza pizza = (Pizza) request.getAttribute("listePizza");
		%>
		<form class="form-horizontal" action="<%=request.getContextPath() %>/pizzas/new" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Nouvelle pizza</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text" placeholder="code pizza"
							class="form-control input-md" required="">

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
					<label class="col-md-4 control-label" for="prix">Prix</label>
					<div class="col-md-4">
						<input id="prix" name="prix" type="text" placeholder="prix pizza"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="categorie">Categorie</label>
					<div class="col-md-4">
						<select id="categorie" name="categorie" class="form-control">
							<option value="VIANDE">Viande</option>
							<option value="SANS_VIANDE">Sans Viande</option>
							<option value="POISSON">Poisson</option>
						</select>
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