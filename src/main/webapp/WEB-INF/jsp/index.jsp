<%@page pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="./js/librairie.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
	<c:forEach items="${books}" var="book">
		${book.title}<br>
	</c:forEach>

	<div id="validationMessage"></div>
	<button onclick="sayHello()">hello</button>
	<div class="header">
		<h1>Librairie</h1>
	</div>
	<div class="topnav">
		<input type="text" placeholder="Search..." /> <label class="checkbox">Livre
			<input type="checkbox" checked="checked"> <span
			class="checkmark"></span>

		</label> <label class="checkbox">CD <input type="checkbox"
			checked="checked"> <span class="checkmark"></span>
		</label>
		<c:if test="${empty role}">
			<span id="login" class="topnav-el" style="float: right">Login</span>
		</c:if>

		<c:if test="${not empty role}">
			<a href="logout" id="logout_id" class="topnav-el"
				style="float: right" onclick="deleteCookie('sessionType');">logout</a>
			<c:if test="${role=='admin'}">
				<a href="#" id="add" class="topnav-el" style="float: right">Add</a>

			</c:if>
		</c:if>
		<a href="#" id="order" class="topnav-el" style="float: right">Order</a>
	</div>
	<c:if test="${not empty role}">
		<div id="addMedia" class="popup">
			<form action="addMedia" method="post" enctype="multipart/form-data">
				<label for="title" class="form-label">Titre : </label> <input
					type="text" name="title" class="form-field"> <label
					for="author" class="form-label">Auteur : </label> <input
					type="text" name="author" class="form-field"> <label
					for="abstract" class="form-label">Resume : </label>
				<textarea name="resume" class="form-field"></textarea>
				<label for="cover" class="form-label">Couverture URL : </label> <input
					type="text" name="url" class="form-field" id="cover" accept=".png">
				<input type="submit" value="Ajouter"></input>
			</form>
		</div>
	</c:if>
	<div id="connection" class="popup">
		<form action="login" method="post">
			<label for="login">Login: </label> <input type="text" name="login"
				id="input-login"> <label for="password">Password: </label> <input
				type="text" name="password" id="input-password"> <label
				for="access">Access: </label> <select name="role" id="select-type">
				<option value="admin">Admin</option>
				<option value="user">User</option>
			</select>
			<button id="login">Log !</button>
		</form>
	</div>

	<div class="row">
		<div class="column-25">
			<img src="static/livre.png" width="100%" />
		</div>
		<div class="column-75 end-row">
			<h4>Titre Livre 1</h4>
			<i>de Auteur A</i>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.</p>
			<button id="p1-p" class="user p-button">+</button>
			<input type="text" id="p1-i" class="user media-input" value="0">
			<button id="p1-m" class="user m-button">-</button>
			<button id="p1-c" class="book_button">Modifier</button>
			<button id="p1-r" class="book_button">Supprimer</button>
		</div>



	</div>

	<div class="row">
		<div class="column-25">
			<img src="static/livre.png" width="100%" />
		</div>
		<div class="column-75 end-row">
			<h4>Titre Livre 2</h4>
			<i>de Auteur A, Auteur B</i>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.</p>
			<button id="p2-p" class="user p-button">+</button>
			<input type="text" id="p2-i" class="user media-input" value="0">
			<button id="p2-m" class="user m-button">-</button>
			<button id="p2-c" class="admin">Modifier</button>
			<button id="p2-r" class="admin">Supprimer</button>
		</div>
	</div>


	<div class="row">
		<div class="column-25">
			<img src="static/livre.png" width="100%" />
		</div>
		<div class="column-75 end-row">
			<h4>Titre Livre 3</h4>
			<i>de Auteur C</i>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Duis aute irure dolor in
				reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
				pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
				culpa qui officia deserunt mollit anim id est laborum.</p>
			<button id="p3-p" class="user p-button">+</button>
			<input type="text" id="p3-i" class="user media-input" value="0">
			<button id="p3-m" class="user m-button">-</button>
			<button id="p3-c" class="admin">Modifier</button>
			<button id="p3-r" class="admin">Supprimer</button>
		</div>
	</div>
	<div class="footer">
		<h2>bla bla bla</h2>
	</div>



</body>
</html>