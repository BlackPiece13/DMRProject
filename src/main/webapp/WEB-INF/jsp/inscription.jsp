<%@page pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="js/librairie.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<div class="header">
		<h1>inscription</h1>
	</div>
	<div>
		<label class="error">${error}</label>
	</div>

	<div id="inscription">
		<form action="inscription" method="post">
			<label for="mail">Mail: </label> <input type="text" name="mail"
				id="input-mail"> <label for="login">Login: </label> <input
				type="text" name="login" id="input-login"> <label
				for="password">Password: </label> <input type="text" name="password"
				id="input-password"> <label for="access">Access: </label> <select
				name="role" id="select-type">
				<option value="admin">Admin</option>
				<option value="user">User</option>
			</select>
			<button id="login">Inscrire</button>
		</form>
	</div>


</body>