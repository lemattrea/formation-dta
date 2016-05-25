<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.TreeSet"%>
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
		<h1>Les pizzas du moment</h1>
	</div>
	<div id="pizzasDuMoment">
		<a class="btn btn-success" href="<%=request.getContextPath() %>/pizzas/new">nouvelle pizza</a>
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
				<%
					Set<Pizza> listPizz = (TreeSet)request.getAttribute("listePizza");
					for (Pizza pizza : listPizz) {
				%>
				<tr id="tr-<%=pizza.getCode()%>">
					<!-- Code à  insérer dans le HTML pour afficher les données -->
					<td><%=pizza.getCode()%></td>
					<td><%=pizza.getNom()%></td>
					<td><%=pizza.getPrix()%>&euro;</td>
					<td><%=pizza.getCategorie()%></td>
					<td><img src="http://placehold.it/150x150"></td>
					<td></td>
					<td><a class="btn btn-info" href="<%=request.getContextPath() %>/pizzas/edit?code=<%=pizza.getCode()%>">modifier</a></td>
					<td><button id="supprimer" class="btn btn-danger supprimer" type="button" onclick="supprimer('<%=pizza.getCode()%>')">Supprimer</button></td>
					<!-- Fin du code à  insérer dans le HTML pour afficher les données -->
				</tr>
				<%
					}
				%>
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