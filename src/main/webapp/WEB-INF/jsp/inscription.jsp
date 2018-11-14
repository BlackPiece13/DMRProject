<%@include file="head.jsp"%>
<body>
	<%@include file="navbar.jsp"%>


	<form class="form-horizontal" action="inscription" method="post">
		<div class="form-group">
			<label class="control-label col-sm-offset-2 col-sm-2" for="email">Email:</label>
			<div class="col-sm-6">
				<input type="email" class="form-control" id="email" name="email"
					placeholder="Enter email">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-offset-2 col-sm-2" for="email">Login:</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="login" name="login"
					placeholder="Enter login">
			</div>
		</div>


		<div class="form-group">
			<label class="control-label col-sm-offset-2 col-sm-2" for="pwd">Password:</label>
			<div class="col-sm-6">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="Enter password">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-10">
				<button type="submit" class="btn btn-success">Inscrire </button>
				<label class="error">  ${error}</label>
			</div>
		</div>
	</form>

</body>
</html>