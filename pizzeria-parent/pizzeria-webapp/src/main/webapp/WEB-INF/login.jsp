<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@page import="java.util.TreeSet"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.Set"%>
<%@ include file="header.jsp"%>
<div class="container" id="contenu">
	<!-- Thumbnails -->
	<div class="page-header">
		<h1>Pizza</h1>
	</div>
	<div id="pizzasDuMoment">
		<form class="form-horizontal" action="<%=request.getContextPath() %>/login" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Identification</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code</label>
					<div class="col-md-4">
						<input id="addresse" name="addresse" type="text" placeholder="votre addresse"
							class="form-control input-md" required="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nom</label>
					<div class="col-md-4">
						<input id="mdp" name="mdp" type="password" placeholder="votre mot de passe"
							class="form-control input-md" required="">

					</div>
				</div>
				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="modifier"></label>
					<div class="col-md-8">
						<button id="connexion" class="btn btn-success" type="submit">Connexion</button>
					</div>
				</div>

			</fieldset>
		</form>

	</div>

</div>

</div>

<div class="clearfix"></div>

<%@ include file="footer.jsp"%>