<footer class="footer-pizzeria">

	<div class="footer-left">

		<img class-"img-responsive" src="/pizzeria-webapp/Images/LogoLaFlorentina.png" />

		<p class="footer-links">
			<a href="Accueil.html">Accueil</a> · <a href="LaFlorentina.html">La
				Florentina</a> · <a href="javascript:chargeHTML('LaCarteDesProduits')">Notre
				carte</a> · <a href="javascript:chargeHTML('ContactezNous.html')">Contactez-nous</a>
		</p>
	</div>

	<div class="footer-center">

		<div>
			<p>
				<span>Rue Edith Piaf, Immeuble Euptoyou</span> 44800 Saint-Herblain
			</p>
		</div>

		<div>
			<p>02 40 99 99 99</p>
		</div>

		<div>
			<p>
				<a href="contact@la-florentina.com">contact@la-florentina.com</a>
			</p>
		</div>

	</div>

	<div class="footer-right">
		<p class="footer-a-propos">
			<span>À propos</span> Lorem ipsum dolor sit amet, consectateur
			adispicing elit. Fusce euismod convallis velit, eu auctor lacus
			vehicula sit amet.
		</p>
	</div>
</footer>

<!-- Fonctions JavaScript -->
<script>
	function supprimer(code_pizz){
		url = '<%=request.getContextPath() %>/pizzas/edit?code='+code_pizz;
		$.ajax({
			  type: "DELETE",
			  url: url,
			  success: function(){
				  $("#tr-"+code_pizz).remove();
			  }
		});
	}

	$(function() {
		// Gestion des tooltips des pizzas du moment
		$(".tooltip-link")
				.tooltip(
						{
							title : "<div style='background-color:white; border: 1px solid black'><img src='http://icons.iconarchive.com/icons/sonya/swarm/256/Pizza-icon.png' style='width:24px;'>Pizza</i></div>",
							html : true,
							template : '<div class="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-head"><h2><img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Pizza-icon.png" style="width:24px;"> Info</h2></div><div class="tooltip-inner"></div></div>'
						});
		// 
		$('.pagination li').on('click', function(e) {
			var tag = $(this);
			var indice = tag.text();
			var index = $('.pagination li').index(this);
			console.log("indice: " + indice);
			$('.pagination li').removeClass();
			$(this).addClass("active");

			$('#pizzasDuMoment').load('Pagination' + indice + '.html');
			/*  
			    à compléter, permet de gérer le n° actif de la pagination
			 */
			e.preventDefault();
		});
	});
	function chargeHTML(page) {
		/*  
		    à compléter, fonction jQuery pour charger une page HTML externe dans la <div> id="contenu" 
		 */
	}
</script>
</body>
</html>