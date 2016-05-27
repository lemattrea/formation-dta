<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Accueil - La Florentina - Pizzéria à Saint-Herblain</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/pizzeria-webapp/css/feuilleDeStylePizzeria.css">
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 100%;
	height: auto;
	left: 50%;
	margin: auto;
}

.carousel-caption {
	font-size: 32px;
}

.jumbotron {
	background-color: coral;
	color: white;
}

.thumbnail>a>img {
	height: 200px;
}

.thumbnail>.caption>p {
	color: cadetblue;
	width: 100%;
	overflow: hidden;
}

/* Style du template des tooltips pour les pizzas */
.tooltip-head {
	color: #fff;
	background-color: crimson;
	padding: 5px 30px 5px 30px;
	border-radius: 4px 4px 0 0;
	text-align: center;
	margin-bottom: -2px;
}

.tooltip-head h2 {
	margin: 0;
	font-size: 20px;
}
</style>
<script type="text/javascript">
	$('.carousel').carousel({
		interval : 2000
	})
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<div id="monCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#monCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#monCarousel" data-slide-to="1"></li>
					<li data-target="#monCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">

					<div class="item active">
						<img src="/pizzeria-webapp/Images/Carousel/Carousel1.jpg" alt="Pizzeria">
						<div class="carousel-caption">
							<h1>La Florentina</h1>
							<p>L'italie est dans votre pizza !</p>
						</div>
					</div>
					<div class="item">
						<img src="/pizzeria-webapp/Images/Carousel/Carousel2.jpg" alt="Pizzeria">
						<div class="carousel-caption">
							<h1>Nos pizzas</h1>
							<p>Il y en a pour tout les goûts :-)</p>
						</div>
					</div>
					<div class="item">
						<img src="/pizzeria-webapp/Images/Carousel/Carousel3.jpg" alt="Pizzeria">
						<div class="carousel-caption">
							<h1>Four à bois</h1>
							<p>Quoi de mieux qu'un four à bois pour faire de bonne pizza</p>
						</div>
					</div>

				</div>

				<!-- Flèches de contrôle -->
				<a class="left carousel-control" href="#monCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Précédent</span>
				</a> <a class="right carousel-control" href="#monCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Suivant</span>
				</a>
			</div>

			<!-- Début de la barre de navigation -->
			<div class="container">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<!-- Barre de navigation pour smartphones -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#maNavBar">
								<span class="icon-bar"></span>
								<!-- à compléter -->
							</button>
						</div>

						<!-- Barre de navigation pour ordinateurs -->
						<div class="collapse navbar-collapse" id="maNavBar">
							<ul class="nav navbar-nav">
								<li class="active"><a href="<c:url value="/pizzas/list"></c:url>"><span
										class="glyphicon glyphicon-home" aria-hidden="true"></span>
										Accueil</a></li>
								<li><a href="<c:url value="/clients"></c:url>"><span
										class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
										Client</a></li>
								<li><a href="<c:url value="/technique"></c:url>"><span
										class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
										Donnée technique</a></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-expanded="false"><span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										Notre carte<span class="caret"></span></a>
									<ul class="dropdown-menu" role="menu">
										<li>
											<!-- à compléter --> Télécharger la carte
										</li>
										<li>
											<!-- à compléter --> Voir la carte
										</li>
										<li role="separator" class="divider"></li>
										<li class="dropdown-header"><span
											class="glyphicon glyphicon-fire" aria-hidden="true"></span>
											Nos pizzas</li>
										<li><a href="#">Marguerita <span
												class="label label-success">Produit de la semaine</span></a></li>
										<li><a href="#">Reine</a></li>
										<!-- à compléter -->
									</ul></li>
								<li><a href="javascript:chargeHTML('ContactezNous')"><span
										class="glyphicon glyphicon-home" aria-hidden="true"></span>
										Contactez-nous</a></li>
							</ul>
							<c:if test="${login }"><button id="deco" class="btn btn-warning pull-right" type="button">Déconnexion</button></c:if>
						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
		</div>