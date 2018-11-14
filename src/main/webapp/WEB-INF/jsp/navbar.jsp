<nav class="navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="index"><span
					class="glyphicon glyphicon-home"></span> Accueil</a></li>
			<c:if test="${empty user}">
				<li><a href="inscription">Inscription</a></li>
			</c:if>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${not empty user}">
					<li><c:if test="${user.role=='admin'}">
							<a data-toggle="modal" data-target="#add-book-modal">Ajouter
								Livre</a></li>
					</c:if>
					<li><a href="logout">Logout</a></li>
				</c:when>
				<c:when test="${empty user}">
					<li><a href="#login-form" data-toggle="collapse">Login</a></li>
				</c:when>
			</c:choose>
			</li>
		</ul>
		<form class="navbar-form navbar-right" action="search">
			<div class="input-group">
				<input type="text" class="form-control input-sm"
					placeholder="Search" id="search-input">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
</nav>

<c:if test="${user.role=='admin'}">
	<!-- Modal -->
	<div id="add-book-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<form class="form-horizontal" action="addMedia" method="post"
							id="add-book-form">
							<div class="form-group">
								<label class="control-label col-sm-4" for="title">Titre:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="title" name="title"
										placeholder="Entrez un titre">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="author">Auteur:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="author"
										id="author" placeholder="Entrez un nom d'auteur">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="resume">Resume:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="resume"
										id="resume" placeholder="Resume">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="url">URL:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="url" id="url"
										placeholder="url">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-2"></div>
								<div class="col-sm-4">
									<label id="error-label"></label>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default" form="add-book-form">Ajouter</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${empty user}">
	<div class="row">
		<div id="login-form" class="collapse">
			<div class="container-fluid">
				<form class="form-horizontal" action="login" method="post">
					<div class="form-group">
						<label class="control-label col-sm-4" for="login">Login:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="login" name="login"
								placeholder="Entrez un login">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" for="password">Mot
							de passe:</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="Entrez un mot de passe">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-2">
							<button class="btn" type="submit" id="login-button">Connecter</button>
						</div>
						<div class="col-sm-4">
							<label id="error-label"></label>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</c:if>
