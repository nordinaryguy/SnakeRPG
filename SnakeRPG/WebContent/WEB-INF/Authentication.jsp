<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SnakeRPG - Authentication</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="css/styleradiobutton.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="favicon/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="favicon/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="favicon/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="favicon/apple-touch-icon-57-precomposed.png">

</head>

<body>
	<!-- Top content -->
	<div class="top-content">
		<div class="container">

			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 text">
					<img src="images/snakerpg_logo.png" alt="snakelogo">
					<h1>Snake RPG</h1>
					<h2>- The WebApp -</h2>
					<div class="description">
						<p>Bonjour tout le monde ! Bienvenue sur l'application web
							dédiée à votre jeu préféré Snake RPG ! Ici, vous aurez accès à
							toutes vos informations IN GAME :) De plus, un petit SnakeMarket
							(Shop Online) vous permettra d'acheter de nouveaux bonus et/ou de
							l'expérience en dépensant vos $nak€ (Snakeurollars abrégé en $€)
							:D</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-10 col-sm-offset-4 show-forms">
					<span class="show-register-form active">S'enregistrer</span> <span
						class="show-forms-divider">/</span> <span class="show-login-form">Se
						connecter</span>
				</div>
			</div>

			<div class="row register-form">

				<div class="col-sm-4 col-sm-offset-4">
					<form role="form" action="snakerpg_auth" method="post"
						class="r-form">
						<div class="form-group">
							<label class="sr-only" for="r-form-first-name">Pseudo</label> <input
								type="text" name="r-form-first-name" placeholder="Pseudo..."
								class="r-form-first-name form-control" id="r-form-first-name"
								value="" autofocus required>
						</div>
						<div class="form-group">
							<label class="sr-only" for="l-form-password">Mot de passe</label>
							<input type="password" name="l-form-password"
								placeholder="Mot de passe..."
								class="l-form-password form-control" id="l-form-password"
								value="" required>
						</div>
						<div class="form-group">
							<label class="sr-only" for="l-form-confpassword">Confirmation
								du mot de passe</label> <input type="password"
								name="l-form-confpassword"
								placeholder="Confirmation mot de passe..."
								class="l-form-password form-control" id="l-form-confpassword"
								value="" required>
						</div>
						<div class="form-group">
							<h3 class="snakecolorchooser">Choisis la couleur de ton
								Serpent :)</h3>
							<label class="containerradiobutton" style="color: red;">Rouge
								<input type="radio" checked="checked" name="radio" id="red"
								value="red"> <span class="checkmark"></span>
							</label> <label class="containerradiobutton" style="color: black;">
								Noir <input type="radio" name="radio" id="black" value="black">
								<span class="checkmark"></span>
							</label> <label class="containerradiobutton" style="color: green;">Vert
								<input type="radio" name="radio" id="green" value="green">
								<span class="checkmark"></span>
							</label>
						</div>
						<button name="auth" value="enregistrer" type="submit" class="btn">M'enregistrer
							!</button>
					</form>
				</div>
			</div>
			<div class="row login-form">
				<div class="col-sm-4 col-sm-offset-4">
					<form role="form" action="snakerpg_auth" method="post"
						class="l-form">
						<div class="form-group">
							<label class="sr-only" for="l-form-username">Ton Pseudo</label> <input
								type="text" name="l-form-username" placeholder="Pseudo..."
								class="l-form-username form-control" id="l-form-username"
								required>
						</div>
						<div class="form-group">
							<label class="sr-only" for="l-form-password">Mot de passe</label>
							<input type="password" name="l-form-passwordco"
								placeholder="Mot de passe..."
								class="l-form-password form-control" id="l-form-passwordco"
								required>
						</div>
						<button name="auth" value="connecter" type="submit" class="btn">Se
							connecter !</button>
					</form>

				</div>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${not empty erreur}">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<h1
						style="font-size: 50px; color: red; font-weight: bold; background: rgb(54, 25, 25); /* Fall-back for browsers that don't
                                    support rgba */ background: rgba(54, 25, 25, .8); padding: 1em; border: 3px solid black;"">
						<c:out value="${erreur}" />
					</h1>
				</div>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	
	<!-- Footer -->
	<footer>
	<div class="container">
		<div class="row">

			<div class="col-sm-8 col-sm-offset-2">
				<div class="footer-border"></div>
				<p>SnakeRPG WebApp</p>

			</div>

		</div>
	</div>
	</footer>
	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>
	<!-- <script>
			if(${samemdp!=null}){
    			alert(${samemdp});
			}
	</script> -->

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>

</html>