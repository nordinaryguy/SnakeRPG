<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Snake RPG</title>

<!-- CSS -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styleMainPage.css">
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-collapse-main">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">${sessionScope.snake.pseudo}
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				Level : ${sessionScope.snake.level}
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				Argent : ${sessionScope.snake.argent}$€</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse-main">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#home">SnakeHome</a></li>
				<li><a href="#store">SnakeStore</a></li>
				<li><a href="#snakeinfos">SnakeInfos</a></li>
				<li><a href="${ pageContext.request.contextPath}/snakerpg_auth">Déconnexion</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<!-- first section - Home -->
	<div id="home" class="home">
		<div class="text-vcenter">
			<h1>Bienvenue ${sessionScope.snake.pseudo} !</h1>
			<h3>SnakeWebApp</h3>
		</div>
	</div>

	<!-- second section - store -->
	<div id="store" class="pad-section">
		<div class="container">
			<div class="row">
				<h1 class="col-md-1 col-md-offset-5">SnakeStore</h1>
			</div>
			<div class="row conteneurStore  marginmod1 ">
				<div class="row marginmod">
					<div class="col-sm-3">Invincibilité</div>
					<div class="col-sm-3">
						<img class="imgbonusInvinc" src="css/invincLogo.png"
							alt="logo invincibilite">
					</div>
					<div class="col-sm-3">30 $€</div>
					<div class="col-sm-3">
						<button type="button" class="btn btn-info btn-md">Acheter</button>
					</div>
				</div>
				<div class="row marginmod2">
					<div class="col-sm-3">Invisibilité</div>
					<div class="col-sm-3">
						<img class="imgbonusInvis" src="css/invisLogo.png"
							alt="logo invisibilite">
					</div>
					<div class="col-sm-3">20 $€</div>
					<div class="col-sm-3">
						<button type="button" class="btn btn-info btn-md">Acheter</button>
					</div>
				</div>
				<div class="row marginmod2">
					<div class="col-sm-3">+100 XP</div>
					<div class="col-sm-3">
						<img class="imgbonusInvis" src="css/xpUp.png" alt="logo xp up">
					</div>
					<div class="col-sm-3">10 $€</div>
					<div class="col-sm-3">
						<button type="button" class="btn btn-info btn-md">Acheter</button>
					</div>
				</div>
				<div class="row marginmodspec">
					<div class="col-sm-3">+1 LVL</div>
					<div class="col-sm-3">
						<img class="imgbonusInvis" src="css/levelUp.png"
							alt="logo level up">
					</div>
					<div class="col-sm-3">50 $€</div>
					<div class="col-sm-3">
						<button type="button" class="btn btn-info btn-md">Acheter</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /second section -->


	<!-- third section - SnakeInfos -->
	<div id="snakeinfos" class="pad-section">
		<div class="container">
			<div class="row">
				<h1 class="col-md-1 col-md-offset-5">SnakeInfos</h1>
			</div>
			<div class="row marginmod">
				<div class="col-md-6  text-justify">
					<h1>Informations générales</h1>
					<p>
					<ul>
						<li>Pseudo : ${sessionScope.snake.pseudo}</li>
						<li>Level : ${sessionScope.snake.level}</li>
						<li>XP : ${sessionScope.snake.xP}</li>
						<li>Couleur du snake : ${sessionScope.snake.couleur}</li>
						<li>Argent : ${sessionScope.snake.argent}$€</li>
					</ul>
					</p>
				</div>
				<div class="col-md-4 col-lg-offset-2">
					<h1>Bonus</h1>
					<p>
					<ul>
						<li>Bonus récupérés au total :
							${sessionScope.snake.bonusPris}</li>
						<li>Bonus disponibles :</li>
						<ul>
							<li>b1</li>
							<li>b2</li>
							<li>b3</li>
						</ul>
					</ul>
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6  marginmod1 text-justify">
					<h1>Informations détaillées IN-GAME</h1>
					<p>
					<ul>
						<li>Nombre d'ennemis exterminés :
							${sessionScope.snake.nbEnnemisTues}</li>
						<li>Nombre de fois où <b>TU</b> as été exterminé :
							${sessionScope.snake.nbMorts}
						</li>
						<li>Parties gagnées :${sessionScope.snake.partiesGagnees}</li>
						<li>Parties Perdues :${sessionScope.snake.partiesPerdues}</li>
					</ul>
					</p>
				</div>
				<div class="col-md-4 col-md-offset-1  marginmod1 text-justify">
					<h1>Les Snakers inscrits :</h1>
					<p>
					<ul>
						<c:forEach items="${ sessionScope.snakes }" var="snaker"
							varStatus="status">
							<li><c:out value="${ snaker.pseudo } (lvl ${snaker.level})" />
							</li>
						</c:forEach>
					</ul>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- /third section -->
</body>

</html>